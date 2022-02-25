&euro;&euro;package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect {
	
	private Connection conn;
	private Statement st;
	private String url = "jdbc:mysql://localhost:3306/";
	private String db = "WebProdottiDB";
	
	public DBConnect() {
		try {
			creaDb();
			conn = DriverManager.getConnection(url+db, "root", "root");
			st =  conn.createStatement();
			creaTabCategoria();
			creaTabProdotti();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void creaDb() throws SQLException {
		conn = DriverManager.getConnection(url, "root", "root");
		st =  conn.createStatement();
		st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + db);
	}
	
	private void creaTabCategoria() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS categorie ("
				+ "id_categoria INT NOT NULL AUTO_INCREMENT,"
				+ "nome_categoria VARCHAR(50) UNIQUE NOT NULL,"
				+ "PRIMARY KEY(id_categoria)"
				+ ");";
		st.executeUpdate(sql);
	}
	
	private void creaTabProdotti() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS prodotti ("
				+ "id_prodotto INT NOT NULL AUTO_INCREMENT,"
				+ "nome_prodotto VARCHAR(50) NOT NULL,"
				+ "categoria_prodotto INT NOT NULL,"
				+ "prezzo DOUBLE UNSIGNED NOT NULL,"
				+ "qt INT UNSIGNED NOT NULL,"
				+ "PRIMARY KEY(id_prodotto),"
				+ "FOREIGN KEY(categoria_prodotto) REFERENCES categorie(id_categoria)"
				+ ");";
		st.executeUpdate(sql);
	}

	public ArrayList<Prodotto> getAllProdotti() {
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		String sql = "SELECT * FROM prodotti INNER JOIN categorie ON categoria_prodotto = id_categoria";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Categoria c = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
				Prodotto p = new Prodotto(rs.getInt("id_prodotto"), rs.getString("nome_prodotto"), c, rs.getDouble("prezzo"), rs.getInt("qt"));
				listaProdotti.add(p);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdotti;
	}

	public ArrayList<Categoria> getAllCategorie() {
		ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();
		String sql = "SELECT * FROM categorie";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Categoria c = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
				listaCategorie.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategorie;
	}

	public void insertCategoria(String nome_categoria) {
		String sql = "INSERT INTO categorie (nome_categoria) VALUES (?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome_categoria);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertProdotto(String nome_prodotto, int id_categoria, double prezzo, int qt) {
		String sql = "INSERT INTO prodotti (nome_prodotto, categoria_prodotto, prezzo, qt) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome_prodotto);
			ps.setInt(2, id_categoria);
			ps.setDouble(3, prezzo);
			ps.setInt(4, qt);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void modificaProdotto(int id_prodotto, String nome_prodotto, int id_categoria, double prezzo, int qt) {
		String sql = "UPDATE prodotti SET nome_prodotto = ?, categoria_prodotto = ?, prezzo = ?, qt = ? WHERE id_prodotto = " + id_prodotto;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome_prodotto);
			ps.setInt(2, id_categoria);
			ps.setDouble(3, prezzo);
			ps.setInt(4, qt);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Prodotto getProdotto(int id) {
		Prodotto p = null;
		String sql = "SELECT * FROM prodotti INNER JOIN categorie ON categoria_prodotto = id_categoria WHERE id_prodotto = " + id;
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				Categoria c = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
				p = new Prodotto(rs.getInt("id_prodotto"), rs.getString("nome_prodotto"), c, rs.getDouble("prezzo"), rs.getInt("qt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void eliminaProdotto(int id) {
		String sql = "DELETE FROM prodotti WHERE id_prodotto = " + id;
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}