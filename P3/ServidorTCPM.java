import java.net.*; /** Ejemplo que implementa un servidor de eco usando TCP. */ 

public class ServidorTCPM {public static void main(String argv[]) {
	if (argv.length != 1) {
		System.err.println("Formato: ServidorTCP <puerto>");
		System.exit(-1);	}	ServerSocket socket = null;	try {
		// Creamos el socket del servidor
		int puertoS = Integer.parseInt(argv[0]);
		socket = new ServerSocket(puertoS);
		// Establecemos un timeout de 30 segs
		socket.setSoTimeout(30000);
		while (true) {
			// Esperamos posibles conexiones
			Socket asike = socket.accept();
			// Creamos un objeto ThreadServidor, pasándole la nueva conexión
			ThreadServidor fio = new ThreadServidor(asike);
			// Iniciamos su ejecución con el método start()
			fio.start();		} 
	} catch (SocketTimeoutException e) {		System.err.println("30 segs sin recibir nada");
	} catch (Exception e) {		System.err.println("Error: " + e.getMessage());
		e.printStackTrace();	} finally{
		//Cerramos el socket del servidor
		try {
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	}
}

}