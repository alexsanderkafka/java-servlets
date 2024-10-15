<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar Despesa</title>
	<link rel="stylesheet" href="../styles/style.css">
	<link rel="stylesheet" href="../styles/style-cadastro.css">
</head>
<body>
	<header>
        <nav>
          <div class="logo">
          	<a class="link-logo" href="/SaveMoney">++Bolso</a>
          </div>
          <ul class="nav-list">
            <li><a href="/SaveMoney/view/cadastrarDespesa.jsp">Cadastrar Despesa</a></li>
            <li><a href="/SaveMoney/despesa/visualizar">Listar Despesas</a></li>
            <li><a href="/SaveMoney/categoria/visualizar">Relatorio</a></li>
          </ul>
        </nav>
    </header>
    
	<div class="container-initial">
        <div class="box-register">
        	<form action="/SaveMoney/despesa/cadastrar" method="POST">
	        	<label>Valor: </label>
	        	<input type="number" name="value">
	        	<label>Data: </label>
	        	<input type="date" name="date">
	        	<label>Categoria: </label>
	        	<select name="category">	
	        		<option value="loss">Gasto</option>
	    			<option value="save">Economia</option>
	        	</select>
	        	<label>Descrição: </label>
	        	<textarea rows="5" cols="2" name="description"></textarea>
	        	<input type="Submit" class="primary-buttons" value="Salvar">
        	</form>
        </div>
    </div>
</body>
</html>