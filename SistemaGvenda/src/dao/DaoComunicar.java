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
import model.Contato;
import model.Endereco;
import model.TipoContato;
import sql.SQLConections;
import sql.SQLUtil;


public class DaoComunicar {
    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;
    
    
    
    public static int salvarEndereco(Endereco end) throws ExceptionUtil {
        int id = 0;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT);
            statement.setString(1, end.getRua());
            statement.setString(2, end.getCep());
            statement.setString(3, end.getNumero());
            statement.setString(4, end.getBairro());
            statement.setString(5, end.getCidade());
            statement.setString(6, end.getEstado());

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoComunicar.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionUtil("endereÁo n„o salvo!");
        }
        return id;
    }

    public static void editarEndereco(Endereco end) throws DaoException {
        int id = 0;
        try {
            conexao = SQLConections.getInstance();
       //     statement = conexao.prepareStatement(SQLUtil.Endereco.UPDATE);
            statement.setString(1, end.getRua());
            statement.setString(2, end.getCep());
            statement.setString(3, end.getNumero());
            statement.setString(4, end.getBairro());
            statement.setString(5, end.getCidade());
            statement.setString(6, end.getEstado());
            statement.setInt(7, end.getId());
            statement.execute();


        } catch (SQLException ex) {
            Logger.getLogger(DaoComunicar.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Erro ao editar endere√ßo do cliente!");
        }
    }

    public static int salvarContato(Contato contato, int cliente_id) throws ExceptionUtil {
        int id =0;
    	try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Contato.INSERT);
            statement.setString(1, contato.getDescricao());
            statement.setString(2, contato.getTipo().getValor());
            statement.setInt(3, cliente_id);

            statement.execute();
            if (result.next()) {
                id = result.getInt(1);
            }
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoComunicar.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionUtil("Erro ao salvar contato do cliente!");
        }
        return id;
    }

    public static void editarContato(Contato contato) throws DaoException {

        try {
            conexao = SQLConections.getInstance();
          //  statement = conexao.prepareStatement(SQLUtil.Contato.UPDATE);
            statement.setString(1, contato.getTipo().getValor());
            statement.setString(2, contato.getDescricao());
            statement.setInt(3, contato.getId());


            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoComunicar.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Erro ao editar contato do cliente!");
        }

    }

    public  static  Endereco buscarEndereco(int id) throws ExceptionUtil {
    		
    	Endereco end = new Endereco();
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.TABELA, id));
            result = statement.executeQuery();

            if(result.next()){
                end.setId(result.getInt(1));
                end.setRua(result.getString(SQLUtil.Endereco.RUA));
                end.setCep(result.getString(SQLUtil.Endereco.CEP));
                end.setNumero(result.getString(SQLUtil.Endereco.NUMERO));
                end.setBairro(result.getString(SQLUtil.Endereco.BAIRRO));
                end.setCidade(result.getString(SQLUtil.Endereco.CIDADE));
                end.setEstado(result.getString(SQLUtil.Endereco.ESTADO));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionUtil("Erro ao buscar endere√ßo do cliente!");
        }
        return  end;
    }
    
    public static Contato buscarContato(Contato cont) throws DaoException {
    	
    	try {
    		conexao = SQLConections.getInstance();
		//	statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contato.NOME_TABELA, cont.getId()));
			result = statement.executeQuery();
			
			if(result.next()) {
				cont.setId(result.getInt(1));
			//	cont.setTipo(TipoContato.getTipoContato(result.getString(SQLUtil.Contato.COL_TIPO)));
				System.out.println(cont.getTipo());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar contato do cliente!");
		}
    	return cont;
    }
    
public static List<Contato> buscarContato(int id) throws ExceptionUtil {
    	List<Contato> contatos = new ArrayList<>();
    	try {
    		conexao = SQLConections.getInstance();
    		statement = conexao.prepareStatement(SQLUtil.Contato.SELECT_ALL);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			Contato cont = null;
			while(result.next()) {
				cont = new Contato();
				cont.setId(result.getInt(1));
				cont.setTipo(TipoContato.getTipoContato(result.getString(SQLUtil.Contato.TIPO)));
				cont.setDescricao(result.getString(SQLUtil.Contato.DESCRICAO));
				contatos.add(cont);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionUtil("Erro ao buscar contato do cliente!");
		}
    	return contatos;
    }

}
