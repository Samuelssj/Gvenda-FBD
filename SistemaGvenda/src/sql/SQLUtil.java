package sql;

public class SQLUtil {

	public static final String ID = "id";

	public static class Endereco {

		public static final String TABELA = "endereco";
		public static final String RUA = "rua";
		public static final String CEP = "cep";
		public static final String NUMERO = "numero";
		public static final String BAIRRO = "bairro";
		public static final String CIDADE = "cidade";
		public static final String ESTADO = "estado";

		public static final String INSERT = "insert into " + TABELA + "(" + RUA + "," + CEP + "," + NUMERO + ","
				+ BAIRRO + "," + CIDADE + "," + ESTADO + " ) values (?,?,?,?,?,?) returning id";

		public static final String SELECT_END = "select* from endereco where id=?";
		
		public static final String UPDATE = "update endereco set rua = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ? where id = ?";
	}

	public static class Contato {
 
		public static final String TABELA = "contato";
		public static final String TIPO = "tipo";
		public static final String DESCRICAO = "descricao";
		public static final String CLIENTE_ID = "cliente_id";

		public static final String SELECT_ALL = "select * from contato where cliente_id = ?";

		public static final String INSERT = "insert into " + TABELA + "(" + DESCRICAO + "," + TIPO + "," + CLIENTE_ID
				+ " ) values (?,?,?)";

		public static final String UPDATE = "update contato set tipo = ?, descricao = ? where id = ?";
	}

	public static class Cliente {

		// public static final String ENDERECO = "endereco_id";

		public static final String TABELA = "cliente";
		public static final String NOME = "nome";
		public static final String CPF = "cpf";
		public static final String SEXO = "sexo";
		public static final String NASCIMENTO = "data_nascimento";
		public static final String ENDERECO_ID = "endereco_id";

		public static final String INSERT = "insert into " + TABELA + "(" + NOME + "," + CPF + "," + SEXO + ","
				+ NASCIMENTO + "," + ENDERECO_ID + ") values (?,?,?,?,?) ";


		public static final String SELECT_CPF = "select distinct c.id, c.nome, c.cpf, c.data_nascimento, "
				+ "e.rua, e.bairro, e.numero from cliente c inner join endereco e "
				+ "on c.endereco_id = e.id and (c.cpf ilike ? or c.nome ilike ? or e.rua ilike ?)";

		public static final String SELECT_ALL_ADAPTER = "select c.id, c.nome, c.cpf, c.data_nascimento, "
				+ "e.rua, e.bairro, e.numero from cliente c inner join endereco e " + "on c.endereco_id = e.id";

		public static final String UPDATE = "update cliente set nome = ?, cpf = ?, sexo = ?, estado_civil = ?,"
				+ "ocupacao = ?, data_nascimento = ? where id = ?";

	}

//	
	public static class Produto {

		public static final String NOME_TABELA = "produto";
		public static final String NOME_PRODUTO = "nome";
		public static final String MARCA = "marca";
		public static final String DESCRICAO = "descricao";
		
		public static final String INSERT = "insert into " + NOME_TABELA + "(" + NOME_PRODUTO + "," + MARCA + ","
				+ DESCRICAO + ") values (?,?,?) returning id";
		
		public static final String SELECT_ALL_ADAPTER = "select c.id, c.nome, c.marca, c.descricao, "
				+ "e.cod_barras, e.unidade_medida, e.data_fabricacao, e.data_validade,e.data_compra,e.preco_unidade,e.porc_atacado,e.porc_varejo,e.quantidade,e.vendidos from produto c inner join item_produto e " + "on c.item_produto_id = e.id";
		

		public static final String UPDATE = "update produto set nome = ?, marca = ?, descricao = ?";

	}

	public static class Item_Produto {

		public static final String NOME_TABELA = "item_produto";
		public static final String COL_COD_BARRAS = "cod_barras";
		public static final String COL_UNIADE_MEDIDA = "unidade_medida";
		public static final String COL_DATA_FABRICACAO = "data_fabricacao";
		public static final String COL_DATA_VALIDADE = "data_validade";
		public static final String COL_DATA_COMPRA = "data_compra";
		public static final String COL_PRECO_UNIDADE = "preco_unidade";
		public static final String COL_PORC_ATACADO = "porc_atacado";
		public static final String COL_PORC_VAREJO = "porc_varejo";
		public static final String COL_QUANTIDADE = "quantidade";
		public static final String COL_VENDIDOS = "vendidos";
		public static final String COL_PERECIVEL = "perecivel";
		public static final String COL_STATUS = "status";
		public static final String COL_FORNECEDOR_ID = "fornecedor_id";
		public static final String COL_PRODUTO_ID = "produto_id";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_COD_BARRAS + ","
				+ COL_UNIADE_MEDIDA + "," + COL_DATA_FABRICACAO + "," + COL_DATA_VALIDADE + "," + COL_DATA_COMPRA + ","
				+ COL_PRECO_UNIDADE + "," + COL_PORC_ATACADO + "," + COL_PORC_VAREJO + "," + COL_QUANTIDADE + ","
				+ COL_VENDIDOS + "," + COL_PERECIVEL + "," + COL_STATUS + "," + COL_FORNECEDOR_ID + "," + COL_PRODUTO_ID
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning id";

