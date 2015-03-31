package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class CreditoServlet
 */

public class Debito implements Command {

	public Debito() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object cc = new Object();
		String pagina ="";
		HttpSession session = request.getSession();
		//nome = session.getAttribute("nome");
		cc = session.getAttribute("cc");
		int valor = Integer.parseInt(request.getParameter("valor"));
		int resultado = 0;
		Conta conta = new Conta();
		conta.setCc(cc.toString());
		try{
			ContaDao contadao = new ContaDao();
			int qtdSaldo = contadao.Saldo(conta);
			if(qtdSaldo >= valor){
				resultado = qtdSaldo - valor;

				conta.setValor(resultado);
				contadao.Debitar(conta);
				pagina = "debito.jsp";
				response.setContentType("text/html");
				session.setAttribute("valorDebito", valor);
				//response.sendRedirect("inicio.jsp");
			}else{
				pagina = "saldo_insuficiente.jsp";
				//response.sendRedirect("saldoInsuficiente.jsp");
			}
			
			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return pagina;
	}

}
