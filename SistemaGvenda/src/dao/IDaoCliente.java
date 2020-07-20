package dao;

import java.util.ArrayList;
import java.util.List;

import exeptions.ExceptionUtil;
import model.Cliente;
import model.ClienteTabAdapter;
import model.Funcionario;



public interface IDaoCliente {
	
    public void salvar(Cliente cliente) throws ExceptionUtil;
    
    public Cliente buscarClientePorLoginSenha(String login, String senha) throws ExceptionUtil;

    public Cliente buscarPorId(int id) throws ExceptionUtil;
//
    public ArrayList<ClienteTabAdapter> buscarPorCPF(String cpf) throws ExceptionUtil;
//
    public List<ClienteTabAdapter> getAllAdapter() throws ExceptionUtil;
//
//    public List<Cliente> getAll() throws ExceptionUtil;
//
//    public void editar(Cliente cliente) throws ExceptionUtil;
//
//    public void ativarDesativar(int id) throws ExceptionUtil;
//    
    
	int getCurrentValorTabela(String tabela) throws ExceptionUtil;



}