		public static final String SELECT_PRODUTO_ALL_BUSCA = "select p.descricao, p.marca, i.cod_barras,i.porc_varejo, i.quantidade, i.data_compra, i.status\r\n"
				+ " from item_produto i inner join produto p \r\n"
				+ "   on i.produto_id = p.id and i.vendidos < i.quantidade and (i.cod_barras ilike ? or p.descricao ilike ? or p.marca ilike ?)";

		public static final String SELECT_PRODUTO_ALL = "select p.id, p.descricao, p.marca, i.id, i.fornecedor_id, i.cod_barras, "
				+ "i.porc_varejo, i.quantidade, i.data_compra, i.status from item_produto i inner join produto p "
				+ "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade";
		
		

		public static final String SELECT_PRODUTO_ALL_POR_BUSCA = "select p.descricao, p.marca, i.cod_barras, "
				+ "i.porc_varejo, i.quantidade, i.data_compra, i.status from item_produto i inner join produto p "
				+ "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade";

		public static final String SELECT_PROD_LIST_EST_ALL_BUSCA = "select i.id, i.cod_barras, "
				+ "i.porc_varejo, p.descricao from item_produto i inner join produto p "
				+ "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade "
				+ "and (i.cod_barras ilike ? or p.descricao ilike ?)";

		public static final String SELECT_PROD_LIST_EST_ALL = "select i.id, i.cod_barras, "
				+ "i.porc_varejo, p.descricao from item_produto i inner join produto p "
				+ "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade";

		public static final String SELECT_PROD_LIST_VEND = "select i.id, i.cod_barras, "
				+ "i.quantidade, i.porc_varejo, p.descricao from item_produto i inner join produto p on i.produto_id = p.id "
				+ "where i.id = ? and i.status = true and i.vendidos < i.quantidade";

		public static final String UPDATE = "update item_produto set perecivel = ?, status = ?, quantidade = ?, cod_barras = ?, "
				+ "data_fabricacao = ?, data_validade = ?, data_compra = ?, preco_unidade = ?,"
				+ "porc_atacado = ?, porc_varejo = ? where item_produto.id = ?";

		public static final String SELECT_VENDIDOS = "select i.vendidos from item_produto i "
				+ "where id = ? and i.status = true and i.vendidos < i.quantidade";

		public static final String UPDATE_VENDIDOS = "update item_produto set vendidos = ? where id = ?";
		
		
		
	}


	public static class Funcionario {

		public static final String NOME_TABELA = "funcionario";
		public static final String COL_NOME = "nome";
		public static final String COL_CPF = "cpf";
		public static final String COL_CARGO = "cargo";
		public static final String COL_LOGIN = "login";
		public static final String COL_SENHA = "senha";
		public static final String COL_ENDERECO = "endereco_id";
		public static final String COL_SITUACAO = "situacao";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + "," + COL_CPF + ","
				+ COL_CARGO + "," + COL_LOGIN + "," + COL_SENHA + "," + COL_ENDERECO + "," + COL_SITUACAO
				+ " ) values (?,?,?,?,?,?,?) returning id";

		public static final String UPDATE = "update funcionario set nome = ?, cpf = ?,cargo = ?, login = ?, senha = ?, situacao = ? where id = ?";

		public static final String SELECT_LOGIN = "select * from funcionario where login = ?  and senha = ?";

		public static final String SELECT_FUNC_ADAPTER = "select f.id, f.nome, f.cpf, f.cargo, f.situacao, e.rua, "
				+ "e.bairro from funcionario f inner join endereco e on f.endereco_id = e.id";
		
		public static final String SELECT_POR_BUSCA ="select distinct c.id, c.nome, c.cpf, c.cargo,c.situacao, "
		+ "e.rua, e.bairro, e.numero from funcionario c inner join endereco e "
		+ "on c.endereco_id = e.id and (c.cpf ilike ? or c.nome ilike ? or e.rua ilike ?)";
		
	}

	public static class Caixa {

