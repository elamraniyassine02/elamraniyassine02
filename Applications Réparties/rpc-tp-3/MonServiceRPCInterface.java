import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface MonServiceRPCInterface extends Remote {
    // Déclaration des méthodes disponibles pour le service RPC

    // Affiche le produit et son prix initial
    void afficher(String produit, int prixInitial) throws RemoteException;

    // Entrée du PRID (identifiant produit) par l'utilisateur
    void entrerPRID(String utilisateur, int prid) throws RemoteException;

    // Enchère sur le produit par l'utilisateur avec un certain prix
    boolean enchere(String utilisateur, int prix) throws RemoteException;

    // Récupère le prix actuel de l'enchère
    int getPrixActuel() throws RemoteException;

    // Récupère le gagnant de l'enchère
    String getGagnant() throws RemoteException;

    // Récupère la liste des produits disponibles pour l'enchère
    Map<String, Integer> getListeProduits() throws RemoteException;
}
