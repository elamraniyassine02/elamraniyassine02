import java.util.ArrayList;
import java.util.List;

public class Classe_Bibliotheque {
    private List<Classe_Livre> livres; // Liste des livres dans la bibliothèque

    // Constructeur de la classe Bibliotheque
    public Classe_Bibliotheque() {
        livres = new ArrayList<>(); // Initialisation de la liste de livres
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Classe_Livre livre) {
        livres.add(livre); // Ajout du livre à la liste
    }

    // Méthode pour afficher tous les livres de la bibliothèque
    public void afficherLivres() {
        System.out.println("Livres dans la bibliothèque :");
        for (Classe_Livre livre : livres) { // Parcours de la liste des livres
            livre.afficherDetails(); // Affichage des détails de chaque livre
            System.out.println(); // Saut de ligne pour la lisibilité
        }
    }

    // Méthode pour rechercher un livre par auteur
    public void rechercherLivreParAuteur(String nomAuteur) {
        boolean found = false; // Variable pour vérifier si un livre de l'auteur est trouvé
        for (Classe_Livre livre : livres) { // Parcours de la liste des livres
            if (livre.getAuteur().equals(nomAuteur)) { // Vérification de l'auteur du livre
                livre.afficherDetails(); // Affichage des détails du livre
                found = true; // Marquage indiquant qu'au moins un livre de l'auteur a été trouvé
            }
        }
        if (!found) {
            System.out.println("Aucun livre trouvé pour l'auteur " + nomAuteur); // Affichage si aucun livre de l'auteur n'est trouvé
        }
    }

    // Méthode main pour tester la classe Bibliotheque
    public static void main(String[] args) {
        Classe_Bibliotheque bibliotheque = new Classe_Bibliotheque(); // Création d'une instance de la bibliothèque

        // Ajout de quelques livres à la bibliothèque
        bibliotheque.ajouterLivre(new Classe_Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        bibliotheque.ajouterLivre(new Classe_Livre("1984", "George Orwell", 1949));
        bibliotheque.ajouterLivre(new Classe_Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", 1997));

        // Affichage de tous les livres de la bibliothèque
        bibliotheque.afficherLivres();

        // Test de la méthode rechercherLivreParAuteur
        System.out.println("Livres de J.K. Rowling :");
        bibliotheque.rechercherLivreParAuteur("J.K. Rowling");
    }
}
