import java.io.IOException;
import java.util.Scanner;

public class Metode {
    static Scanner scan = new Scanner(System.in);
    private static String putanjaZaTakmicara;

    public static void glavniMeni() {

        System.out.println("----- Dobro dosli---");

        System.out.println("0 - IZLAZ\n" + "l - Login\n" + "2 - Rang Lista");

    }

    public static void ekranTakmicara(Takmicar takmicar) {
        System.out.println("Dobrodosao " + takmicar.getIme()+"\n\n");
        System.out.println("Unesi putanju svog rada: ");
        putanjaZaTakmicara = scan.next();
        if(!putanjaZaTakmicara.equals(null) || !putanjaZaTakmicara.equals(""))
        {
            takmicar.setPutanja(putanjaZaTakmicara);
        }
        else
            System.out.println("Ne moze biti prazno...");
    }
}