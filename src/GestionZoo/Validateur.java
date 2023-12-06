package src.GestionZoo;

import java.util.Scanner;

public class Validateur {
    public static String saisirInfoValide(String message, String erreurLongueur, String erreurCaractere, Scanner scanner, Validator validator) {
        String info;
        boolean valide;
        do {
            System.out.print(message);
            info = scanner.nextLine();
            valide = validator.valider(info);

            if (!valide) {
                if (info.length() <= 3) {
                    System.out.println(erreurLongueur);
                } else {
                    System.out.println(erreurCaractere);
                }
            }
        } while (!valide);
        return info;

    }

    public static int saisirAge(Scanner scanner) {
        int age;
        do {
            System.out.print("Entrez votre âge : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide pour l'âge.");
                scanner.next();
            }
            age = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le saut de ligne
        } while (age < 18 || age == 89 || age > 89);
        return age;
    }
}

interface Validator {
    boolean valider(String input);
}
