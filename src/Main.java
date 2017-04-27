import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Korisnik kor = new Korisnik();
        // DB con = DB.getInstance();
        int izbor;
        Scanner scan = new Scanner(System.in);
        Metode.glavniMeni();
        while ((izbor = scan.nextInt()) != 0) {
            if (izbor == 1) {
                System.out.println("Za takmicara unesite 1\n" + "Za Komisiju 2\n" + "Za Administratora 3\n\n");
                kor.login();

            }
            if (izbor == 2) {

            }

        }
        System.out.println("\n\nhvala sto ste koristili nasu aplikaciju\n\n----- PRIJATAN DAN----- \n\n");
    }

}