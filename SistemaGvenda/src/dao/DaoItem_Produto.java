package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exeptions.ExceptionUtil;
import model.EstoqueTabAdapter;
import model.Item_Produto;
import model.Produto;
import model.ProdutoTabAdapter;
import sql.SQLConections;
import sql.SQLUtil;

public class DaoItem_Produto implements IDaoItem_Produto{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	
	

	@Override
	public void salvar(Item_Produto item_Produto, int produto_id, int id_fornecedor) throws ExceptionUtil {
		
		try {
			
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.INSERT);
			this.statement.setLong(1, item_Produto.getCod_barras());
			this.statement.setDouble(2, item_Produto.getUnid_medida());
			this.statement.setDate(3, new java.sql.Date(item_Produto.getData_fabricacao().getTime()));
			this.statement.setDate(4, new java.sql.Date(item_Produto.getData_validade().getTime()));
			this.statement.setDate(5, new java.sql.Date( item_Produto.getData_compra().getTime()));
			this.statement.setDouble(6, item_Produto.getPreco_unidade());
			this.statement.setDouble(7, item_Produto.getPorc_atacado());
			this.statement.setDouble(8, item_Produto.getPorc_varejo());
			this.statement.setInt(9, item_Produto.getQuantidade());
			this.statement.setInt(10,item_Produto.getVendidos());
			this.statement.setBoolean(11, item_Produto.isPerecivel());
			this.statement.setBoolean(12,item_Produto.isStatus());
			this.statement.setInt(13, id_fornecedor);
			this.statement.setInt(14, produto_id);
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new ExceptionUtil("Erro ao salvar o produto no estoque!");
		}

	
		
	}

	@Override
	public Item_Produto buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item_Produto> getAll() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapter() throws ExceptionUtil {
	
		List<ProdutoTabAdapter> produtos = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.SELECT_PRODUTO_ALL);
			this.result = this.statement.executeQuery();
			ProdutoTabAdapter produto;
			while (result.next()) {
				produto = new ProdutoTabAdapter();
				produto.setId(result.getInt(1));
				produto.setDescricao(result.getString("descricao"));
				produto.setMarca(result.getString("marca"));
				produto.setId(result.getInt(4));
				produto.setFornecedor_id(result.getInt(5));
				produto.setCod_barras(result.getLong("cod_barras"));
				produto.setPreco_varejo(result.getDouble("porc_varejo"));
				produto.setEstoque(result.getInt("quantidade"));
				produto.setData_cadastro(new java.util.Date(result.getDate("data_compra").getTime()));
				produto.setStatus(result.getBoolean(SQLUtil.Item_Produto.COL_STATUS));
				
				produtos.add(produto);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new ExceptionUtil("Erro ao buscar todos os produtos!");
		}
		return produtos;
	
	}
		
	

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapterPorBusca(String busca) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Item_Produto item_Produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarVenidos(Item_Produto item_Produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

}
