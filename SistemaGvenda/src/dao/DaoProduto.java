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
import model.Produto;
import sql.SQLConections;
import sql.SQLUtil;

public class DaoProduto  implements IDaoProduto{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	
	


	@Override
	public int salvar(Produto produto) throws ExceptionUtil {
	int id = 0;
		
		try {
			
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Produto.INSERT);
			this.statement.setString(1, produto.getNome());
			this.statement.setString(2, produto.getMarca());
			this.statement.setString(3, produto.getDescricao());
			this.result = this.statement.executeQuery();
			
			if(result.next()) {
				id = result.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new ExceptionUtil("Erro ao salvar produto!");
		}
		
		return id;
	}

	@Override
	public Produto buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getAll() throws ExceptionUtil {
		
		List<Produto> produtos = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			
			// mudei o select aqui
			
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Produto produto;
			while (result.next()) {
				produto = new Produto();
				produto.setId(result.getInt(1));
				produto.setNome(result.getString(SQLUtil.Produto.NOME_PRODUTO));
				produto.setMarca(result.getString(SQLUtil.Produto.MARCA));
				produto.setDescricao(result.getString(SQLUtil.Produto.DESCRICAO));
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
	public void editar(Produto produto) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	
	 
	
	
}
