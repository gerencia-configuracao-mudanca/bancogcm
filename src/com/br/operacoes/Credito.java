package com.br.operacoes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class saqueServlet
 */

public class Credito implements Command{
	
	
	public Credito() {
		super();
	}

	


	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Object cc = new Object();
		Object valorCredito = new Object();
		HttpSession session = request.getSession();
		//valorCredito = request.getAttribute("valor");
		cc = session.getAttribute("cc");
		int valor = Integer.parseInt(request.getParameter("valor"));
		int resultado = 0;
		int bonus = (int) Math.floor(valor/10);
		
		Conta conta = new Conta();
		conta.setCc(cc.toString());
		conta.setBonus(bonus);
	
		try{
			ContaDao contadao = new ContaDao();
			int qtdSaldo = contadao.Saldo(conta);

			resultado = qtdSaldo + valor;

			conta.setValor(resultado);
			contadao.Saque(conta);
			response.setContentType("text/html");
			session.setAttribute("valorCredito", valor);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return "credito.jsp";

	}

}
