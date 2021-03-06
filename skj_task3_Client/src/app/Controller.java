package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller 
implements Initializable
{

	
    @FXML
    private TextField fxIn;

    @FXML
    private TextArea fxOut;
    
    public void keyAction(KeyEvent ke){
//    	if( (ke.getCharacter() ).charAt(0) == ( '\n' ) )
//    		System.out.print( "ENTER" );
//    	if( ke.getText().equals( "\n" ) )
//    		System.out.print( "ENTER2" );
//    	if(ke.getCode() == KeyCode.ENTER)
//    		System.out.print( "ENTER3" );
    	
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fxOut.setStyle("-fx-base: #6b6968;"+
		    "-fx-font-size: 10pt;"+
		    "-fx-font-family: \"Segoe UI Semibold\";"+
		    "-fx-text-fill: white;"+
			"-fx-border-color: black;"+
		    "-fx-border-width: 4px;"+
		    "-fx-control-inner-background: #353432;");
		fxIn.setStyle("-fx-background-color: #464542;"+
				"-fx-text-fill: white;"+
			    "-fx-font-size: 13pt;"+
			    "-fx-font-family: \"Segoe UI Semibold\";"+
			   	"-fx-border-color: black;"+
			    "-fx-border-width: 4px;"+
			    "-fx-border-radius: 0 0 0 0;"+
			  	"-fx-background-radius: 0 0 0 0;");
		String start = "";
		start += (". Controller constructor\n");
		start += (". GUI\n");
		start += (". styles\n");
		start += (". main start\n\n");
		
		start += ("D N S _ K I L L A _ H E A R ! \n");
		start += ("( easy dns client )\n");
		start += ("- greetings master!\n");
		start += ("- enter the adress you want to serch with DNS\n");
		start += ("- and type ENTER button\n");
		start += ("\n"+"- thanks for choosing our program services \n");

		fxOut.setText(start);
		
		fxIn.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent) {
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		        	
		            String host = fxIn.getText();
		            String text = DNSClient.magic(host);
		            if(text.equals(""))
		            	fxOut.setText("ERR !");
		            else
		            	fxOut.setText(text);
		        }
		    }
		});
		fxOut.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent) {
				fxIn.requestFocus();
		    }
		});
	}
	
	//fxOut.setDisable(true);
	
    public Controller(){
    	System.out.println(". Controller constructor");
    }
}