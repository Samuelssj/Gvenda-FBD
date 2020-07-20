package controller;

import java.net.URL;
import java.nio.charset.CodingErrorAction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit.BoldAction;

import exeptions.ExceptionUtil;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Fornecedor;
import model.Item_Produto;
import model.MaskFieldUtil;
import model.Menssagem;
import model.Produto;
import model.ProdutoTabAdapter;
import view.Mensagem;

public class ControleProduto implements Initializable {
	ControleFornecedor controleFornecedor;
	private List<Fornecedor> fornecedorTab;
	private Produto produto = null;
	private Fornecedor fornecedor = null;
	private List<Fornecedor> fornecedors;
	private List<ProdutoTabAdapter> produtoTabAdapters;
	private Item_Produto item_Produto;
	private Item_Produto item;
	private Produto produ;
	private Fornecedor forneced;

	private double pr_un, pr_var, pr_atac;

	private Fachada fachada = Fachada.getInstance();

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private Tab TabListaProdutos;

	@FXML
	private TextField TXbuscarProdutos;

	@FXML
	private Button JBbuscarProduto;

	@FXML
	private Button JBnovoProduto;

	@FXML
	private TableView<ProdutoTabAdapter> tabelaProdutos;

	@FXML
	private TableColumn<ProdutoTabAdapter, String> descricaoTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, String> marcaTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, Integer> codTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, Double> precoTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, Integer> quantidadeTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, Date> cadastroTabelaProduto;

	@FXML
	private TableColumn<ProdutoTabAdapter, Boolean> situacaoTabelaProduto;

	@FXML
	private Button JBeditarProduto;

	@FXML
	private Button JBdeletarProduto;

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
	private Button JBcadastrarNovoFornecedorProduto;

	@FXML
	private Button JBcadastrarProduto;

	@FXML
	private TextField TXunidadeMedida;

	@FXML
	private Button JBvoltarProduto;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == JBnovoProduto) {
			TabListaProdutos.getTabPane().getSelectionModel().select(TabNovoProduto);

		}
		if (event.getSource() == JBvoltarProduto) {
			TabNovoProduto.getTabPane().getSelectionModel().select(TabListaProdutos);
		}

		if (event.getSource() == JBcadastrarNovoFornecedorProduto) {

			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Use a aba fornecedor ",
					"CADASTRE UM NOVO FORNECEDOR ANTES", "cadastre um novo fornecedor!");

		}

		if (event.getSource() == JBbuscarProduto) {
			if (TXbuscarProdutos.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			}
		}

		if (event.getSource() == JBcadastrarProduto) {
			if (validarCampos()) {
				try {
					fornecedor = tabelaFornecedores.getSelectionModel().getSelectedItem();
					cadastrarProduto(fornecedor);
					int produto_id = fachada.salvarProduto(produto);
					fachada.salvarItemProduto(item_Produto, produto_id, fornecedor.getId());
					TabNovoProduto.getTabPane().getSelectionModel().select(TabListaProdutos);
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"O Produto foi salvo com sucesso!");
					LimpaCampos();
//				contas = new Contas_a_pagar();
//				double valTemp = 0.00;
//				double valP = 0.00;
//				int qt = 0;

					// contas.setValor(pr_un *
					// Double.parseDouble(quant_prod_cadast_field.getText().trim()));

//				qt = Integer.parseInt(qtd_parc_field.getText());
//
//				valTemp = contas_a_pagar.getValor() / qt;
//
//				valP = Double.parseDouble(valor_pago_field.getText());
//
//				if (valP >= valTemp) {
//
//					contas_a_pagar.setValor_quitado(contas_a_pagar.getValor());
//					contas_a_pagar.setQtd_paga(qt);
//					contas_a_pagar.setQtd_pgmt(qt);
//					contas_a_pagar.setData_pagamento(new Date());
//					contas_a_pagar.setData_vencimento(new Date());
//					contas_a_pagar.setStatus(false);
//
//				} else if (valP < valTemp) {
//
//					contas_a_pagar.setValor_quitado(valP);
//					contas_a_pagar.setQtd_pgmt(qt);
//					contas_a_pagar.setQtd_paga(1);
//					contas_a_pagar.setData_pagamento(new Date());
//					contas_a_pagar.setStatus(true);
//
//				}
//
//				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//				try {
//					contas_a_pagar.setData_vencimento(format.parse(venc_parcela_data.getEditor().getText()));
//				} catch (ParseException e) {
//					e.printStackTrace();
//					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro", "Erro na data", e.getMessage());
//				}
//				contas_a_pagar.setFornecedor_id(fornecedor);
//				contas_a_pagar.setCaixa_id(ControleLogin.getCaixa());
//				contas_a_pagar.setDescricao("Compra de " + produto.getNome() + " √† " + fornecedor.getNome());
//
//				fachada.salvarConta_a_Pagar(contas_a_pagar, ControleLogin.getIdCaixa(), fornecedor.getId());

//				java.sql.Date data = new java.sql.Date(new Date().getTime());
//				caixa = fachada.buscarPorDataCaixa(data);
//				caixa.setSaida(caixa.getSaida() + contas_a_pagar.getValor_quitado());
//				fachada.editarCaixa(caixa);
					// produtoTabAdapters = fachada.getAllAdapterItemProduto();

				} catch (ExceptionUtil e) {
					e.printStackTrace();
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Salvar",
							"Ocorreu um erro ao salvar!", e.getMessage());
				}
