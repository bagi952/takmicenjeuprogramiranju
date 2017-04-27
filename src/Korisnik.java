import java.util.Scanner;

public class Korisnik {
    Takmicar t;
    Komisija k;
    Administrator r;
    Scanner scan = new Scanner(System.in);


    public void login() {
        Scanner scan = new Scanner(System.in);
        int izbor = scan.nextInt();

        switch (izbor) {
            case 1:
                System.out.println("\nUnesite ime i pass razdvojene enterom");
                String ime = scan.next();
                String pass = scan.next();
                t = new Takmicar(ime,pass);
                break;
            case 2:
                Komisija.logIn();
                break;
            case 3:
                Administrator.logIn();
                break;
            case 0:
                System.out.println("Vracate se u glavni meni");
                Metode.glavniMeni();
                break;
            default:
                System.out.println("probajte opet\n\n");
                this.login();
        }

    }
}