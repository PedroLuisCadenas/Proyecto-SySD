import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

	public static void main(String[] args) throws RemoteException, IOException {
		
		// Inicio del registro RMI
		LocateRegistry.createRegistry(1099); // Puerto default
		
		
		RMIImplementacion pt = new RMIImplementacion();
		// Registrar el objeto remoto
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind("RMI", pt);
		System.out.println("Servidor listo");

		//Crear un hilo para manejar las solicitudes de los clientes
		new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
	}

}

