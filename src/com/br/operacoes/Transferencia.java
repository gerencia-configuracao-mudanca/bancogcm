package com.br.operacoes;


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
		String numero_conta_ser_creditada = request.getParameter("cc");
		int valor_transferencia = Integer.parseInt(request.getParameter("valor"));
		Object numero_conta_ser_debitada = new Object();
		
		HttpSession session = request.getSession();
		numero_conta_ser_debitada = session.getAttribute("cc");
		Conta conta_ser_debitada = new Conta();
		conta_ser_debitada.setCc(numero_conta_ser_debitada.toString());
		Conta conta_ser_creditada = new Conta();
		conta_ser_creditada.setCc(numero_conta_ser_creditada);
		int credito,debito = 0;
		int bonus_credito = (int) Math.floor(valor_transferencia/10);
		
		String redirecionar = "";
		String mensagem = "";
		
		try{
			ContaDao contadao = new ContaDao();
			int qtdSaldo = contadao.Saldo(conta_ser_debitada);
			int qtdSaldo2 = contadao.Saldo(conta_ser_creditada);
			int bonus_atual = contadao.Bonus(numero_conta_ser_creditada);
			
			/*  Verificar se a conta tem saldo */
	
			if(qtdSaldo >= valor_transferencia){
				debito = qtdSaldo - valor_transferencia;
				credito = qtdSaldo2 + valor_transferencia;
				
				/*seta os valores de credito, debito e bonus*/
				conta_ser_creditada.setValor(credito);
				conta_ser_creditada.setBonus(bonus_atual + bonus_credito);
				conta_ser_debitada.setValor(debito);
				
				
				/*Proxima Parte ele chama os daos de creditar e debitar                     */
				contadao.Creditar(conta_ser_creditada);
				contadao.Debitar(conta_ser_debitada);
				mensagem = "Tranferencia no valor: " + valor_transferencia + " para a conta " + numero_conta_ser_creditada + " realizado com sucesso"; 
				response.setContentType("text/html");
				session.setAttribute("valorTranferido", valor_transferencia);
				session.setAttribute("transferencia", mensagem);
				session.setAttribute("contaDestino", numero_conta_ser_creditada);
				redirecionar = "transferencia.jsp";
			}else{
				redirecionar = "saldo_insuficiente.jsp";
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return redirecionar;
	}

}