		public static final String NOME_TABELA = "caixa";
		public static final String COL_ENTRADA = "entrada";
		public static final String COL_SAIDA = "saida";
		public static final String COL_SALDO = "saldo";
		public static final String COL_FUNCIONARIO = "funcionario_id";
		public static final String COL_DATA_ABERTURA = "data_abertura";
		public static final String COL_DATA_FECHAMENTO = "data_fechamento";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_ENTRADA + "," + COL_SAIDA + ","
				+ COL_SALDO + "," + COL_FUNCIONARIO + "," + COL_DATA_ABERTURA + "," + COL_DATA_FECHAMENTO
				+ " ) values (?,?,?,?,?,?) ";

		public static final String SELECT_DATA = "select * from caixa where data_abertura = ?";

		public static final String SELECT_ANTERIOR = "select * from caixa where id = (select max(id) from caixa)";

		public static final String UPDATE = "update caixa set entrada = ?, saida = ?, saldo = ? where id = ?";
		public static final String UPDATE_DATA = "update caixa set entrada = ?, saldo = ? where id = ?";

	}

	public static class Pagamento {

		public static final String NOME_TABELA = "pagamento";

		public static final String COL_VALOR = "valor";
		public static final String COL_DATA_VENCIMENTO = "data_vencimento";
		public static final String COL_NUMERO = "numero";
		public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
		public static final String COL_CLIENTE_ID = "cliente_id";
		public static final String COL_VENDA_ID = "venda_id";
		public static final String COL_STATUS = "status";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR + "," + COL_DATA_VENCIMENTO
				+ "," + COL_NUMERO + "," + COL_FORMA_PAGAMENTO + "," + COL_CLIENTE_ID + "," + COL_VENDA_ID + ","
				+ COL_STATUS + " ) values (?,?,?,?,?,?,?) returning id";

		public static final String UPDATE = "update pagamento set valor = ?, data_vencimento = ?, numero = ?,"
				+ "forma_pagamento = ?, status = ?";

	}

	public static class Fornecedor {

		public static final String NOME_TABELA = "fornecedor";
		public static final String COL_NOME = "nomefantasia";
		public static final String COL_RAZAO_SOCIAL = "razaosocial";
		public static final String COL_CNPJ = "cnpj";
		public static final String COL_ESTADO = "estado";
		public static final String COL_CIDADE = "cidade";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + "," + COL_RAZAO_SOCIAL + ","
				+ COL_CNPJ + "," + COL_ESTADO + "," + COL_CIDADE + " ) values (?,?,?,?,?) returning id ";
//
		public static final String SELECT_NOME = "select * from fornecedor where nomefantasia ilike ? "
				+ "or razaosocial ilike ? or cnpj ilike ? or estado ilike ? or cidade ilike ?";
////		
//		public static final String SELECT_NOME ="select distinct c.id, c.nomefantasia, c.razaosocial, c.cnpj, "
//		+ "e.estado, e.cidade from fornecedor c inner join endereco e ";
//	

		public static final String UPDATE = "update fornecedor set nome_fantasia = ?, razao_social = ?, cnpj = ?,"
				+ "estado = ?, cidade = ? where id = ?";

	}

	public static class Venda {

		public static final String NOME_TABELA = "venda";
		public static final String COL_VALOR_TOTAL = "valor_total";
		public static final String COL_DESC_GERAL = "desc_geral";
		public static final String COL_VALOR_TROCO = "valor_troco";
		public static final String COL_VALOR_RECEBIDO = "valor_recebido";
		public static final String COL_DATA_VENDA = "data_venda";
		public static final String COL_CLIENTE_ID = "cliente_id";
		public static final String COL_FUNCIONARIO_ID = "funcionario_id";
		public static final String COL_CAIXA_ID = "caixa_id";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR_TOTAL + "," + COL_DESC_GERAL
				+ "," + COL_VALOR_TROCO + "," + COL_VALOR_RECEBIDO + "," + COL_DATA_VENDA + "," + COL_CLIENTE_ID + ","
				+ COL_FUNCIONARIO_ID + "," + COL_CAIXA_ID + " ) values (?,?,?,?,?,?,?,?) returning id";

		public static final String INSERT_VEND_INI = "insert into " + NOME_TABELA + "(" + COL_DATA_VENDA + ","
				+ COL_FUNCIONARIO_ID + "," + COL_CAIXA_ID + " ) values (?,?,?) returning id";

		public static final String SELECT_VENDA = "select v.valor_total, v.desc_geral, v.valor_troco, v.valor_recebido"
				+ " from venda v where id = ?";

		public static final String UPDATE_VENDA = "update venda set valor_total = ?, desc_geral = ?, "
				+ "valor_troco = ?, valor_recebido = ? where id = ?";

		public static final String UPDATE_VENDA_CLI_ID = "update venda set cliente_id = ? where id = ?";

	}

	public static class Item_Venda {

