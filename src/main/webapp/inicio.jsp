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
    <li class="current"><a href="cadastro_conta.jsp">Cadastro de Conta</a></li>
    <li><a href="operacoes.jsp">Opera��es</a></li>
    <li><a href="listar_clientes.jsp">Listar Clientes</a></li>
    
</ol>
<form action="Controller" method="post">
<input type="hidden" id="cmd" required  name="cmd" value="Logout"/>
<input type="submit" value="Logout" >
</form>
		
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
