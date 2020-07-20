package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagem {
	

	private static Mensagem instancia;
	private Alert alert;
	
	/**
	 * 
	 */
	private Mensagem() {
	
		alert = new Alert(AlertType.INFORMATION);
	}
	
	/**
	 * @return the instancia
	 */
	public static Mensagem getInstancia() {
	
		if(instancia == null) {
			instancia = new Mensagem();
		}
		return instancia;
	}
	
	public void exibirMensagem(AlertType tipo, String titulo, String cabecalho, String mensagem)	{
		
		alert.setAlertType(tipo);
		alert.setTitle(titulo);
		alert.setContentText(mensagem);
		alert.setHeaderText(cabecalho);
		
		alert.show();
		
	}
	

}
