package com.br.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.conexao.ConnectionFactory;
import com.br.model.Usuario;

import java.sql.PreparedStatement;

public class UsuarioDao implements UsuarioInterface{

	private Connection connection;

	public UsuarioDao() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}
	@Override
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios3 (nome,senha) VALUES (?,?)";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}

	}

	
	@Override
	public String cc(Usuario usuario) {
		ResultSet rs;
		String numeroConta = "";
		String sql = "SELECT conta3.cc FROM usuarios3 INNER JOIN conta3 on usuarios3.id_usuario = conta3.id_conta WHERE usuarios3.nome='"+usuario.getUsuario()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				numeroConta = rs.getString("cc");
			}
			rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
		return numeroConta;
	}
	
	
	
	@Override
	public boolean AutenticarUsuario(Usuario usuario) {
		boolean autenticar = false;
		String sql = "select * from usuarios3 where " + "nome='"+usuario.getUsuario()+"' and "+"senha='"+usuario.getSenha()+"';";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rm = ps.executeQuery();
			if(rm.next()){
				autenticar = true;
			}
			rm.close();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return autenticar;

	}
	
	public int id_usuario(Usuario usuario) {
		ResultSet rs;
		int valor2 = 0;
		String sql = "SELECT usuarios3.id_usuario FROM usuarios3 WHERE " +  "nome='"+usuario.getUsuario()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				valor2 = rs.getInt("id_usuario");
				System.out.println(valor2);
			}
			rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return valor2;
	}
	

	
	
	@Override
	public ResultSet ListarUsuario() {
		ResultSet rs;
		String sql = "SELECT conta3.ag, conta3.cc, conta3.valor, usuarios3.nome	FROM usuarios3 INNER JOIN conta3 on conta3.id_conta = usuarios3.id_usuario";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
		
		return rs;

	}

}
