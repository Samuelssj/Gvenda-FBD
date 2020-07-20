package business;

import java.util.List;

import exeptions.ExceptionUtil;
import model.Endereco;
import model.Funcionario;
import model.FuncionarioAdapter;


public interface IBusinessFuncionario {
	
	
	
	
	public void salvar(Funcionario funcionario, Endereco end) throws ExceptionUtil;

	public void editar(Funcionario funcionario) throws ExceptionUtil;

	public Funcionario buscarPorId(int id) throws ExceptionUtil;
	
	public List<FuncionarioAdapter> burcarPorBuscaFuncionario(String busca) throws ExceptionUtil;
	public List<Funcionario> getAll() throws ExceptionUtil;
	
	public List<FuncionarioAdapter> getAllAdapter() throws ExceptionUtil;
	
	public Funcionario buscarPorLogin(String login, String senha) throws ExceptionUtil;

	public void ativarDesativar(int id) throws ExceptionUtil;

	public void validar(Funcionario funcionario) throws ExceptionUtil;
	
	public void validar(String Login, String Senha) throws ExceptionUtil;

}
