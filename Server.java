import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry
            LocateRegistry.createRegistry(1099);

            HelloImpl obj = new HelloImpl();

            // Bind object to RMI registry
            Naming.rebind("rmi://localhost:1099/HelloService", obj);

            System.out.println("Server Ready");
        } 
        catch (RemoteException | java.net.MalformedURLException e) {
            System.out.println("Server error: " + e);
        }
    }
}