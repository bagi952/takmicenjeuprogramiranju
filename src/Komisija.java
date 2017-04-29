import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Komisija {
    private String ime;
    private String pass;
    DB baza;


    public Komisija(String ime, String pass)
    {
        this.ime = ime;
        this.pass = pass;

        this.logIn();
    }

    public void OdjaviSe()
    {}
    public String spisakRadova()
    {
        return " ";
    }
    public void oceniRad()
    {}

    public String getIme() {
        return ime;
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
                if(rs.getString("ime").equals(this.ime))
                {Metode.ekranKomisije(this);}
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