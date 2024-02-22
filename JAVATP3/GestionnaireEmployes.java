package gestionemploye;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionnaireEmployes {
    private List<Employe> listeEmployes;

    public GestionnaireEmployes() {
        this.listeEmployes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    public void supprimerEmploye(String nom) {
        Iterator<Employe> iterator = listeEmployes.iterator();
        while (iterator.hasNext()) {
            Employe employe = iterator.next();
            if (employe.getNom().equals(nom)) {
                iterator.remove();
                System.out.println("L'employé " + nom + " a été supprimé.");
                return;
            }
        }
        System.out.println("L'employé " + nom + " n'a pas été trouvé.");
    }

    public void afficherListeEmployes() {
        if (listeEmployes.isEmpty()) {
            System.out.println("Aucun employé dans la liste.");
        } else {
            System.out.println("Liste des employés:");
            for (Employe employe : listeEmployes) {
                System.out.println("Nom: " + employe.getNom() + ", Salaire: " + employe.getSalary());
            }
        }
    }
}
