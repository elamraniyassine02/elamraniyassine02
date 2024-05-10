import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MonServiceRPCClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MonServiceRPCInterface monService = (MonServiceRPCInterface) registry.lookup("MonServiceRPC");
            int somme = monService.addition(5, 3);
            int produit = monService.multiplication(4, 6);
            System.out.println("Somme : " + somme);
            System.out.println("Produit : " + produit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
