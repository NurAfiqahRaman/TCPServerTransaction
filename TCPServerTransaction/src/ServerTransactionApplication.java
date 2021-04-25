import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTransactionApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerTransactionFrame serverFrame = new ServerTransactionFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 1123;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		TransactionReceipt rc=new TransactionReceipt();
		
		String orderID="7019";
		String orderName="chocolate sundae";
		String methodPayment="Credit Card";
		String cardNumber="7786";
		String dateTrans="25/4/2021";
		String amountTrans="RM9.50";
		String transRefNo="210";
		String orderRefNo="15";
		
		rc.Receipt(orderID, orderName, methodPayment, cardNumber, amountTrans, transRefNo, orderRefNo);
		
		// Counter to keep track the number of requested connection
				int totalRequest = 0;
				
		// Server needs to be alive forever
		while (true) {
					
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
					
					
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
			new DataOutputStream(clientSocket.getOutputStream());
						
			// Send current data back to the client
			outputStream.writeUTF(orderID);
			outputStream.writeUTF(orderName);
			outputStream.writeUTF(dateTrans);
			outputStream.writeUTF(amountTrans);
			outputStream.writeUTF(cardNumber);
			outputStream.writeUTF(orderRefNo);
			outputStream.writeUTF(transRefNo);
			
			// Close the socket
			clientSocket.close();
					
			
						
					
		}
	}
					
		

}
