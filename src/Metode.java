import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.Scanner;

public class Metode {
    static Scanner scan = new Scanner(System.in);
    private static String putanjaZaTakmicara;
    private static DB baza;
    private static Connection con = null;
    private static Statement stmt = null;
    private static String upit;

    public static void glavniMeni() {

        System.out.println("----- Dobro dosli---");

        System.out.println("0 - IZLAZ\n" + "l - Login\n" + "2 - Rang Lista");

    }

    public static void ekranTakmicara(Takmicar takmicar) {
        System.out.println("Dobrodosao " + takmicar.getIme() + "\n\n");
        System.out.println("Za unos putanje unesi 'p' za pregled ocene unesi 'o'za logout unesite 'logout': ");
        String izbor;

        while (!(izbor = scan.next()).toLowerCase().equals("logout")) {
            if (izbor.equals("p")) {
                System.out.println("---Unesi putanju do file sa ekstenzijom: ");
                putanjaZaTakmicara = scan.next();
                if (!putanjaZaTakmicara.equals(null) || !putanjaZaTakmicara.equals("")) {
                    takmicar.setPutanja(putanjaZaTakmicara);
                } else {
                    System.out.println("---Potrebna je putanja do file, sa ekstenzijom!!!");
                }
            } else //za pregled ocene
            {
                if (takmicar.getOcena() == 0) {
                    System.out.println("---Vas rad jos uvek nije ocenjen---");
                } else {
                    System.out.println("Vasa ocena je: --- " + takmicar.getOcena() + " ---");

                }
            }
            System.out.println("Za unos putanje unesi 'p' za pregled ocene unesi 'o'za logout unesite 'logout': ");

        }
        Metode.glavniMeni();

    }

    public static void login(String ime, String pass) {

        if (ime.length() > 3) {
            if (ime.charAt(0) == 't') // za takmicara
            {
                Takmicar t = new Takmicar(ime, pass);
            } else if (ime.charAt(0) == 'k') //za komisiju
            {
                Komisija k = new Komisija(ime, pass);
            } else if(ime.charAt(0) == 'a')// za admina
            {
                Administrator a = new Administrator(ime, pass);
            }
        }
        else
        {
            System.out.println("ime mora biti duze od 3 karaktera i/ili da pocinje sa T, K ili A");
            Metode.glavniMeni();

        }
    }

    public static void listAllStudents() {
        try
        {
            baza = DB.getInstance();
            con = (Connection) baza.getConnection();
            stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM takmicar";
            ResultSet rs = stmt.executeQuery(upit);
            while(rs.next())
            {

                System.out.println("Ime: "+rs.getString("ime") + " Zbir: " +
                        (rs.getInt("kvalitetkoda")+
                                rs.getInt("tacnost")+rs.getInt("opstiUtisak"))  +
                        " Ocena: " +rs.getInt("ocena"));
            }
            Metode.glavniMeni();
        }catch(Exception e)
        {
            System.out.println("Error...@" + e.getMessage());

        }
        finally {
            baza.putConnection(con);
        }
    }

    public static void ekranKomisije(Komisija komisija) {
        System.out.println("Dobrodosli " +komisija.getIme());
        System.out.println("-ODJAVI SE - 0\n-PRIKAZI SPISAK RADOVA 1\n-OCENI RAD 2");
        int izbor;
        while((izbor =scan.nextInt()) !=0)
        {
            if(izbor == 1)
            {
                try
                {
                File folder = new File("zadaci");

                for(int i = 0;i<folder.listFiles().length;i++)
                {
                    if(!folder.listFiles()[i].isDirectory())
                        System.out.println((i+1)+". "+folder.listFiles()[i].getName());
                }
                    System.out.println("\n");

                }
                catch(Exception e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
                System.out.println("-ODJAVI SE - 0\n-PRIKAZI SPISAK RADOVA 1\n-OCENI RAD 2");

            }
            if(izbor == 2)
            {
                System.out.println("Unesite ime takmicara kog zelite da ocenite: ");
                Takmicar ocenjenTakmicar = new Takmicar(scan.next());
                String naziv;
                FileInputStream fis = null;

                try
                {
                    File folder = new File("zadaci");


                    for(int i = 0;i<folder.listFiles().length;i++)
                    {
                        naziv =  folder.listFiles()[i].getName().substring(0,folder.listFiles()[i].getName().length()-4);
                        System.out.println("------"+naziv+"------");
                        if(!folder.listFiles()[i].isDirectory() && naziv.equals(ocenjenTakmicar.getIme()))
                        {

                            fis = new FileInputStream("zadaci/"+ocenjenTakmicar.getIme()+".txt");
                            int c;
                            while((c=fis.read())!= -1)
                            {
                                System.out.print((char)c);
                            }
                                System.out.println("Unesite ocenu za kvalitet koda: ");
                                ocenjenTakmicar.setKvalitetKoda(scan.nextInt());
                            System.out.println("Unesite ocenu za tacnost koda: ");
                            ocenjenTakmicar.setTacnost(scan.nextInt());
                            System.out.println("Unesite ocenu za opsti utisak rada: ");
                            ocenjenTakmicar.setOpstiUtisak(scan.nextInt());
                            ocenjenTakmicar.setOcena(Math.round((ocenjenTakmicar.getKvalitetKoda()+ocenjenTakmicar.getOpstiUtisak()+ocenjenTakmicar.getTacnost())/3)) ;


                            Metode.oceniRad(ocenjenTakmicar);

                            break;
                        }

                    }
                    System.out.println("\n");

                }
                catch(Exception e)
                {
                    System.out.println("Error: " + e.getMessage());
                }



                System.out.println("-ODJAVI SE - 0\n-PRIKAZI SPISAK RADOVA 1\n-OCENI RAD 2");

            }

        }
            Metode.glavniMeni();
    }

    private static void oceniRad(Takmicar t) {
        try
        {


            baza = DB.getInstance();
            con = (Connection) baza.getConnection();
            stmt = (Statement) con.createStatement();
            upit = "UPDATE takmicar SET kvalitetKoda="+t.getKvalitetKoda()+", tacnost="+t.getTacnost()+", opstiUtisak="+t.getOpstiUtisak()+", ocena="+t.getOcena()+", ocenjen='da' WHERE ime='"+t.getIme()+"';";
            stmt.executeUpdate(upit);
            System.out.println("Ocene unete u bazu...");
        }
        catch(Exception e)
        {
            System.out.println("Greska pri ocenjivanju... " + e.getMessage());
        }
        finally {
            baza.putConnection(con);
        }

    }
}