package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.demo.beans.Empleat;
import com.example.demo.beans.Feina;

public class BaseDades {
	
	private Connection connexio;
	
	public BaseDades() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex = "jdbc:mysql://localhost:3306/treballadors_bd";
			this.connexio = DriverManager.getConnection(conex,"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertar(Empleat empleat) {
		String query = "insert into treballadors (nom, feina, sou)" + "values(?,?,?)";
		try {
			PreparedStatement preparedStmt = connexio.prepareStatement(query);
			//preparedStmt.setInt(1, empleat.getId());
			preparedStmt.setString(1, empleat.getNom());
			preparedStmt.setString(2, empleat.getFeina().toString());
			preparedStmt.setInt(3, empleat.getSou());
			preparedStmt.executeUpdate();
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	public void borrar(int id) {
		String query = "delete from treballadors where id=" + id;
		try {
			PreparedStatement preparedStmt = connexio.prepareStatement(query);
			preparedStmt.executeUpdate();
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	public void modificar(Empleat empleat) {
		String query = "update treballadors set nom=?, feina=?" + "where id=?";
		try {
			PreparedStatement preparedStmt = connexio.prepareStatement(query);
			preparedStmt.setString(1, empleat.getNom());
			preparedStmt.setString(2, empleat.getFeina().toString());
			preparedStmt.setInt(3, empleat.getId());
			System.out.print(preparedStmt.toString());
			preparedStmt.executeUpdate();
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	public Empleat getEmpleat(int id) {
		Empleat empleat = null;
		try {
			Statement s = connexio.createStatement();
			String sql = "SELECT * FROM treballadors WHERE ID=" + id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			empleat = new Empleat(rs.getInt(1), rs.getString(2), Feina.valueOf(rs.getString(3)));
			
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
		
		return empleat;

	}
	
	public ArrayList<Empleat> getEmpleats(){
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		
		try {
			Statement s = connexio.createStatement();
			String sql = "SELECT * FROM treballadors";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				Empleat empleat = new Empleat(rs.getInt(1), rs.getString(2), Feina.valueOf(rs.getString(3)));
				empleats.add(empleat);
			}
			
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}	
		return empleats;	
	}
	
	public ArrayList<Empleat> buscar(Feina feina){
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		
		try {
			Statement s = connexio.createStatement();
			String sql = "SELECT * FROM treballadors WHERE FEINA = '" + feina.toString() + "'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				Empleat empleat = new Empleat(rs.getInt(1), rs.getString(2), Feina.valueOf(rs.getString(3)));
				empleats.add(empleat);
			}
			
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}	
		return empleats;	
	}

}
