import java.net.*;
import java.io.*;

	
	if (argv.length != 1) {
		System.exit(-1);
	
	ServerSocket socket = null;
	
		int puertoServidor = Integer.parseInt(argv[0]);
		// Creamos el socket del servidor
		socket = new ServerSocket(puertoServidor);
		// Establecemos un timeout de 30 segs
		socket.setSoTimeout(30000);
		
		while (true) {
			Socket asike = socket.accept();	
			// Establecemos el canal de entrada (Lo que recibe el servidor)
			BufferedReader sEntrada = new BufferedReader(new InputStreamReader(asike.getInputStream()));
			// Establecemos el canal de salida (Es la respuesta del servidor)
			PrintWriter sSalida = new PrintWriter(asike.getOutputStream(), true);
			// Recibimos el mensaje del cliente
			String menCliente = sEntrada.readLine();
			System.out.println("SERVIDOR: Recibido " + menCliente);
			// Enviamos el eco al cliente
			sSalida.println(menCliente);
			System.out.println("SERVIDOR: Enviando " + menCliente);
			// Cerramos los flujos
			sSalida.close();
			sEntrada.close();
	} catch (SocketTimeoutException e) {
	} catch (Exception e) {
		//Cerramos el socket
		try {
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

}