package com.br.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.conexao.ConnectionFactory;
import com.br.model.Conta;



public class ContaDao implements ContaInterface{

	private Connection connection;

	public ContaDao() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void adicionarConta(Conta conta) {
		String sql = "INSERT INTO conta3 (ag,cc,valor,id_conta) VALUES (?,?,?,?)";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);			
			ps.setLong(1, conta.getAg());
			ps.setString(2, conta.getCc());
			ps.setFloat(3, conta.getValor());
			ps.setLong(4, conta.getId_conta());
			ps.execute();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
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
	

	@Override
	public int Saldo(Conta conta) {
		ResultSet rs;
		int valor2 = 0;
		String sql = "SELECT conta3.valor FROM usuarios3 INNER JOIN conta3 on usuarios3.id_usuario = conta3.id_conta WHERE conta3.cc='"+conta.getCc()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				valor2 = rs.getInt("valor");
				System.out.println(valor2);
			}
			//rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return valor2;
	}	

	@Override
	public int Bonus(String conta) {
		ResultSet rs;
		int bonus = 0;
		String sql = "SELECT FROM conta3 WHERE conta3.cc = "+conta+";";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				bonus = rs.getInt("bonus");
			}
			System.out.println("Bonus igual a: " + bonus);
			//rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return bonus;
	}
	
	
	@Override
	public void Saque(Conta conta) {
		String sql = "UPDATE conta3 SET conta3.valor= "+ conta.getValor()+", conta3.bonus= "+conta.getBonus()+" where conta3.cc= '"+conta.getCc()+ "';";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			ps.execute();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
	}


	@Override
	public void Debitar(Conta conta) {
		String sql = "UPDATE conta3 SET conta3.valor= "+ conta.getValor()+" where conta3.cc= '"+conta.getCc()+ "';";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			ps.execute();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
	}
	
	
}
