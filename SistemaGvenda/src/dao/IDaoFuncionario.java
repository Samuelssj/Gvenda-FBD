package dao;

import java.util.List;

import exeptions.ExceptionUtil;
import model.Endereco;
import model.Funcionario;
import model.FuncionarioAdapter;


public interface IDaoFuncionario {
	
	public void salvar(Funcionario funcionario, Endereco end) throws ExceptionUtil;

	public Funcionario buscarPorId(int id) throws ExceptionUtil;
	
	public List<FuncionarioAdapter> buscarPorBusca(String busca) throws ExceptionUtil;

	public List<Funcionario> getAll() throws ExceptionUtil;
	
	public List<FuncionarioAdapter> getAllAdapter() throws ExceptionUtil;
	
	public Funcionario buscarLogin(String login, String senha) throws ExceptionUtil;

	public void editar(Funcionario funcionario) throws ExceptionUtil;

	public void ativarDesativar(int id) throws ExceptionUtil;

}
