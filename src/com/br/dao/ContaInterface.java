package com.br.dao;

import java.sql.ResultSet;


import com.br.model.Conta;



public interface ContaInterface {
	public void adicionarConta(Conta conta);

	public ResultSet ListarUsuario();

	void Debitar(Conta conta);

	int Saldo(Conta conta);

	int Bonus(String conta);

	void Creditar(Conta conta);

}