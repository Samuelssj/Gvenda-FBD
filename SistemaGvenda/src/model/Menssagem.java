package model;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Menssagem {
	
	
	private static Menssagem instancia;
	private Alert alert;
	
	private Menssagem() {
		
		alert = new Alert(AlertType.INFORMATION);
	}
	
	
	public static Menssagem getInstancia() {
	
		if(instancia == null) {
			instancia = new Menssagem();
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
