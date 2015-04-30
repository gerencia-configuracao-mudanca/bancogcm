<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="beanLogin" class="com.br.model.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="beanLogin"/>
<jsp:useBean id="beanusuariodao" class="com.br.dao.UsuarioDao"></jsp:useBean>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="./design/css/style.css" />
<link rel="stylesheet" type="text/css"  href="./design/css/estilo.css" />

</head>
<body>




<div class="container">
	<section id="content">
		
	
	<ol id="toc" >
    <li><a href="inicio.jsp">Home</a></li>
    <li>
    <form action="Controller" method="post">
        <a href="saldo.jsp" onclick="parentNode.submit();">Saldo</a>
				<input type="hidden" id="cmd" required  name="cmd" value="saldo"/>
    </form>
	</li>
    <li class="current"><a href="creditar.jsp">Crédito</a></li>
    <li><a href="transferencia.jsp">Transferencia</a></li>
    <li><a href="debitar.jsp">Debitar</a></li>
    
    
</ol>
<%Object valor =  session.getAttribute("valorCredito"); %>
<%Object cc =  session.getAttribute("cc"); %>


	Crédito no valor <%= valor.toString() %>	
	para a conta 
	<%= cc.toString() %> 
	realizado com sucesso		
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
