package model;

public class Prodotto {
	
	private int id_prodotto;
	private String nome_prodotto;
	private Categoria categoria;
	private double prezzo;
	private int qt;
	
	public Prodotto(int id_prodotto, String nome_prodotto, Categoria categoria, double prezzo, int qt) {
		super();
		this.id_prodotto = id_prodotto;
		this.nome_prodotto = nome_prodotto;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.qt = qt;
	}

	public Prodotto(String nome_prodotto, Categoria categoria, double prezzo, int qt) {
		super();
		this.nome_prodotto = nome_prodotto;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.qt = qt;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public int getId_prodotto() {
		return id_prodotto;
	}

}