import java.net.*;/** Ejemplo que implementa un servidor de eco usando UDP. */public class ServidorUDP {
public static void main(String argv[]) {
	if (argv.length != 1) {
		System.err.println("Formato: ServidorUDP <puerto>");
		System.exit(-1);	}		DatagramSocket sDatagram = null;
		try {
		//Cojo el número del puerto
		int puertoServidor = Integer.parseInt(argv[0]);
		
		// Creamos el socket del servidor
		sDatagram = new DatagramSocket(puertoServidor);
		
		// Establecemos un timeout de 30 segs
		sDatagram.setSoTimeout(30000);
				while (true) {
			// Preparamos un datagrama para recepción
			byte array[] = new byte[1024];
			DatagramPacket dGramRec = new DatagramPacket(array, array.length);
			// Recibimos el mensaje
			sDatagram.receive(dGramRec);
			System.out.println("SERVIDOR: recibiendo = "
			+ new String(dGramRec.getData()) + " a "
			+ dGramRec.getAddress().toString() +":"
			+ dGramRec.getPort() );
			// Preparamos el datagrama que vamos a enviar
			DatagramPacket dgramEnv = new DatagramPacket(array, array.length, dGramRec.getAddress(), dGramRec.getPort() );
			// Enviamos el mensaje
			sDatagram.send(dgramEnv);
			System.out.println("SERVIDOR: enviando = "
			+ new String(dgramEnv.getData()) + " a "
			+ dgramEnv.getAddress().toString() +":"
			+ dgramEnv.getPort() );		}
	} catch (SocketTimeoutException e) {		System.err.println("30 segs sin recibir nada");
	} catch (Exception e) {		System.err.println("Error: " + e.getMessage());		e.printStackTrace();
	} finally{		// Cerramos el socket
		sDatagram.close();
	}	

}

}