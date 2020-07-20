package model;


public enum TipoContato {
	
	EMAIL("EMAIL"), TELEFONE("TELEFONE"), FACEBOOK("FACEBOOK");
	private String descricao;

	private TipoContato(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return this.descricao;
	}

	public static TipoContato getTipoContato(String tipo) {
		for (TipoContato t : values()) {
			if (t.getValor().equalsIgnoreCase(tipo))
				return t;
		}
		return null;
	}


}
