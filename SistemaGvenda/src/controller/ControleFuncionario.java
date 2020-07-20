package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.ldap.Rdn;

import com.sun.javafx.image.impl.ByteIndexed.Getter;
import javafx.scene.control.RadioButton;
import exeptions.ExceptionUtil;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Cliente;
import model.ClienteTabAdapter;
import model.Contato;
import model.Endereco;
import model.Funcionario;
import model.FuncionarioAdapter;
import model.MaskFieldUtil;
import model.Menssagem;
import model.ProdutoTabAdapter;
import model.TipoContato;
import view.Mensagem;

public class ControleFuncionario implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private Funcionario funcionario;
	private List<FuncionarioAdapter> funcionarioTabAdapters;
	private Endereco endereco, end;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private Tab TabListaFuncionario;

	@FXML
	private TextField TXbuscarFuncionario;

	@FXML
	private Button JBbuscarFuncionario;

	@FXML
	private Button JBnovoFuncionario;

	@FXML
	private TableView<FuncionarioAdapter> tabelaFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, String> nomeTabelaFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, String> cpfTabelaFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, String> CargotabelaFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, String> RuaTabFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, String> BairroTabFuncionario;

	@FXML
	private TableColumn<FuncionarioAdapter, Boolean> SituacaoTabFuncionario;

	@FXML
	private Button JBeditarFuncionario;

	@FXML
	private Button JBdeletarFuncionario;

	@FXML
	private Tab TabNovoFuncionario;

	@FXML
	private TextField TXnomeFuncionario;

	@FXML
	private TextField TXcpfFuncionario;

	@FXML
	private TextField TXloginFuncionario;

	@FXML
	private TextField TXsenhaFuncionario;

	@FXML
	private TextField TXconfirmarsenhaFuncionario;

	@FXML
	private TextField TXcidadeFuncionario;

	@FXML
	private TextField TXestadoFuncionario;

	@FXML
	private TextField TXcepFuncionario;

	@FXML
	private TextField TXruaFuncionario;

	@FXML
	private TextField TXBairroFuncionario;

	@FXML
	private TextField TXnumeroFuncionario;

	@FXML
	private Button BTcadastrarFuncionario;

	@FXML
	private RadioButton RadioAdm;

	@FXML
	private ToggleGroup genero;

	@FXML
	private RadioButton RadioFuncionario;

	@FXML
	private Button JBvoltar;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == JBnovoFuncionario) {
			TabListaFuncionario.getTabPane().getSelectionModel().select(TabNovoFuncionario);

		}
		if (event.getSource() == JBvoltar) {
			TabNovoFuncionario.getTabPane().getSelectionModel().select(TabListaFuncionario);
		}
		if (event.getSource() == JBeditarFuncionario) {

			preencherCampos();
			TabListaFuncionario.getTabPane().getSelectionModel().select(TabNovoFuncionario);

		}
		if (event.getSource() == JBbuscarFuncionario) {
			if (TXbuscarFuncionario.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {
				try {

					tabelaFuncionario.getItems()
							.setAll(fachada.buscarPorBuscaFuncionario((TXbuscarFuncionario.getText())));

				} catch (ExceptionUtil e) {
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Funcionario",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}
		}

		if (event.getSource() == BTcadastrarFuncionario) {
			if (validarCampos()) {
				try {
					cadastrarFuncionario();

					fachada.salvarFuncionario(funcionario, end);
					funcionarioTabAdapters = fachada.getAllAdapterFuncionario();
					tabelaFuncionario.getItems().setAll(funcionarioTabAdapters);

					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"O Funcionario foi salvo com sucesso!");

				} catch (ExceptionUtil e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro salvar Cliente",
							"Erro ao salvar o cliente", e.getMessage());
				}

				limparCampos();
				TabNovoFuncionario.getTabPane().getSelectionModel().select(TabListaFuncionario);
			}
		}
	}

	public void cadastrarFuncionario() {

		funcionario = new Funcionario();

		funcionario.setNome(TXnomeFuncionario.getText());
		funcionario.setCpf(TXcpfFuncionario.getText());
		if (RadioAdm.isSelected()) {
			funcionario.setCargo("Administrador");
			funcionario.setAdm(true);
		} else {
			funcionario.setCargo("Funcionário");
			funcionario.setAdm(false);
		}

		funcionario.setLogin(TXloginFuncionario.getText());
		funcionario.setSenha(TXsenhaFuncionario.getText());
		funcionario.setEndereco(endereco);
		;

		endereco = new Endereco();

		endereco.setRua(TXruaFuncionario.getText());
		endereco.setNumero(TXnumeroFuncionario.getText());
		endereco.setCep(TXcepFuncionario.getText());
		endereco.setBairro(TXBairroFuncionario.getText());
		endereco.setCidade(TXcidadeFuncionario.getText());
		endereco.setEstado(TXestadoFuncionario.getText());

		funcionario.setEndereco(endereco);
		funcionario.setSituacao(true);

	}

	public void limparCampos() {

		TXnomeFuncionario.clear();
		TXcpfFuncionario.clear();
		TXruaFuncionario.clear();
		TXnumeroFuncionario.clear();
		TXcepFuncionario.clear();
		TXBairroFuncionario.clear();
		TXcidadeFuncionario.clear();
		TXestadoFuncionario.clear();
		TXloginFuncionario.clear();
		TXsenhaFuncionario.clear();
		TXconfirmarsenhaFuncionario.clear();
		RadioAdm.setSelected(false);
		RadioFuncionario.setSelected(false);
	}

	public boolean validarCampos() {

		if (TXnomeFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME Vazio",
					"Preencha o nome!");
			return false;

		}
		if (TXcpfFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CPF/CNPJ Vazio",
					"Preencha o cpf/cnpj!");
			return false;
		}
		if (TXruaFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "RUA Vazio",
					"Preencha a rua!");
			return false;
		}
		if (TXnumeroFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NÚMERO Vazio!",
					"Preencha o número!");
			return false;
		}
		if (TXcepFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CEP Vazio",
					"Preencha o cep!");
			return false;
		}
		if (TXBairroFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "BAIRRO Vazio",
					"Preencha o bairro!");
			return false;
		}
		if (TXcidadeFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CIDADE Vazia",
					"Preencha a cidade!");
			return false;
		}
		if (TXestadoFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "ESTADO Vazio",
					"Preencha o estado!");
			return false;
		}
		if (TXloginFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "LOGIN Vazio",
					"Preencha o login!");
			return false;
		}
		if (TXsenhaFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "SENHA Vazio",
					"Preencha a senha!");
			return false;
		}
		if (TXconfirmarsenhaFuncionario.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CONFIRMAR SENHA Vazio",
					"Preencha o confirmar senha!");
			return false;
		}

		return true;
	}

	public void preencherCampos() {

		FuncionarioAdapter func = new FuncionarioAdapter();

		func = tabelaFuncionario.getSelectionModel().getSelectedItem();
		try {
			Funcionario f = fachada.buscarPorIdFuncionario(func.getId());
//			
			TXnomeFuncionario.setText(func.getNome());
			TXcpfFuncionario.setText(func.getCpf());
			TXruaFuncionario.setText(func.getRua());
			// TXnumeroFuncionario.setText(f.getEndereco().getNumero());
			TXcepFuncionario.setText(func.getNome());
			TXBairroFuncionario.setText(func.getBairro());
			// TXcidadeFuncionario.setText(f.getEndereco().getCidade());
			TXestadoFuncionario.setText(func.getNome());
			TXloginFuncionario.setText(func.getNome());
			TXsenhaFuncionario.setText(func.getNome());
			TXconfirmarsenhaFuncionario.setText(func.getNome());

		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		MaskFieldUtil.cpfField(TXcpfFuncionario);
		MaskFieldUtil.cepField(TXcepFuncionario);

		nomeTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		CargotabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		RuaTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("rua"));
		BairroTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		SituacaoTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("situacao"));

		try {
			funcionarioTabAdapters = fachada.getAllAdapterFuncionario();
			tabelaFuncionario.getItems().setAll(funcionarioTabAdapters);

		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
