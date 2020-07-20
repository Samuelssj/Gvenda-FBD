package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.logging.Logger;

import exeptions.ExceptionUtil;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;
import model.ClienteTabAdapter;
import model.Contato;
import model.Endereco;
import sql.SQLConections;
import sql.SQLUtil;
import view.Mensagem;

public abstract class DaoCliente implements IDaoCliente {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public void salvar(Cliente cliente) throws ExceptionUtil {
		try {

			int id_endereco = DaoComunicar.salvarEndereco(cliente.getEndereco());
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.INSERT);
			this.statement.setString(1, cliente.getNome());
			this.statement.setString(2, cliente.getCpf());
			this.statement.setString(3, cliente.getSexo());
			this.statement.setString(4, cliente.getData_nascimento());
			this.statement.setInt(5, id_endereco);
			this.statement.execute();
			int id = 0;

				id = getCurrentValorTabela("cliente");

			for (Contato cont : cliente.getContatos()) {
				DaoComunicar.salvarContato(cont, id);
			}

			this.statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionUtil("Dados Iguais - CPF ja cadastrado");
		}

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
	
	

	
	
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws ExceptionUtil {
		Cliente cliente = null;

		try {
			this.conexao = SQLConections.getInstance();
//			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.selectLoginSenha(login, senha));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt(SQLUtil.ID));
				cliente.setNome(result.getString(SQLUtil.Cliente.NOME));
				cliente.setCpf(result.getString(SQLUtil.Cliente.CPF));
				cliente.setSexo(result.getString(SQLUtil.Cliente.SEXO));
				cliente.setData_nascimento(result.getString(SQLUtil.Cliente.NASCIMENTO));
				

			}
			this.conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionUtil("erro ao acessar o banco");
			// TODO: handle exception
		}
		;
		if (cliente == null) {
			throw new ExceptionUtil("cliente não existe");
		}
		return cliente;

	}

	@Override
	public Cliente buscarPorId(int id) throws ExceptionUtil {

		Cliente cliente = null;
		Endereco endereco = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.SELECT_END, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(SQLUtil.Cliente.NOME));
				cliente.setCpf(result.getString(SQLUtil.Cliente.CPF));
				cliente.setSexo(result.getString(SQLUtil.Cliente.SEXO));
				cliente.setData_nascimento(result.getString(SQLUtil.Cliente.NASCIMENTO));
				endereco = DaoComunicar.buscarEndereco(result.getInt(SQLUtil.Cliente.ENDERECO_ID));
				cliente.setEndereco(endereco);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ExceptionUtil("Erro ao buscar cliente!");
		}
		return cliente;

	}

	@Override
	public ArrayList<ClienteTabAdapter> buscarPorCPF(String busca) throws ExceptionUtil {

		ClienteTabAdapter clienteTabAdapter = null;
		ArrayList<ClienteTabAdapter> listaRetorno = new ArrayList<>();

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF); 
			
			this.statement.setString(1,"%" + busca + "%");
			this.statement.setString(2,"%" + busca + "%");
			this.statement.setString(3,"%" + busca + "%");
			this.result = this.statement.executeQuery();
			
			
			while (result.next()) {
				clienteTabAdapter = new ClienteTabAdapter();
				clienteTabAdapter.setId(result.getInt(1));
				clienteTabAdapter.setNome(result.getString("nome"));
				clienteTabAdapter.setCpf(result.getString("cpf"));
				clienteTabAdapter.setData_nascimento(result.getString("data_nascimento"));
				clienteTabAdapter.setRua(result.getString("rua"));
				clienteTabAdapter.setBairro(result.getString("bairro"));
				clienteTabAdapter.setNumero(result.getString("numero"));
				listaRetorno.add(clienteTabAdapter);

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
	public List<ClienteTabAdapter> getAllAdapter() throws ExceptionUtil {

		List<ClienteTabAdapter> clienteTabAdapters = new ArrayList<>();

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.SELECT_ALL_ADAPTER);
			this.result = this.statement.executeQuery();
			ClienteTabAdapter clienteTabAdapter = null;
			while (result.next()) {
				clienteTabAdapter = new ClienteTabAdapter();
				clienteTabAdapter.setId(result.getInt(1));
				clienteTabAdapter.setNome(result.getString("nome"));
				clienteTabAdapter.setCpf(result.getString("cpf"));
				clienteTabAdapter.setData_nascimento(result.getString("data_nascimento"));
				clienteTabAdapter.setRua(result.getString("rua"));
				clienteTabAdapter.setBairro(result.getString("bairro"));
				clienteTabAdapter.setNumero(result.getString("numero"));
				clienteTabAdapters.add(clienteTabAdapter);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			// Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			throw new ExceptionUtil("Erro ao buscar cliente!");
		}

		return clienteTabAdapters;
	}
}

//
//	@Override
//	public List<Cliente> getAll() throws ExceptionUtil {
//
//		List<Cliente> clientes = new ArrayList<>();
//		try {
//			this.conexao = SQLConections.getInstance();
//			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Cliente.TABELA));
//			this.result = this.statement.executeQuery();
//			Cliente cliente;
//			while (result.next()) {
//				cliente = new Cliente();
//				cliente.setId(result.getInt(1));
//				cliente.setNome(result.getString(SQLUtil.Cliente.NOME));
//				cliente.setCpf(result.getString(SQLUtil.Cliente.CPF));
//				cliente.setSexo(result.getString(SQLUtil.Cliente.SEXO));
//				cliente.setData_nascimento(result.getString(SQLUtil.Cliente.NASCIMENTO));
//				Endereco endereco = DaoComunicar.buscarEndereco(cliente.getId());
////				cliente.setEndereco(endereco);
//				clientes.add(cliente);
//			}
//			this.conexao.close();
//
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
//			throw new DaoException("Erro ao buscar todos os clientes!");
//		}
//		return clientes;
//		  throw new UnsupportedOperationException("Not supported yet.");
//
//	}
//
//	@Override
//	public void editar(Cliente cliente) throws ExceptionUtil {
//
////		
//		  throw new UnsupportedOperationException("Not supported yet.");
//	}
//
//	@Override
//	public void ativarDesativar(int id) throws ExceptionUtil {
//
//	}
//
//
//
