import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.util.Scanner;

public class Metode {
    static Scanner scan = new Scanner(System.in);
    private static String putanjaZaTakmicara;
    private static DB baza;

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
            Connection con = (Connection) baza.getConnection();
            Statement stmt = (Statement) con.createStatement();
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
    }

    public static void ekranKomisije(Komisija komisija) {
        System.out.println("Dobrodosli " +komisija.getIme());
        System.out.println("-ODJAVI SE - 0\n-PRIKAZI SPISAK RADOVA 1\n-OCENI RAD 2");
        int izbor;
        while((izbor =scan.nextInt()) !=0)
        {
            if(izbor == 1)
            {
                //spisak radova
            }
            if(izbor == 2)
            {
                //oceni rad
            }

        }    }
}