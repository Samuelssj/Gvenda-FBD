package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.Main;
import dao.DaoCliente;
import dao.DaoComunicar;
import exeptions.ExceptionUtil;
import fachada.Fachada;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Cliente;
import model.ClienteTabAdapter;
import model.Contato;
import model.Endereco;
import model.MaskFieldUtil;
import model.Menssagem;
import model.TipoContato;
import view.Mensagem;

public class ControleCliente implements Initializable {

	ObservableList<Cliente> observableClientes;

	private Fachada fachada = Fachada.getInstance();
	private Cliente cliente;
	private ClienteTabAdapter clienteTabAdapter;
	private List<ClienteTabAdapter> clienteTabAdapters;
	private Endereco endereco;
	private Contato contato;
	private Contato contato2;
	private List<Contato> contatos;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private Tab TabListaClientes;

	@FXML
	private TextField TXbuscar;

	@FXML
	private Button JBbuscar;

	@FXML
	private Button JBnovoCliente;

	@FXML
	private TableView<ClienteTabAdapter> tabelaClientes;

	@FXML
	private TableColumn<ClienteTabAdapter, String> nomeTabela;

	@FXML
	private TableColumn<ClienteTabAdapter, String> cpfcnpjTabela;

	@FXML
	private TableColumn<ClienteTabAdapter, String> RGtabela;

	@FXML
	private TableColumn<ClienteTabAdapter, String> NacimentoTab;

	@FXML
	private TableColumn<ClienteTabAdapter, String> ruaTab;

	@FXML
	private TableColumn<ClienteTabAdapter, String> bairroTab;

	@FXML
	private TableColumn<ClienteTabAdapter, String> NumeroTab;

	@FXML
	private Button JBeditar;

	@FXML
	private Button JBdeletar;

	@FXML
	private Tab TabNovoCliente;

	@FXML
	private TextField TXnome;

	@FXML
	private DatePicker TXnascimento;

	@FXML
	private TextField TXcidade;

	@FXML
	private TextField TXcep;

	@FXML
	private TextField TXestado;

	@FXML
	private TextField TXtelefone;

	@FXML
	private TextField TXcelular;

	@FXML
	private TextField TXnum;

	@FXML
	private TextField TXcpfcnpj;

	@FXML
	private TextField TXrua;

	@FXML
	private TextField TXbairro;

	@FXML
	private TextField TXemail;

	@FXML
	private Button JBcadastrar;

	@FXML
	private Button JBlimpar;

	@FXML
	private TextField TXsexo;