//			limparCampos();
//			lista_prod_tabPane.getTabPane().getSelectionModel().select(lista_prod_tabPane);
//
//			list_prod_tab.getItems().setAll(produtoTabAdapters);
			}
		}
	}

	public void cadastrarProduto(Fornecedor forne) {

		produto = new Produto();
		item_Produto = new Item_Produto();

		produto.setNome(TXnomeProduto.getText());
		produto.setMarca(TXmarcaProduto.getText());
		produto.setDescricao(TXdescricaoProduto.getText());

		item_Produto.setCod_barras(Long.parseLong(TXBarrasProduto.getText()));
		item_Produto.setQuantidade(Integer.parseInt(TXquantidadeProduto.getText()));

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {

			item_Produto.setData_compra(format.parse(TXCadastradoemProduto.getEditor().getText().trim()));
			item_Produto.setData_fabricacao(format.parse(TXfabricacaoProduto.getEditor().getText().trim()));
			item_Produto.setData_validade(format.parse(TXvalidadeProduto.getEditor().getText().trim()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro", "Erro nas datas", e.getMessage());
		}

		item_Produto.setPerecivel(CheckPerecivelProduto.isSelected());
		item_Produto.setStatus(CheckAtivoProduto.isSelected());

		pr_un = Double.parseDouble(TXprecoUnitarioProduto.getText());
		pr_var = Double.parseDouble(TXvarejoProduto.getText());
		pr_atac = Double.parseDouble(TXatacadoProduto.getText());

		item_Produto.setPreco_unidade(pr_un);
		item_Produto.setPorc_varejo(pr_un + pr_un * pr_var / 100);
		item_Produto.setPorc_atacado(pr_un + pr_un * pr_atac / 100);

		item_Produto.setFornecedor_id(forne);
		item_Produto.setProduto_id(produto);
	}

	public void LimpaCampos() {
		TXatacadoProduto.clear();
		TXBarrasProduto.clear();
		TXbuscarProdutos.clear();
		TXCadastradoemProduto.getEditor().clear();
		TXcompraProduto.clear();
		TXdescricaoProduto.clear();
		TXfabricacaoProduto.getEditor().clear();
		TXmarcaProduto.clear();
		TXnomeProduto.clear();
		TXprecoUnitarioProduto.clear();
		TXquantidadeProduto.clear();
		TXquantidadeTotalProduto.clear();
		TXunidadeMedida.clear();
		TXvalidadeProduto.getEditor().clear();
		TXvarejoProduto.clear();
		TXvendaProduto.clear();
		CheckPerecivelProduto.setSelected(false);
		CheckAtivoProduto.setSelected(false);
	}

	public boolean validarCampos() {

		if (TXatacadoProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "Atacado Vazio!",
					"Preencha o valor atacado!");
			return false;
		}
		if (TXBarrasProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "C”DIGO DE BARRAS Vazio!",
					"Preencha o codigo de barras!");
			return false;
		}

		if (TXCadastradoemProduto.getEditor().getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "VALOR DE COMPRA Vazio!",
					"Preencha o nome!");
			return false;
		}
		if (TXcompraProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "DATA DE COMPRA Vazio!",
					"Preencha a data de compra!");
			return false;

		}
		if (TXdescricaoProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "DESCRI«√O Vazio!",
					"Preencha a descriÁ„o!");
			return false;
		}
		if (TXfabricacaoProduto.getEditor().getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "DATA DE FABRICA«√O Vazio!",
					"Preencha a fabricaÁ„o!");
			return false;

		}
		if (TXmarcaProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "MARCA Vazio!",
					"Preencha a marca!");
			return false;

		}
		if (TXnomeProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME Vazio",
					"Preencha o nome!");
			return false;
		}
		if (TXprecoUnitarioProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PRE«O UNITARIO Vazio",
					"Preencha o preÁo unitario!");
			return false;
		}
		if (TXquantidadeProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "QUANTIDADE Vazio",
					"Preencha a quantidade!");
			return false;

		}
		if (TXquantidadeTotalProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "QUANTIDADE TOTAL Vazio",
					"Preencha a quantidade total!");
			return false;
		}
		if (TXunidadeMedida.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "UNIDADE DE MEDIDA Vazio",
					"Preencha a unidade de medida!");
			return false;
		}
		if (TXvalidadeProduto.getEditor().getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "VALIDADE Vazio",
					"Preencha a validade!");
			return false;
		}
		if (TXvarejoProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PRE«O DE VAREJO Vazio",
					"Preencha o preÁo de varejo!");
			return false;
		}
		if (TXvendaProduto.getText().trim().isEmpty()) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "VALOR DE VENDA Vazio",
					"Preencha valor de venda!");
			return false;
		}
		if (CheckPerecivelProduto.isSelected() == false) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CAMPO PERECIVEL Vazio",
					"Preencha o campo perecivel!");
			return false;
		}
		if (CheckAtivoProduto.isSelected()== false) {
			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CAMPO ATIVO Vazio",
					"Preencha o campo ativo!");
			return false;
		}
	
		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//	
