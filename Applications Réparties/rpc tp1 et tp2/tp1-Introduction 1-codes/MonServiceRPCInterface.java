import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonServiceRPCInterface extends Remote {
    int addition(int a, int b) throws RemoteException;
    int multiplication(int a, int b) throws RemoteException;
}
