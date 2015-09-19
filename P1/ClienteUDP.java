import java.net.*;

/** Ejemplo que implementa un cliente de eco usando UDP. */

public class ClienteUDP {
	
	public static void main(String argv[]) {
		if (argv.length != 3) {
			System.exit(-1);
		
		DatagramSocket sDatagram = null;
		
		try {
			
		// (en cualquier puerto libre)
		sDatagram = new DatagramSocket();
		
		// Establecemos un timeout de 30 segs
		
		// Obtenemos la dirección IP del servidor
		// (recibida en el primer argumento por linea de comandos)
		InetAddress dirServidor = InetAddress.getByName(argv[0]);
		// Obtenemos el puerto del servidor
		// (recibido en el segundo argumento por linea de comandos)
		int puertoServidor = Integer.parseInt(argv[1]);
		// Obtenemos el mensaje
		// (tercer argumento de la linea de comandos)
		String mensaje = argv[2];
		
		// Preparamos el datagrama que vamos a enviar y lo enviamos
			mensaje.getBytes().length, dirServidor, puertoServidor);
		
		// Enviamos el datagrama
		System.out.println("CLIENTE: Enviando "
			+ dgramEnv.getAddress().toString() + ":"
			+ dgramEnv.getPort());
			
		// Preparamos el datagrama de recepción
		DatagramPacket dgramRec = new DatagramPacket(array, array.length);
		// Recibimos el mensaje
		sDatagram.receive(dgramRec);
		System.out.println("CLIENTE: Recibido "
			+ " de " + dgramRec.getAddress().toString() + ":"
			+ dgramRec.getPort());
		
		} catch (SocketTimeoutException e) {
			System.err.println("30 segs sin recibir nada");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
		}
	}
}