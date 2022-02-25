package model;

public class User {
	
	private String nome;
	private String cognome;
	private String citta;
	private String email;
	private String password;
	
	public User() {
		super();
		this.nome = "Clark";
		this.cognome = "Kasi";
		this.citta = "Roma";
		this.email = "admin@admin.com";
		this.password = "Vampiro";
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCitta() {
		return citta;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	

}