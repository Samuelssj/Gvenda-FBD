package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Contato;
import model.TipoContato;

public class ControleContatos implements Initializable {
	
	
	private List<Contato> contatos = new ArrayList<>();
    @FXML
    private TableView<Contato> tabela_contato;

    @FXML
    private TableColumn<Contato, TipoContato> tipo_col;

    @FXML
    private TableColumn<Contato, String> contato_col;

    @FXML
    private Button editar_button;
    
    public static ControleContatos controleContatos;
    
    @FXML
    void action(ActionEvent event) {

    	if(event.getSource() == editar_button) {
    		
    		
    		Contato c = tabela_contato.getSelectionModel().getSelectedItem();
    		ControleEditarContato.controleEditarContato.setContato(c);
    		
    		Dialog<Contato> dialog = new Dialog<>();
    		dialog.getDialogPane().setContent(Main.telaEditarContato());
    		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
    		dialog.showAndWait();
    		
    	}

    	

}
    public void setContatos(List<Contato> contatos) {
    	this.contatos = contatos;
    	tabela_contato.getItems().setAll(contatos);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		tipo_col.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		contato_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
		controleContatos = this;
		
	}
}
