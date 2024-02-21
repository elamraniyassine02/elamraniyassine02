public class Classe_Livre {
    // Attributs
    private final String titre; // Titre du livre
    private final String auteur; // Auteur du livre
    private final int anneePublication; // Année de publication du livre

    // Constructeur de la classe Livre
    public Classe_Livre(String titre, String auteur, int anneePublication) {
        // Vérification des informations du livre
        if (titre == null || auteur == null || anneePublication <= 0) {
            throw new IllegalArgumentException("Les informations du livre sont invalides");
        }
        // Initialisation des attributs
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    // Méthodes

    // Méthode pour afficher les détails du livre
    public void afficherDetails() {
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Année de publication: " + anneePublication);
    }

    // Méthode pour obtenir le nom de l'auteur du livre
    public String getAuteur() {
        return auteur;
    }
}
