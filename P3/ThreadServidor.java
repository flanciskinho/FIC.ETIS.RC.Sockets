import java.net.*;
public class ThreadServidor extends Thread {
	public ThreadServidor(Socket s) {
		// Almacenamos el socket de la conexión		
		socket = s;
		try {
			// Establecemos el canal de entrada
			BufferedReader sEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Establecemos el canal de salida
			PrintWriter sSalida = new PrintWriter(socket.getOutputStream(), true);
			// Recibimos el mensaje del cliente
			String menCliente = sEntrada.readLine();
			// Enviamos el eco al cliente
			sSalida.println();
			// Cerramos los flujos
			sSalida.close();
			sEntrada.close();			
			System.err.println("30 segs sin recibir nada");
			System.err.println("Error: " + e.getMessage());
			// Cerramos el socket
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
	
}