	@FXML
	private Button JBvoltar;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == JBnovoCliente) {
			TabListaClientes.getTabPane().getSelectionModel().select(TabNovoCliente);

		}
		if (event.getSource() == JBvoltar) {
			TabNovoCliente.getTabPane().getSelectionModel().select(TabListaClientes);
		}

		if (event.getSource() == JBeditar) {

			TabListaClientes.getTabPane().getSelectionModel().select(TabNovoCliente);
			////////////////////////////////////////////////////

			try {
				preencherCampos();
			} catch (ExceptionUtil e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			////

		}

		if (event.getSource() == JBbuscar) {
			if (TXbuscar.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {

				try {

					tabelaClientes.getItems().setAll(fachada.buscarPorCPFCliente(TXbuscar.getText()));

				} catch (ExceptionUtil e) {
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}
		}

		if (event.getSource() == JBcadastrar) {
			if (validarCampos()) {

				cadastrarCliente();

				try {
					fachada.salvarCliente(cliente);
					clienteTabAdapters = fachada.getAllAdapterCliente();
					tabelaClientes.getItems().setAll(clienteTabAdapters);
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"O cliente foi salvo com sucesso!");

				} catch (ExceptionUtil e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro salvar Cliente",
							"Erro ao salvar o cliente", e.getMessage());
				}

				limparCampos();
				TabListaClientes.getTabPane().getSelectionModel().select(TabListaClientes);
			}

		}

//		if(event.getSource() == JBdetalhe) {
//			
//			ClienteTabAdapter c = tabelaClientes.getSelectionModel().getSelectedItem();
//			List<Contato> contatos;
//			try {
//				contatos = DaoComunicar.buscarContato(c.getId());
//				ControleContatos.controleContatos.setContatos(contatos);
//			} catch (ExceptionUtil e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			Dialog<Contato> dialog = new Dialog<>();	
//			dialog.getDialogPane().setContent(Main.telaContato());
//			dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
//			dialog.showAndWait();
//			
//			
//		}
	}

	public void cadastrarCliente() {

		cliente = new Cliente();

		cliente.setNome(TXnome.getText());
		cliente.setCpf(TXcpfcnpj.getText());
		// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		// send o date
		// cliente.setData_nascimento(format.parse(TXnascimento.getEditor().getText()));
		cliente.setData_nascimento(TXnascimento.getEditor().getText());

		// TODO Auto-generated catch block

		cliente.setSexo(TXsexo.getText());

		endereco = new Endereco();

		endereco.setRua(TXrua.getText());
		endereco.setNumero(TXnum.getText());
		endereco.setCep(TXcep.getText());
		endereco.setBairro(TXbairro.getText());
		endereco.setCidade(TXcidade.getText());
		endereco.setEstado(TXestado.getText());

		cliente.setEndereco(endereco);

		contato = new Contato();
		contato2 = new Contato();
		contatos = new ArrayList<>();

		contato.setCliente(cliente);
		contato.setTipo(TipoContato.TELEFONE);
		contato.setDescricao(TXtelefone.getText());

		contato2.setCliente(cliente);
		contato2.setTipo(TipoContato.EMAIL);
		contato2.setDescricao(TXemail.getText());

		contatos.add(contato);
		contatos.add(contato2);
		cliente.setContatos(contatos);
	}

	public void limparCampos() {

		TXnome.clear();
		TXcpfcnpj.clear();
		TXrua.clear();
		TXnascimento.getEditor().clear();
		TXnum.clear();
		TXcep.clear();
		TXbairro.clear();
		TXcidade.clear();
		TXestado.clear();
		TXtelefone.clear();
		TXemail.clear();
		TXcelular.clear();
		TXsexo.clear();
		

	}

	public void preencherCampos() throws ExceptionUtil {

		ClienteTabAdapter client = new ClienteTabAdapter();
		client = tabelaClientes.getSelectionModel().getSelectedItem();

		try {
			// Cliente c = fachada.buscarPorIdCliente(client.getId());

			TXnome.setText(client.getNome());
			TXcpfcnpj.setText(client.getCpf());
			TXrua.setText(client.getRua());
			TXnascimento.setPromptText(client.getData_nascimento());
			TXcep.setText(DaoComunicar.buscarEndereco(client.getId()).getCep());
			TXnum.setText(client.getNumero());
			TXbairro.setText(client.getBairro());
			TXcidade.setText(DaoComunicar.buscarEndereco(client.getId()).getCidade());

			TXestado.setText(DaoComunicar.buscarEndereco(client.getId()).getEstado());
			TXtelefone.setText(DaoComunicar.buscarEndereco(client.getId()).getNumero());
			// TXemail.setText(DaoComunicar.);
			TXcelular.setText(client.getNome());
			// TXsexo.setText(c.getSexo());

		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		
////		

	}

	public boolean validarCampos() {

		if (TXnome.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME Vazio",
					"Preencha o nome!");
			return false;
		}

		if (TXcpfcnpj.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CPF/CNPJ Vazio",
					"Preencha o cpf/cnpj!");
			return false;
		}
		if (TXrua.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "RUA Vazio",
					"Preencha a rua!");
			return false;
		}
//		if(TXnascimento.getPromptText().isEmpty()) {
//			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "DATA DE NACIMENTO Vazio", "Preencha a data!");
//			return false;
//		}
		if (TXnum.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NÚMERO Vazio!",
					"Preencha o número!");
			return false;
		}
		if (TXcep.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CEP Vazio",
					"Preencha o cep!");
			return false;
		}
		if (TXbairro.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "BAIRRO Vazio",
					"Preencha o bairro");
			return false;
		}
		if (TXcidade.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CIDADE Vazia",
					"Preencha a cidade");
			return false;
		}
		if (TXestado.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "ESTADO Vazio",
					"Preencha o estado");
			return false;
		}
		if (TXtelefone.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "TELEFONE Vazio",
					"Preencha o telefone");
			return false;
		}
		if (TXemail.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "E-MAIL Vazio",
					"Preencha o e-mail");
			return false;
		}
		if (TXcelular.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CELULAR Vazio",
					"Preencha o celular");
			return false;
		}
		if (TXsexo.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "TIPO DE SEXO Vazio",
					"Preencha o SEXO");
			return false;
		}

		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		MaskFieldUtil.cpfField(TXcpfcnpj);
		MaskFieldUtil.foneField(TXtelefone);
		MaskFieldUtil.cepField(TXcep);

		nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfcnpjTabela.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		NacimentoTab.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
		ruaTab.setCellValueFactory(new PropertyValueFactory<>("rua"));
		bairroTab.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		NumeroTab.setCellValueFactory(new PropertyValueFactory<>("numero"));

		try {

			clienteTabAdapters = fachada.getAllAdapterCliente();
			tabelaClientes.getItems().setAll(clienteTabAdapters);

		} catch (ExceptionUtil e) {
			e.printStackTrace();
		}

//		NacimentoTab.setCellFactory(coluna -> {
//
//			return new TableCell<ClienteTabAdapter, Date>() {
//				protected void updateItem(Date item, boolean empty) {
//
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
//					}
//				}
//			};
//		});
//
	}
//	

}
