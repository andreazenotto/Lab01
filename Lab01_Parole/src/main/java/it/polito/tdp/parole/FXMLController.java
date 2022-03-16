package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtTime;
    
    String descriveList() {
    	String stringa = "";
    	for(String s: this.elenco.getElenco()) {
    		if(stringa.compareTo("")!=0)
    			stringa += "\n";
    		stringa += s;
    	}
    	return stringa;
    }

    @FXML
    void doInsert(ActionEvent event) {
    	this.elenco.addParola(this.txtParola.getText());
    	this.txtParola.setText("");
    	this.txtResult.setText(this.descriveList());
    	this.txtTime.setText(System.nanoTime()+" nanosecondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.elenco.reset();
    	this.txtParola.setText("");
    	this.txtResult.setText("");
    	this.txtTime.setText(System.nanoTime()+" nanosecondi");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	this.elenco.remove(this.txtResult.getSelectedText());
    	this.txtResult.setText(this.descriveList());
    	this.txtTime.setText(System.nanoTime()+" nanosecondi");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
