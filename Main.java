public class Main {
    public static void main(String[] args) {
        // Création d'une instance de la classe Bibliotheque
        Classe_Bibliotheque bibliotheque = new Classe_Bibliotheque();

        // Ajout de quelques livres à la bibliothèque
        bibliotheque.ajouterLivre(new Classe_Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        bibliotheque.ajouterLivre(new Classe_Livre("1984", "George Orwell", 1949));
        bibliotheque.ajouterLivre(new Classe_Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", 1997));

        // Affichage des détails de tous les livres présents dans la bibliothèque
        bibliotheque.afficherLivres();
    }
}
