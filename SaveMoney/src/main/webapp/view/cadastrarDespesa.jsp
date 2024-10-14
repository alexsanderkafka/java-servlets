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
          	<a href="/SaveMoney">++Bolso</a>
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
        	<label>Valor: </label>
        	<input type="number">
        	<label>Data: </label>
        	<input type="date">
        	<label>Categoria: </label>
        	<select>
        		<option value="loss">Gasto</option>
    			<option value="save">Economia</option>
        	</select>
        	<label>Descrição: </label>
        	<textarea rows="5" cols="2"></textarea>
        	<button class="primary-buttons">Salvar</button>
        </div>
    </div>
</body>
</html>