//		System.out.println(produtoTabAdapters);
//		System.out.println(tabelaProdutos);
////		
//		MaskFieldUtil.numericField(TXBarrasProduto);
//		MaskFieldUtil.numericField(TXquantidadeProduto);
//		MaskFieldUtil.numericField(TXquantidadeProduto);
//		MaskFieldUtil.monetaryField(TXprecoUnitarioProduto);
		// MaskFieldUtil.monetaryField(valor_pago_field);

		nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
		razaoSocialTab.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
		CnpjTab.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		EstadoTab.setCellValueFactory(new PropertyValueFactory<>("estado"));
		CidadeTab.setCellValueFactory(new PropertyValueFactory<>("cidade"));

		try {
			fornecedors = Fachada.getInstance().getAllFornecedor();
			tabelaFornecedores.getItems().setAll(fornecedors);
		} catch (ExceptionUtil e) {
			e.printStackTrace();
			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao buscar",
					"N√£o foram encontrados nenhum fornecedor!", e.getMessage());
		}
//
//		descricaoTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
//		marcaTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("marca"));
//		codTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("cod_barras"));
//		precoTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("porc_varejo"));
//		quantidadeTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
//		cadastroTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("data_compra"));
//		situacaoTabelaProduto.setCellValueFactory(new PropertyValueFactory<>("status"));
////
//		situacaoTabelaProduto.setCellFactory(coluna -> {
//			return new TableCell<ProdutoTabAdapter, Boolean>() {
//				protected void updateItem(Boolean item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						if (item)
//							setText("Em estoque");
//						else
//							setText("Em falta");
//					}
//				}
//			};
//		});
//
//		cadastroTabelaProduto.setCellFactory(coluna -> {
//
//			return new TableCell<ProdutoTabAdapter, Date>() {
//
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
////
//		try {
//			produtoTabAdapters = Fachada.getInstance().getAllAdapterItemProduto();
//			tabelaProdutos.getItems().setAll(produtoTabAdapters);
//			System.out.println(tabelaProdutos);
//		} catch (
//
//		ExceptionUtil e) {
//			e.printStackTrace();
//			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao buscar", "Produto n√£o encontrado!",
//					e.getMessage());
//		}
//		

	}

}
