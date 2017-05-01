import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int izbor;
        Scanner scan = new Scanner(System.in);
        Metode.glavniMeni();
        while ((izbor = scan.nextInt()) != 0) {
            if (izbor == 1) {
                System.out.println("Unesite ime: ");
                String ime = scan.next();
                System.out.println("Unesite pass");
                String pass = scan.next();
               Metode.login(ime, pass);

            }
            if (izbor == 2) {
                Metode.listAllStudents();
            }

        }
        System.out.println("\n\nhvala sto ste koristili nasu aplikaciju\n\n----- PRIJATAN DAN----- \n\n");
    }

}