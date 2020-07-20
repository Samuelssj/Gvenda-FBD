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
import model.Endereco;
import model.Funcionario;
import model.FuncionarioAdapter;
import sql.SQLConections;
import sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario {
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	@Override
	public void salvar(Funcionario funcionario, Endereco end) throws ExceptionUtil {
		
		try {
			int id_endereco = DaoComunicar.salvarEndereco(funcionario.getEndereco());
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.INSERT);
			this.statement.setString(1, funcionario.getNome());
			this.statement.setString(2, funcionario.getCpf());
			this.statement.setString(3, funcionario.getCargo());
			this.statement.setString(4, funcionario.getLogin());
			this.statement.setString(5, funcionario.getSenha());
			this.statement.setInt(6, id_endereco);
			this.statement.setBoolean(7, funcionario.isSituacao());
			statement.executeQuery();
			this.conexao.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new ExceptionUtil("Erro ao salvar o funcionario!");
		}

	}
		
	
 
	@Override
	public Funcionario buscarPorId(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioAdapter> buscarPorBusca(String busca) throws ExceptionUtil {

		FuncionarioAdapter funcionarioTabAdapter = null;
		ArrayList<FuncionarioAdapter> listaRetorno = new ArrayList<>();

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.SELECT_POR_BUSCA); 
			
			this.statement.setString(1,"%" + busca + "%");
			this.statement.setString(2,"%" + busca + "%");
			this.statement.setString(3,"%" + busca + "%");
			this.result = this.statement.executeQuery();
			
			
			while (result.next()) {
				funcionarioTabAdapter = new FuncionarioAdapter();
				funcionarioTabAdapter.setId(result.getInt(1));
				funcionarioTabAdapter.setNome(result.getString("nome"));
				funcionarioTabAdapter.setCpf(result.getString("cpf"));
				funcionarioTabAdapter.setCargo(result.getString("cargo"));
				funcionarioTabAdapter.setRua(result.getString("rua"));
				funcionarioTabAdapter.setBairro(result.getString("bairro"));
				funcionarioTabAdapter.setSituacao(result.getBoolean("situacao"));
				listaRetorno.add(funcionarioTabAdapter);

			}
		
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		//	Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			
			throw new ExceptionUtil("Erro ao buscar cliente por!");
		}

		return listaRetorno;
		  
	}
		
		
		
		
		
	

	@Override
	public List<Funcionario> getAll() throws ExceptionUtil {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioAdapter> getAllAdapter() throws ExceptionUtil {
		List<FuncionarioAdapter> funcionarioAdapters = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.SELECT_FUNC_ADAPTER);
			this.result = this.statement.executeQuery();
			FuncionarioAdapter funcionarioAdapter = null;
			
			while (result.next()) {
				funcionarioAdapter = new FuncionarioAdapter();
				funcionarioAdapter.setId(result.getInt(1));
				funcionarioAdapter.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				funcionarioAdapter.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				funcionarioAdapter.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				funcionarioAdapter.setRua(result.getString("rua"));
				funcionarioAdapter.setBairro(result.getString("bairro"));
				funcionarioAdapter.setSituacao(result.getBoolean(SQLUtil.Funcionario.COL_SITUACAO));
				funcionarioAdapters.add(funcionarioAdapter);
				
			}
			this.conexao.close();

		} catch (SQLException ex) {
			//Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new ExceptionUtil("Erro ao buscar todos os Funcionários!");
		}
		return funcionarioAdapters;
	}

	@Override
	public Funcionario buscarLogin(String login, String senha) throws ExceptionUtil {
		try {
			Funcionario func = null;
			Endereco endereco = null;
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.SELECT_LOGIN);
			this.statement.setString(1, login);
			this.statement.setString(2, senha);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				func = new Funcionario();
				func.setId(result.getInt(1));
				func.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				func.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				func.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				func.setLogin(result.getString(SQLUtil.Funcionario.COL_LOGIN));
				func.setSenha(result.getString(SQLUtil.Funcionario.COL_SENHA));
				//endereco = DaoComunicar.buscarEndereco(result.getInt(SQLUtil.Funcionario.COL_ENDERECO));
				//func.setEndereco(endereco);
				func.setSituacao(result.getBoolean(SQLUtil.Funcionario.COL_SITUACAO));

			}
			return func;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionUtil("Erro ao buscar funcionario! Dados incorretos");
		}
	}

	@Override
	public void editar(Funcionario funcionario) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws ExceptionUtil {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
