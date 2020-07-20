package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.FuncionarioAdapter;
import model.Menssagem;
import sql.SQLUtil.Funcionario;

public class ControleTelaInicio implements Initializable {

	private Pane CadastroCliente;
	private Pane CadastroFornecedor;
	private Pane CadastroProduto;
	private Pane CadastroFuncionario;
	private Pane ContaVendas;
	private Pane Relatorio;
	private Pane ContasAReceber;
	ControleTelaLog telaLog;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private MenuBar menuBar;

	@FXML
	private MenuItem menuFuncionários;

	@FXML
	private ImageView menuicoInicio;

	@FXML
	private MenuItem menuProdutos;

	@FXML
	private MenuItem menuClientes;

	@FXML
	private MenuItem menuFornecedores;

	@FXML
	private MenuItem menuRelatorio;

	@FXML
	private MenuItem menuVendas;

	@FXML
	private MenuItem menuSair;

	@FXML
	private MenuItem menuSobre;

	@FXML
	private AnchorPane pane;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == menuClientes) {
			atualizarTela("clientes");
		}

		if (event.getSource() == menuFuncionários) {

			if (telaLog.getFuncionario().getCargo().equalsIgnoreCase("Administrador")) {
				atualizarTela("funcionario");
			} else {
				menuSimples();
			}

		}
		if (event.getSource() == menuProdutos) {
			atualizarTela("produtos");
		}
		if (event.getSource() == menuFornecedores) {
			atualizarTela("fornecedor");
		}
		if (event.getSource() == menuSair) {
			System.exit(0);
		
			
			
		}
		if (event.getSource() == menuVendas) {

			if (telaLog.getFuncionario().getCargo().equalsIgnoreCase("Administrador")) {
				atualizarTela("venda");
			} else {
				menuSimples();
			}

		}
		if (event.getSource() == menuRelatorio) {

			if (telaLog.getFuncionario().getCargo().equalsIgnoreCase("Administrador")) {
				atualizarTela("relatorio");
			} else {
				menuSimples();
			}

		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		try {
			CadastroCliente = FXMLLoader.load(getClass().getClassLoader().getResource("view/Cliente.fxml"));
			CadastroProduto = FXMLLoader.load(getClass().getClassLoader().getResource("view/Produto.fxml"));
			CadastroFornecedor = FXMLLoader.load(getClass().getClassLoader().getResource("view/Fornecedor.fxml"));
			CadastroFuncionario = FXMLLoader.load(getClass().getClassLoader().getResource("view/Funcionario.fxml"));
			ContaVendas = FXMLLoader.load(getClass().getClassLoader().getResource("view/Venda.fxml"));
			Relatorio = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaRelatorio.fxml"));
		}

		catch (IOException e) {
			e.printStackTrace();

		}

	}
	
	public void menuSimples() {
		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Permição Negada",
				"Logue como Administrador", "sem permição para acesso");
		menuFuncionários.setDisable(true);
		menuVendas.setDisable(true);
		menuRelatorio.setDisable(true);
	}
		

	public void atualizarTela(String tela) {

		if (tela.equalsIgnoreCase("clientes")) {
			AnchorPane.setBottomAnchor(CadastroCliente, 0.0);
			AnchorPane.setLeftAnchor(CadastroCliente, 0.0);
			AnchorPane.setRightAnchor(CadastroCliente, 0.0);
			AnchorPane.setTopAnchor(CadastroCliente, 0.0);
			pane.getChildren().setAll(CadastroCliente);
		}
		if (tela.equalsIgnoreCase("produtos")) {
			AnchorPane.setBottomAnchor(CadastroProduto, 0.0);
			AnchorPane.setLeftAnchor(CadastroProduto, 0.0);
			AnchorPane.setRightAnchor(CadastroProduto, 0.0);
			AnchorPane.setTopAnchor(CadastroProduto, 0.0);
			pane.getChildren().setAll(CadastroProduto);
		}
		if (tela.equalsIgnoreCase("fornecedor")) {

			AnchorPane.setBottomAnchor(CadastroFornecedor, 0.0);
			AnchorPane.setLeftAnchor(CadastroFornecedor, 0.0);
			AnchorPane.setRightAnchor(CadastroFornecedor, 0.0);
			AnchorPane.setTopAnchor(CadastroFornecedor, 0.0);
			pane.getChildren().setAll(CadastroFornecedor);
		}
		if (tela.equalsIgnoreCase("funcionario")) {

			AnchorPane.setBottomAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setLeftAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setRightAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setTopAnchor(CadastroFuncionario, 0.0);
			pane.getChildren().setAll(CadastroFuncionario);
		}
		if (tela.equalsIgnoreCase("venda")) {
			AnchorPane.setBottomAnchor(ContaVendas, 0.0);
			AnchorPane.setLeftAnchor(ContaVendas, 0.0);
			AnchorPane.setRightAnchor(ContaVendas, 0.0);
			AnchorPane.setTopAnchor(ContaVendas, 0.0);
			pane.getChildren().setAll(ContaVendas);
		}
		if (tela.equalsIgnoreCase("relatorio")) {
			AnchorPane.setBottomAnchor(Relatorio, 0.0);
			AnchorPane.setLeftAnchor(Relatorio, 0.0);
			AnchorPane.setRightAnchor(Relatorio, 0.0);
			AnchorPane.setTopAnchor(Relatorio, 0.0);
			pane.getChildren().setAll(Relatorio);
		}
	}

}
