import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MonServiceRPCServeur extends UnicastRemoteObject implements MonServiceRPCInterface {
    // Implémentation du serveur pour le service RPC

    private String produit;
    private int prixInitial;
    private int prixActuel;
    private AtomicInteger userCounter; // Compteur pour générer des noms d'utilisateur uniques
    private String meilleurOffreur; // Nom de l'enchérisseur le plus offrant
    private Map<String, Integer> produits; // Liste des produits disponibles
    private ExecutorService executorService;

    // Constructeur du serveur
    protected MonServiceRPCServeur(String produit, int prixInitial) throws RemoteException {
        super();
        this.produit = produit;
        this.prixInitial = prixInitial;
        this.prixActuel = prixInitial;
        this.userCounter = new AtomicInteger(1); // Initialiser le compteur d'utilisateur
        this.meilleurOffreur = null; // Initialiser meilleurOffreur
        this.produits = new HashMap<>();
        this.produits.put(produit, prixInitial); // Ajouter le produit initial à la liste des produits disponibles
        this.executorService = Executors.newSingleThreadExecutor();
    }

    // Méthode pour afficher le produit et son prix initial
    @Override
    public void afficher(String produit, int prixInitial) throws RemoteException {
        System.out.println("Produit : " + produit + ", Prix initial : " + prixInitial);
        this.produit = produit;
        this.prixInitial = prixInitial;
        this.prixActuel = prixInitial;
    }

    // Méthode pour entrer le PRID (identifiant produit)
    @Override
    public void entrerPRID(String utilisateur, int prid) throws RemoteException {
        // Pas besoin d'implémenter cette méthode pour l'instant
    }

    // Méthode pour enchérir sur le produit
    @Override
    public synchronized boolean enchere(String utilisateur, int prix) throws RemoteException {
        if (prix > prixActuel) {
            prixActuel = prix;
            utilisateur = "utilisateur" + userCounter.getAndIncrement(); // Attribuer un nom d'utilisateur unique
            meilleurOffreur = utilisateur; // Mettre à jour meilleurOffreur
            executorService.submit(() -> {
                try {
                    // Attendre 30 secondes avant d'annoncer le gagnant
                    TimeUnit.SECONDS.sleep(30);
                    annoncerGagnant();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("Attendez : 30 secondes jusqu'à ce que d'autres clients soumettent leurs offres.");
            return true;
        }
        return false;
    }

    // Méthode privée pour annoncer le gagnant
    private synchronized void annoncerGagnant() {
        System.out.println("L'offre gagnante est de : " + prixActuel + " euros par " + meilleurOffreur);
        // Logique supplémentaire pour notifier tous les clients de l'offre gagnante, si nécessaire
    }

    // Méthode pour récupérer le prix actuel
    @Override
    public synchronized int getPrixActuel() throws RemoteException {
        return prixActuel;
    }

    // Méthode pour récupérer le gagnant
    @Override
    public synchronized String getGagnant() throws RemoteException {
        return meilleurOffreur;
    }

    // Méthode pour récupérer la liste des produits disponibles
    @Override
    public synchronized Map<String, Integer> getListeProduits() throws RemoteException {
        return produits;
    }

    // Méthode principale pour exécuter le serveur
    public static void main(String[] args) {
        try {
            // Création du serveur avec un produit et un prix initial
            MonServiceRPCInterface monService = new MonServiceRPCServeur("test", 250);

            // Démarrage du registre RMI sur le port 1099
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);

            // Enregistrement du serveur dans le registre RMI
            registry.rebind("MonServiceRPC", monService);

            System.out.println("Serveur RPC prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
