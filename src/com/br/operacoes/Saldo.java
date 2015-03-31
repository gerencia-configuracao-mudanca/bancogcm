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

public class Saldo implements Command {
       
   
    public Saldo() {
        super();
    }
    
    
		public String execute(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object nome = new Object();
			Integer qtd = new Integer(0);
			try{
				Conta conta = new Conta();
				//Usuario usuario = new Usuario();
				HttpSession sessao = request.getSession();
				nome = sessao.getAttribute("cc");
				conta.setCc(nome.toString());
				//usuario.setUsuario(nome.toString());
				ContaDao contadao = new ContaDao();
				qtd = contadao.Saldo(conta);
				//UsuarioDao usuariodao = new UsuarioDao();
				//qtd = usuariodao.Saldo(usuario);
				System.out.println(qtd);
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", qtd);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("saldo2.jsp");
				//dispatcher.forward(request, response);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			return "saldo.jsp";

		}
	
	
}