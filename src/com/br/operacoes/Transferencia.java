package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;


public class Transferencia implements Command {
       
   
    public Transferencia() {
        super();
    }

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String ccdestino = request.getParameter("cc");
		int valor = Integer.parseInt(request.getParameter("valor"));
		Object cc = new Object();
		HttpSession session = request.getSession();
		cc = session.getAttribute("cc");
		Conta conta = new Conta();
		conta.setCc(cc.toString());
		Conta conta2 = new Conta();
		conta2.setCc(ccdestino);
		int credito,debito = 0;
		int bonus = (int) Math.floor(valor * 0.5);
		
		String redirecionar = "";
		
		try{
			ContaDao contadao = new ContaDao();
			int qtdSaldo = contadao.Saldo(conta);
			int qtdSaldo2 = contadao.Saldo(conta2);
			if(qtdSaldo >= valor){
				credito = qtdSaldo - valor;
				debito = qtdSaldo2 + valor;
				conta2.setValor(debito);
				conta.setValor(credito);
				conta2.setBonus(bonus);
				contadao.Saque(conta);
				contadao.Debitar(conta2);
				response.setContentType("text/html");
				session.setAttribute("valorTranferido", valor);
				session.setAttribute("contaDestino", ccdestino);
				redirecionar = "transferencia2.jsp";
			}else{
				redirecionar = "saldo_insuficiente.jsp";
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return redirecionar;
	}

}
