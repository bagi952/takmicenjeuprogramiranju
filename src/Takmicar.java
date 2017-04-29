
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Takmicar {
    private String ime;
    private String pass;
    DB baza;
    private String putanjaDoFajla;
    private int id;
    private int ocenjen;
    private int kvalitetKoda;
    private int tacnost;
    private int opstiUtisak;
    private int ocena;

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public String getPutanjaDoFajla() {
        return putanjaDoFajla;
    }

    public void setPutanjaDoFajla(String putanjaDoFajla) {
        this.putanjaDoFajla = putanjaDoFajla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOcenjen() {
        return ocenjen;
    }

    public void setOcenjen(int ocenjen) {
        this.ocenjen = ocenjen;
    }

    public int getKvalitetKoda() {
        return kvalitetKoda;
    }

    public void setKvalitetKoda(int kvalitetKoda) {
        this.kvalitetKoda = kvalitetKoda;
    }

    public int getTacnost() {
        return tacnost;
    }

    public void setTacnost(int tacnost) {
        this.tacnost = tacnost;
    }

    public int getOpstiUtisak() {
        return opstiUtisak;
    }

    public void setOpstiUtisak(int opstiUtisak) {
        this.opstiUtisak = opstiUtisak;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }





    public Takmicar(String ime, String pass)
    {
        this.ime = ime;
        this.pass = pass;

        this.logIn();
    }

    public String getPutanja()
    {
        return putanjaDoFajla;
    }

    public void setPutanja(String p)
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        this.putanjaDoFajla = p;
        try
        {

             fis = new FileInputStream(putanjaDoFajla);
             fos = new FileOutputStream("zadaci/"+this.ime+".txt");
            byte[] buffer = new byte[1024];
            int length;
            while((length = fis.read(buffer))>0)
            {

                fos.write(buffer,0,length);
            }
            System.out.println("Kopiranje zavrseno :) ");
        }
        catch(IOException e)
        {
            System.out.println("Error... " + e.getMessage());
        }
        finally {
            if(fis != null && fos != null)
            {

                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error in closing streams: " + e.getMessage());
                }
            }
        }

    }
    public String getIme() {
        return this.ime;
    }

    private void logIn()
    {
        try{
            baza = DB.getInstance();
            Connection con = (Connection) baza.getConnection();
            Statement stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM takmicar WHERE ime='"+ime+"' AND pass='"+pass+"'";
            ResultSet rs = stmt.executeQuery(upit);

            if(rs.next()){
                this.setId(rs.getInt("id"));
                this.setKvalitetKoda(rs.getInt("kvalitetKoda"));
                this.setOcena(rs.getInt("ocena"));
                this.setOpstiUtisak(rs.getInt("opstiUtisak"));
                this.setOcenjen(rs.getInt("ocenjen"));
                this.setTacnost(rs.getInt("tacnost"));

                if(rs.getString("ime").equals(this.ime))
                {Metode.ekranTakmicara(this);}
            }
            else
            {
                System.out.println("Podaci nisu dobri");
                Metode.glavniMeni();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }


    }




}