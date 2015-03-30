<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="beanLogin" class="com.br.model.Conta"></jsp:useBean>
<jsp:setProperty property="*" name="beanLogin"/>
<jsp:useBean id="beancontadao" class="com.br.dao.ContaDao"></jsp:useBean>

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
	
	
	<div class="menu">
	
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
	
	</div>
	
	
	

		
		
		 
		Seu Saldo é Insuficiente tente um valor menor
		
		
		
		
		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
