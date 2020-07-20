package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import exeptions.ExceptionUtil;
import fachada.Fachada;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Fornecedor;
import model.MaskFieldUtil;
import model.Menssagem;
import view.Mensagem;

public class ControleFornecedor implements Initializable {

	ObservableList<Fornecedor> observableFornecedor;
	private List<Fornecedor> fornecedorTab;
	private Fachada fachada = Fachada.getInstance();
	private Fornecedor fornecedor;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private Tab TabListaFornecedor;

	@FXML
	private TextField TXbuscar;

	@FXML
	private Button JBbuscar;

	@FXML
	private Button JBnovoFornecedor;

	@FXML
	private TableView<Fornecedor> tabelaFornecedores;

	@FXML
	private TableColumn<Fornecedor, String> nomeTabela;

	@FXML
	private TableColumn<Fornecedor, String> razaoSocialTab;

	@FXML
	private TableColumn<Fornecedor, String> CnpjTab;

	@FXML
	private TableColumn<Fornecedor, String> CidadeTab;

	@FXML
	private TableColumn<Fornecedor, String> EstadoTab;

	@FXML
	private Button JBeditar;

	@FXML
	private Button JBdeletar;

	@FXML
	private Tab TabNovoFornecedor;

	@FXML
	private Label labelNovoFornecedor;

	@FXML
	private TextField TXnomeFornecedor;

	@FXML
	private TextField TXrazaoFornecedor;

	@FXML
	private TextField TXcnpjFornecedor;

	@FXML
	private TextField TXcidadeFornecedor;

	@FXML
	private TextField TXcepFornecedor;

	@FXML
	private TextField TXestadoFornecedor;

	@FXML
	private TextField TXruaFornecedor;

	@FXML
	private TextField TXnumeroFornecedor;

	@FXML
	private TextField TXtellFornecedor;

	@FXML
	private TextField TXemailFornecedor;

	@FXML
	private Button JBcadastrarFornecedor;

	@FXML
	private Button JBvoltar;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == JBnovoFornecedor) {
			TabListaFornecedor.getTabPane().getSelectionModel().select(TabNovoFornecedor);

		}
		if (event.getSource() == JBvoltar) {
			TabNovoFornecedor.getTabPane().getSelectionModel().select(TabListaFornecedor);
		}

		if (event.getSource() == JBbuscar) {
			if (TXbuscar.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {
				try {

					tabelaFornecedores.getItems().setAll(fachada.buscarPorNomeFornecedor(TXbuscar.getText()));

				} catch (ExceptionUtil e) {
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Fornecedor",
							"Erro ao buscar fornecedor", e.getMessage());
					e.printStackTrace();
				}
			}
		}

		if (event.getSource() == JBcadastrarFornecedor) {
			if (ValidarCampos()) {
				cadastrarFornecedor();

				try {
					fachada.salvarFornecedor(fornecedor);
					fornecedorTab = fachada.getAllFornecedor();
					tabelaFornecedores.getItems().setAll(fornecedorTab);
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"O Fornecedor foi salvo com sucesso!");

				} catch (ExceptionUtil e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro salvar fornecedor",
							"Erro ao salvar o fornecedor", e.getMessage());

				}
				limparCampos();
				TabNovoFornecedor.getTabPane().getSelectionModel().select(TabListaFornecedor);

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		MaskFieldUtil.cnpjField(TXcnpjFornecedor);
		MaskFieldUtil.foneField(TXtellFornecedor);
		MaskFieldUtil.cepField(TXcepFornecedor);

		nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
		razaoSocialTab.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
		CnpjTab.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		EstadoTab.setCellValueFactory(new PropertyValueFactory<>("estado"));
		CidadeTab.setCellValueFactory(new PropertyValueFactory<>("cidade"));

		try {

			fornecedorTab = fachada.getAllFornecedor();
			tabelaFornecedores.getItems().setAll(fornecedorTab);

		} catch (ExceptionUtil e) {
			e.printStackTrace();
		}

	}

	public void cadastrarFornecedor() {

		fornecedor = new Fornecedor();

		fornecedor.setNome(TXnomeFornecedor.getText());
		fornecedor.setRazao_social(TXrazaoFornecedor.getText());
		fornecedor.setCnpj(TXcnpjFornecedor.getText());
		fornecedor.setCidade(TXcidadeFornecedor.getText());
		fornecedor.setEstado(TXestadoFornecedor.getText());

	}

	public void limparCampos() {

		TXnomeFornecedor.clear();
		TXrazaoFornecedor.clear();
		TXcnpjFornecedor.clear();
		TXcidadeFornecedor.clear();
		TXcepFornecedor.clear();
		TXestadoFornecedor.clear();
		TXruaFornecedor.clear();
		TXnumeroFornecedor.clear();
		TXtellFornecedor.clear();
		TXemailFornecedor.clear();

	}

	public boolean ValidarCampos() {

		if (TXnomeFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME Vazio",
					"Preencha o nome!");
			return false;
		}
		if (TXrazaoFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "RAZÃO/SOCIAL Vazio",
					"Preencha a razão/social!");
			return false;
		}
		if (TXcnpjFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CNPJ Vazio",
					"Preencha o cnpj!");
			return false;
		}
		if (TXcidadeFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CIDADE Vazia",
					"Preencha a cidade!");
			return false;
		}
		if (TXcepFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CEP Vazio",
					"Preencha o cep!");
			return false;
		}
		if (TXestadoFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "ESTADO Vazio",
					"Preencha o estado!");
			return false;
		}
		if (TXruaFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "RUA Vazia",
					"Preencha a rua!");
			return false;
		}
		if (TXnumeroFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NÚMERO Vazio",
					"Preencha o número!");
			return false;
		}
		if (TXtellFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "TELEFONE Vazio",
					"Preencha o telefone!");
			return false;
		}
		if (TXemailFornecedor.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "E-MAIL Vazio",
					"Preencha o e-mail!");
			return false;
		}

		return true;

	}

}