		public static final String NOME_TABELA = "item_venda";
		public static final String COL_VALOR_DESC = "valor_desc";
		public static final String COL_PORC_PROMOC = "porc_promoc";
		public static final String COL_PROMOCAO = "promocao";
		public static final String COL_TIPO = "tipo";
		public static final String COL_QUANT = "quant";
		public static final String COL_VALOR_ITEM = "valor_item";
		public static final String COL_DESCONTO = "desconto";
		public static final String COL_VENDA_ID = "venda_id";
		public static final String COL_ITEM_PRODUTO_ID = "item_produto_id";

		public static final String INSERT = " insert into " + NOME_TABELA + "(" + COL_VALOR_DESC + "," + COL_PORC_PROMOC
				+ "," + COL_PROMOCAO + "," + COL_TIPO + "," + COL_QUANT + "," + COL_VALOR_ITEM + "," + COL_DESCONTO
				+ "," + COL_VENDA_ID + "," + COL_ITEM_PRODUTO_ID + " ) values (?,?,?,?,?,?,?,?,?) returning id";

		public static final String UPDATE = "update item_venda set valor_desc = ?, porc_promoc = ?, promocao = ?, tipo = ?,"
				+ "quant = ?, valor_item = ?, desconto = ? where id = ?";
	}

	public static class Contas_a_Receber {

		public static final String NOME_TABELA = "contas_a_receber";
		public static final String COL_DESCRICAO = "descr";
		public static final String COL_VALOR = "valor_total";
		public static final String COL_VALOR_QUITADO = "valor_pago";
		public static final String COL_QTD_PGMT = "qtd_pagmt";
		public static final String COL_QTD_PAGA = "qtd_pago";
		public static final String COL_SALDO = "saldo";
		public static final String COL_DATA_PAG = "data_pag";
		public static final String COL_DATA_VENC = "data_venc";
		public static final String COL_CAIXA_ID = "caixa_id";
		public static final String COL_VENDA_ID = "venda_id";
		public static final String COL_STATUS = "ativo";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + "," + COL_VALOR + ","
				+ COL_VALOR_QUITADO + "," + COL_QTD_PGMT + "," + COL_QTD_PAGA + "," + COL_SALDO + "," + COL_DATA_PAG
				+ "," + COL_DATA_VENC + "," + COL_CAIXA_ID + "," + COL_VENDA_ID + "," + COL_STATUS
				+ ") values (?,?,?,?,?,?,?,?,?,?,?) returning id";

		public static final String SELECT_ALL_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c ";

		public static final String SELECT_A_RECEB_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c where c.status = true";

		public static final String SELECT_RECEBIDA_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c where c.status = false";

		public static final String UPDATE = " update contas_a_receber set descricao = ?, valor = ?, qtd_pgmt = ?, valor_quitado = ?,"
				+ "saldo = ?, status = ? where id = ?";

	}

	public static class Contas_a_Pagar {

		public static final String NOME_TABELA = "contas_a_pagar";
		public static final String COL_DESCRICAO = "descricao";
		public static final String COL_VALOR = "valor";
		public static final String COL_VALOR_QUITADO = "valor_quitado";
		public static final String COL_QTD_PGMT = "qtd_pgmt";
		public static final String COL_QTD_PAGA = "qtd_paga";
		public static final String COL_DATA_PAG = "data_pagamento";
		public static final String COL_DATA_VENC = "data_vencimento";
		public static final String COL_CAIXA_ID = "caixa_id";
		public static final String COL_FORNEC_ID = "fornecedor_id";
		public static final String COL_STATUS = "status";

		public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + "," + COL_VALOR + ","
				+ COL_VALOR_QUITADO + "," + COL_QTD_PGMT + "," + COL_QTD_PAGA + "," + COL_DATA_PAG + "," + COL_DATA_VENC
				+ "," + COL_CAIXA_ID + "," + COL_FORNEC_ID + "," + COL_STATUS
				+ ") values (?,?,?,?,?,?,?,?,?,?) returning id";

		public static final String SELECT_ALL_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c ";

		public static final String SELECT_A_PAG_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c where c.status = true";

		public static final String SELECT_PAGA_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
				+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c where c.status = false";

		public static final String UPDATE = " update contas_a_receber set valor = ?, descricao = ?, fornecedor_id = ?, status = ? where id = ?";

		public static final String SELECT_RELATORIO = "select distinct * from contas_a_pagar cc inner join contas_a_receber cv "
				+ "on cc.caixa_id = cv.caixa_id and cc.data_vencimento BETWEEN ? "
				+ "and ? and cv.data_venc BETWEEN ? and ?";
	}

	public static String selectAll(String nomeTabela) {
		return "select * from " + nomeTabela;
	}

	public static String selectById(String nomeTabela, int id) {
		return "select * from " + nomeTabela + " where id = " + id;
	}

}
