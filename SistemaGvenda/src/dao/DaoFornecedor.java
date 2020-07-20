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
import model.ClienteTabAdapter;
import model.Contato;
import model.Fornecedor;
import sql.SQLConections;
import sql.SQLUtil;

public  class DaoFornecedor implements IDaoFornecedor {
	
	   private Connection conexao;
	    private PreparedStatement statement;
	    private ResultSet result;

	
	
	@Override
	public void salvar(Fornecedor fornecedor) throws ExceptionUtil {
	
        try {
    
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Fornecedor.INSERT);
            this.statement.setString(1, fornecedor.getNome());
            this.statement.setString(2, fornecedor.getRazao_social());
            this.statement.setString(3, fornecedor.getCnpj());
            this.statement.setString(4, fornecedor.getEstado());
            this.statement.setString(5, fornecedor.getCidade());
          //  this.result = this.statement.executeQuery();
            this.statement.execute();
//            int id = 0;
//            id = getCurrentValorTabela("fornecedor");
//            
         

			this.statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new ExceptionUtil("Erro ao salvar o fornecedor!");
        }
        
	}

	@Override
	public Fornecedor buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> getAll() throws ExceptionUtil {
		
		 List<Fornecedor> fornecedores = new ArrayList<>();
	        try {
	            this.conexao = SQLConections.getInstance();
	            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Fornecedor.NOME_TABELA));
	            this.result = this.statement.executeQuery();
	            Fornecedor fornecedor = null;
	            while (result.next()) {
	                fornecedor = new Fornecedor();
	                fornecedor.setId(result.getInt(1));
	                fornecedor.setNome(result.getString(SQLUtil.Fornecedor.COL_NOME));
	                fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAL));
	                fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));
	                fornecedor.setCidade(result.getString(SQLUtil.Fornecedor.COL_CIDADE));
	                fornecedor.setEstado(result.getString(SQLUtil.Fornecedor.COL_ESTADO));
	                fornecedores.add(fornecedor);
	              
	            }
	            this.conexao.close();

	        } catch (SQLException ex) {
	            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
	            ex.printStackTrace();
	            throw new ExceptionUtil("Erro ao buscar todos os fornecedores!");
	        }
	        return fornecedores;
		
	}

	@Override
	public List<Fornecedor> buscarPorNome(String nome) throws ExceptionUtil {
		Fornecedor fornecedor = null;
		ArrayList<Fornecedor> listaRetorno = new ArrayList<>();

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_NOME); 
			
			this.statement.setString(1,"%" + nome + "%");
			this.statement.setString(2,"%" + nome + "%");
			this.statement.setString(3,"%" + nome + "%");
			this.statement.setString(4,"%" + nome + "%");
			this.statement.setString(5,"%" + nome + "%");
			this.result = this.statement.executeQuery();
			
			
			while (result.next()) {
				fornecedor = new Fornecedor();
				fornecedor.setId(result.getInt(1));
				fornecedor.setNome(result.getString("nomefantasia"));
				fornecedor.setRazao_social(result.getString("razaosocial"));
				fornecedor.setCnpj(result.getString("cnpj"));
				fornecedor.setCidade(result.getString("cidade"));
				fornecedor.setEstado(result.getString("estado"));
				
				listaRetorno.add(fornecedor);

			}
		
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		//	Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			
			throw new ExceptionUtil("Erro ao buscar fornecedor!");
		}

		return listaRetorno;
		  
	}

	@Override
	public void editar(Fornecedor fornecedor) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public int getCurrentValorTabela(String tabela) throws ExceptionUtil {
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = conexao
					.prepareStatement("select id from " + tabela  + " order by id desc limit 1");

			result = this.statement.executeQuery();
			int id;
			if (result.next()) {
				id = result.getInt(1);
			} else {
				throw new ExceptionUtil("Não há registro nessa tabela");
			}
			this.conexao.close();
			return id;

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ExceptionUtil("PROBLEMA AO CONSULTAR " + tabela.toString() + " - Contate o ADM");
		}
	}
	
	
	
}
