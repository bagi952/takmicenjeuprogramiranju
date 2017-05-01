import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Administrator {
    private String ime;
    private String pass;


    public Administrator(String ime, String pass)
    {
        this.ime = ime;
        this.pass = pass;

        this.logIn();
    }
    public void izlogujSe()
    {}

    public String dodajTakmicara()
    {
        return "takmicar dodat";
    }

    public String dodajKomisiju()
    {
        return "Clan komisije dodat";
    }

    public String obrisiKorisnika()
    {
        return "Korisnik obrisan";
    }

    public String getIme() {
        return ime;
    }

    public void logIn() {
        DB baza = null;
        Connection con = null;
        try{
            baza = DB.getInstance();
            con = (Connection) baza.getConnection();
            Statement stmt = (Statement) con.createStatement();
            String upit = "SELECT * FROM administratori WHERE ime='"+ime+"' AND pass='"+pass+"'";
            ResultSet rs = stmt.executeQuery(upit);

            if(rs.next()){
                if(rs.getString("ime").equals(this.ime))
                {
                    Metode.ekranAdministratora(this);
                }
            }
            else
            {
                System.out.println("Podaci nisu dobri");
                Metode.glavniMeni();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Greska pri logovanju kod admina: " + e.getMessage());
        }
        finally {
            baza.putConnection(con);
        }

    }

}