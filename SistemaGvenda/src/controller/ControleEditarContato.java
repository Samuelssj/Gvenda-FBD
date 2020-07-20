package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DaoComunicar;
import exeptions.ExceptionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Contato;
import model.TipoContato;

public class ControleEditarContato implements Initializable {

	public static ControleEditarContato controleEditarContato;

	Contato contato;

	@FXML
	private TextField descri_field;

	@FXML
	private TextField tipo_field;

	@FXML
	private Button salvar_button;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == salvar_button) {

			contato.setTipo(TipoContato.getTipoContato(tipo_field.getText()));
			contato.setDescricao(descri_field.getText());
			
			try {
				DaoComunicar.editarContato(contato);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	/**
	 * @param contatos the contatos to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		

		controleEditarContato = this;
	}
}
