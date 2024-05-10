import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

public class MonServiceRPCClient {
    // Classe pour le client du service RPC

    public static void main(String[] args) {
        try {
            // Récupération du registre RMI à partir de l'adresse locale et du port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MonServiceRPCInterface monService = (MonServiceRPCInterface) registry.lookup("MonServiceRPC");

            Scanner scanner = new Scanner(System.in);

            // Récupérer la liste des produits disponibles sur le serveur
            Map<String, Integer> produits = monService.getListeProduits();

            // Afficher les produits disponibles avec leurs prix initiaux
            System.out.println("Produits disponibles pour l'enchère :");
            for (Map.Entry<String, Integer> entry : produits.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + " euros");
            }

            // Demander à l'utilisateur de choisir un produit
            System.out.print("Entrez le nom du produit sur lequel vous souhaitez enchérir : ");
            String produitChoisi = scanner.nextLine();

            // Vérifier si le produit choisi existe dans la liste des produits disponibles
            if (produits.containsKey(produitChoisi)) {
                int prixInitial = produits.get(produitChoisi);

                boolean enchereAcceptee = false;
                while (!enchereAcceptee) {
                    System.out.print("Entrez votre enchère : ");
                    int prixEnchere = scanner.nextInt();
                    enchereAcceptee = monService.enchere("Utilisateur 1", prixEnchere);
                    if (!enchereAcceptee) {
                        System.out.println("Votre enchère doit être supérieure au prix actuel.");
                    }
                }
                // Affichage du message d'attente
                System.out.println("Veuillez patienter : 30 secondes pour que d'autres clients soumettent leurs offres.");

                // Attendre pendant 30 secondes
                Thread.sleep(30000);

                // Maintenant, nous récupérons l'offre gagnante du serveur
                int prixActuel = monService.getPrixActuel();
                String gagnant = monService.getGagnant();
                System.out.println("L'offre gagnante est de : " + prixActuel + " euros par " + gagnant);
            } else {
                System.out.println("Le produit choisi n'est pas disponible pour l'enchère.");
            }

            scanner.close(); // Fermer le scanner après utilisation
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
