import java.net.*;

	if (argv.length != 1) {
		System.err.println("Formato: ServidorUDP <puerto>");
		System.exit(-1);
	
		//Cojo el número del puerto
		int puertoServidor = Integer.parseInt(argv[0]);
		
		// Creamos el socket del servidor
		sDatagram = new DatagramSocket(puertoServidor);
		
		// Establecemos un timeout de 30 segs
		sDatagram.setSoTimeout(30000);
		
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
			+ dgramEnv.getPort() );
	} catch (SocketTimeoutException e) {
	} catch (Exception e) {
	} finally{
		sDatagram.close();
	}	

}

}