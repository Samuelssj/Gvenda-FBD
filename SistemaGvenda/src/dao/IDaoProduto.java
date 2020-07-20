package dao;

import java.util.List;

import exeptions.ExceptionUtil;
import model.Produto;

public interface IDaoProduto {
	
	
	
	public int salvar(Produto produto) throws ExceptionUtil;

	public Produto buscarPorId(int id) throws  ExceptionUtil;

	public List<Produto> getAll() throws ExceptionUtil;

	public void editar(Produto produto) throws  ExceptionUtil;

	public void ativarDesativar(int id) throws  ExceptionUtil;
	

}
