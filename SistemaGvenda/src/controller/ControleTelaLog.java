package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import app.Main;

import exeptions.ExceptionUtil;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Funcionario;
import model.Menssagem;
import view.Mensagem;
import javafx.scene.control.Alert.AlertType;

public class ControleTelaLog implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private static Funcionario funcionario;


	@FXML
	private Button JBentrar;

	@FXML
	private PasswordField TxSenha;

	@FXML
	private TextField TxLogin;

	@FXML
	private Button JBsair;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == JBentrar) {

			if (efetuarLogin()) {
				
				Main.changeStage("Menu");
				
			}

		} 
		if (event.getSource() == JBsair) {
			System.exit(0);
		}

	}

	public boolean efetuarLogin() {

		try {

			funcionario = fachada.buscarPorLoginFuncionario(TxLogin.getText(), TxSenha.getText());
			

			if (funcionario == null) {
				Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Logar", "Usuario não EXISTE!",
						"Tente rever os dados: E-mail/Senha");
				
				return false;
			}
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Logado", "Login efetuado",
					"Logado com sucesso!");
			
			
			return true;
			
		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(Funcionario funcionario) {
		ControleTelaLog.funcionario = funcionario;
	}

	
	
}
