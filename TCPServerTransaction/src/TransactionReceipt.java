import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionReceipt {
	public void Receipt(String oID, String oName, String mPayment, String cNumber, String aTrans, String tRefNo,String oRefNo ) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	
	    // Declaration of target storage
	    String orderID=oID;
	    String orderName=oName;
	    String methodP=mPayment;
	    String cardNo=cNumber;
	    String amountT=aTrans;
	    String transRefNo=tRefNo;
	    String orderRefNo=oRefNo;
	    String transactionDate=formatter.format(date);
	    String targetStorage = String.valueOf(orderID);
	
	    // Declaration of writer stream object
	    Writer wr;
	    
	    String message1="\n\n\tOrder ID : ";
	    String message2="\n\n\tTransaction Date : ";
	    String message3="\n\n\tOrder Name :";
	    String message4="\n\n\tMethod Payment :";
	    String message7="\n\n\tLast 4 card Number : ";
	    String message5="\n\n\tTransaction Reference No : ";
	    String message6="\n\n\tOrder Reference No : ";
	    
	
	    System.out.println("Generate receipt");
	
	    try {
		
	    	// Create an output stream between this file and targetStorage
	    	wr = new FileWriter(targetStorage);
	    	wr.write(message1);
	    	wr.write(orderID);
	    	
	    	wr.write(message2);
	    	wr.write(transactionDate);
	    	
	    	wr.write(message3);
	    	wr.write(orderName);
	    	
	    	wr.write(message4);
	    	wr.write(methodP);
	    	
	    	wr.write(message7);
	    	wr.write(cardNo);
	    	
	    	wr.write(message5);
	    	wr.write(transRefNo);
	    	
	    	wr.write(message6);
	    	wr.write(orderRefNo);
	    	
	    	
	    	wr.flush();
					
	    	// Close the stream
	    	wr.close();  
         
	    	} catch (IOException e) {
		
	    		e.printStackTrace();
	}  
	
	    // Indicate end of program - Could be succcessful
	    System.out.println("\nSuccessfully generate.\n\n");
	    System.out.println("Right click on TCPServerTransaction. Select Refresh.\n");
	    System.out.println(targetStorage + " should be there. Check it out!");   

	}

}
