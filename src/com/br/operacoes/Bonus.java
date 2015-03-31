package com.br.operacoes;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class saldoServlet
 */

public class Bonus implements Command {
       
   
    public Bonus() {
        super();
    }
    
    
		public String execute(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Integer qtd = new Integer(0);
			try{
				Conta conta = new Conta();
				//Usuario usuario = new Usuario();
				HttpSession sessao = request.getSession();
				String numconta = "";
				numconta = String.valueOf(sessao.getAttribute("cc"));
				conta.setCc(numconta);
				//usuario.setUsuario(nome.toString());
				ContaDao contadao = new ContaDao();
				qtd = contadao.Bonus(numconta);
				//UsuarioDao usuariodao = new UsuarioDao();
				//qtd = usuariodao.Saldo(usuario);
				System.out.println(qtd);
				response.setContentType("text/html");
				sessao.setAttribute("saveBonus", qtd);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("saldo2.jsp");
				//dispatcher.forward(request, response);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			return "bonus.jsp";

		}
	
	
}