package app;

import java.io.IOException;

import javax.swing.JOptionPane;

import fachada.Fachada;
import fachada.IFachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Cliente;
import sql.SQLUtil;

public class Main extends Application {
	
	//*_*

	private static Pane login;
	private static Pane inicio;
	private static Pane cadastroFornecedor;
	private static Pane venda;
	private static Pane pagamentoVenda;
	private static Pane contato;
	private static Pane editarContato;
	private static Scene sceneLogin;
	private static Scene sceneMenu;
	private static Stage stage;
 
	
	public static void main(String[] args) {

	        
	launch(args); 
		
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			login = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaLog.fxml"));
			
			inicio = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaInicio.fxml"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não encontrou o arquivo");
		}

		sceneLogin = new Scene(login);
		primaryStage.setScene(sceneLogin);
		
		sceneMenu = new Scene(inicio);
		
		
		primaryStage.centerOnScreen();
    	primaryStage.show();
    	primaryStage.setTitle("Sistema (GVENDA)");
    	primaryStage.setResizable(false);
    	stage = primaryStage;


	}

	
    public static void changeStage(String nomeTela) {
    	
    	if(nomeTela.equals("Menu")) {
    		stage.setScene(sceneMenu);
    	}
    	
    	
    }

    public static Pane telaVenda(){

		return venda;
	}

	public static  Pane telaPagamentoVenda(){
    	return  pagamentoVenda;
	}

    public static Pane telaFornecedor() {
    	
    	return cadastroFornecedor;
    }
    
    public static Pane telaContato() {
    	return contato;
    }
    
    public static Pane telaEditarContato() {
    	return editarContato;
    }
	
	

}
