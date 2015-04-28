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

		Object cc = new Object();

		HttpSession session = request.getSession();
		//valorCredito = request.getAttribute("valor");
		cc = session.getAttribute("cc");
		float valor = Integer.parseInt(request.getParameter("valor"));
		float resultado = 0;
		float bonus_atual = 0;
		float bonus = (float) Math.floor(valor * 0.03);
		String mensagem = "";
		
		
		try{
			ContaDao contadao = new ContaDao();
			bonus_atual = contadao.Bonus(cc.toString());
			Conta conta = new Conta();
			conta.setCc(cc.toString());
			conta.setBonus(bonus_atual + bonus);
			
			float qtdSaldo = contadao.Saldo(conta);

			resultado = qtdSaldo + valor;
			conta.setValor(resultado);
			contadao.Creditar(conta);

			mensagem = "Desricao da operacao: Credito no valor de: " + valor + " para a conta " + cc + " realizado com sucesso";
			response.setContentType("text/html");
			session.setAttribute("mensagemCredito", mensagem);
			session.setAttribute("valorCredito", valor);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return "creditar.jsp";

	}

}