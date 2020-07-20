package dao;

import java.util.List;

import exeptions.ExceptionUtil;
import model.Fornecedor;


public interface IDaoFornecedor {
	
	   public void salvar(Fornecedor fornecedor) throws ExceptionUtil;

	    public Fornecedor buscarPorId(int id) throws ExceptionUtil;
	    public List<Fornecedor> getAll() throws ExceptionUtil;

	    public List<Fornecedor> buscarPorNome(String nome) throws ExceptionUtil;
	    
	    public void editar(Fornecedor fornecedor) throws ExceptionUtil;

	    public void ativarDesativar(int id) throws ExceptionUtil;
	    int getCurrentValorTabela(String tabela) throws ExceptionUtil;
}
