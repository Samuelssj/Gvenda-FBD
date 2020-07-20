package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControleVenda implements Initializable {

	
	
	  @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPaneProduto;

	    @FXML
	    private Tab TabListaProdutos;

	    @FXML
	    private TextField TXbuscarProdutos;

	    @FXML
	    private Button JBbuscarProduto;

	    @FXML
	    private TableView<?> tabelaClientes;

	    @FXML
	    private TableColumn<?, ?> codTabelaProduto;

	    @FXML
	    private TableColumn<?, ?> descricaoTabelaProduto;

	    @FXML
	    private TableColumn<?, ?> quantidadeTabelaProduto;

	    @FXML
	    private TableColumn<?, ?> precoTabelaProduto;

	    @FXML
	    private Button JBremoverItem;

	    @FXML
	    private Button JBadicionarItem;

	    @FXML
	    private TextField TXquantidadeAdicionar;

	    @FXML
	    private TextField TXtotal;

	    @FXML
	    private TextField TXtroco;

	    @FXML
	    private TextField TXvalorPago;

	    @FXML
	    private Button JBfinalizarVenda;

	    @FXML
	    private Button JBvoltar;

	    @FXML
	    private Button JBnovaVenda;

	    @FXML
	    private Tab TabNovoProduto;

	    @FXML
	    private CheckBox CheckAtivoProduto;

	    @FXML
	    private TextField TXnomeProduto;

	    @FXML
	    private TextField TXquantidadeProduto;

	    @FXML
	    private TextField TXquantidadeTotalProduto;

	    @FXML
	    private TextField TXmarcaProduto;

	    @FXML
	    private TextField TXdescricaoProduto;

	    @FXML
	    private TextField TXBarrasProduto;

	    @FXML
	    private TextField TXprecoUnitarioProduto;

	    @FXML
	    private TextField TXvarejoProduto;

	    @FXML
	    private TextField TXatacadoProduto;

	    @FXML
	    private TextField TXcompraProduto;

	    @FXML
	    private TextField TXvendaProduto;

	    @FXML
	    private CheckBox CheckPerecivelProduto;

	    @FXML
	    private DatePicker TXfabricacaoProduto;

	    @FXML
	    private DatePicker TXvalidadeProduto;

	    @FXML
	    private DatePicker TXCadastradoemProduto;

	    @FXML
	    private Button JBcadastrarProduto;

	    @FXML
	    private TextField TxfornecedorProduto;

	    @FXML
	    private Button JBvoltarProduto;

	    @FXML
	    private Button JBcadastrarNovoFornecedorProduto;

	    @FXML
	    void action(ActionEvent event) {

	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
