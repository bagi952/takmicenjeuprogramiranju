import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Takmicar {
    private String ime;
    private String pass;
    DB baza;
    private String putanjaDoFajla;
    private Takmicar t;


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
        this.putanjaDoFajla = p;
        try
        {

            //DODATI KOD ZA KOPIRANJE
            System.out.println("Zavressno kopiranje");
            Metode.glavniMeni();
        }
        catch(Exception e)
        {
            System.out.println("Error... " + e.getMessage());
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
            System.out.println("eror");
        }


    }




}