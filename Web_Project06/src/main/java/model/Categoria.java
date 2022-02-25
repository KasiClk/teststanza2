package model;

public class Categoria {
	
	private int id_categoria;
	private String nome_categoria;
	
	public Categoria(int id_categoria, String nome_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nome_categoria = nome_categoria;
	}

	public Categoria(String nome_categoria) {
		super();
		this.nome_categoria = nome_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public int getId_categoria() {
		return id_categoria;
	}

}