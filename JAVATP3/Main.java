package gestionemploye;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionnaireEmployes gestionnaireEmployes = new GestionnaireEmployes();

        // Menu for operations
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Supprimer un employé");
            System.out.println("3. Afficher la liste des employés");
            System.out.println("4. Quitter");
            System.out.println("Choix:");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choix) {
                case 1:
                    ajouterEmploye(scanner, gestionnaireEmployes);
                    break;
                case 2:
                    supprimerEmploye(scanner, gestionnaireEmployes);
                    break;
                case 3:
                    gestionnaireEmployes.afficherListeEmployes();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

        scanner.close();
    }

    private static void ajouterEmploye(Scanner scanner, GestionnaireEmployes gestionnaireEmployes) {
        // Prompt user to input employee details
        System.out.println("Entrez le nom de l'employé:");
        String nom = scanner.nextLine();

        System.out.println("Entrez le salaire de l'employé:");
        double salaire = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.println("Entrez la date d'embauche de l'employé (format: JJ/MM/AAAA):");
        String dateEmbauche = scanner.nextLine();

        // Prompt user to input employee type
        System.out.println("Entrez le type d'employé (directeur/secretaire/employe):");
        String employeeId = scanner.nextLine();

        // Create employee object with user input including payroll details
        Employe employe = createEmployee(scanner, nom, salaire, dateEmbauche, employeeId);

        // Add employee to the manager
        gestionnaireEmployes.ajouterEmploye(employe);
    }

    private static void supprimerEmploye(Scanner scanner, GestionnaireEmployes gestionnaireEmployes) {
        // Prompt user to input the name of the employee to delete
        System.out.println("Entrez le nom de l'employé à supprimer:");
        String nom = scanner.nextLine();

        // Delete the employee
        gestionnaireEmployes.supprimerEmploye(nom);
    }

    private static Employe createEmployee(Scanner scanner, String nom, double salaire, String dateEmbauche, String employeeId) {
        double hours;
        double hourlyRate;

        // Prompt user to input payroll details
        System.out.println("Entrez le nombre d'heures travaillées:");
        hours = scanner.nextDouble();

        System.out.println("Entrez le taux horaire:");
        hourlyRate = scanner.nextDouble();

        // Create employee object with user input including payroll details
        return new Employe(nom, salaire, dateEmbauche, employeeId, hours, hourlyRate);
    }
}
