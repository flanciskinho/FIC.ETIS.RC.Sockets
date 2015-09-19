import java.net.*;import java.io.*; /** Thread que atiende una conexión de un servidor de eco. */
public class ThreadServidor extends Thread {		Socket socket;
	public ThreadServidor(Socket s) {
		// Almacenamos el socket de la conexión		
		socket = s;	}	public void run() {
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
			sEntrada.close();					} catch (SocketTimeoutException e) {
			System.err.println("30 segs sin recibir nada");		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());		} finally {
			// Cerramos el socket
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}		}

	}
	
}