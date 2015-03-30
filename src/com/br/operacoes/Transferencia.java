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
 * Servlet implementation class TransferenciaServlet
 */

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
				contadao.Saque(conta);
				contadao.Debitar(conta2);
				redirecionar = "inicio.jsp";
			}else{
				redirecionar = "saldo_insuficiente.jsp";
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return redirecionar;
	}

}
