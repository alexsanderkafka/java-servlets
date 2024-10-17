<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Despesa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Lista</title>
  <link rel="stylesheet" href="../styles/style.css">
  <link rel="stylesheet" href="../styles/style-lista-despesas.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
       
    <div class="container-list">
    	<%
	    	ArrayList<Despesa> despesas = (ArrayList<Despesa>)request.getAttribute("despesas");
	    	String dataAtual = ""; 
	    	
	    	for (int i = 0; i < despesas.size(); i++) {
	    		Despesa despesa = despesas.get(i);
	    		String dataDespesa = despesa.getData();
	    		
	    		if (!dataDespesa.equals(dataAtual)) {
	    			dataAtual = dataDespesa;
	    			%>
	    			<div class="box-list"> 
	    			  <h1><%= dataAtual %></h1>
	    	<%
	    			
	    			for (int j = i; j < despesas.size(); j++) {
	    				Despesa despesaAtual = despesas.get(j);
	    			
	    				if (!despesaAtual.getData().equals(dataAtual)) {
	    					break;
	    				}
	    	%>
			          <div class="list-tile" id="<%= despesaAtual.getId()%>">
						<%
			          	  if(despesaAtual.getCategoria().toLowerCase().equals("gasto")){
			          		  %>
			          		  <img src="../images/logo/send-money.png" alt="">
			          	<%		  
			          	  }else{
			          		 %> 
			          		 <img src="../images/logo/receive-money.png" alt="">
			          	<%
			          	  }
			          	%>
			          
			            <div class="container-text-button">
			              <div class="text-list-tile">
			                <h1><%= despesaAtual.getDescricao() %></h1>
			                
			                <%
				          	  if(despesaAtual.getCategoria().toLowerCase().equals("gasto")){
				          		  %>
								 <h5>Você guardou R$ <%= String.format("%,.2f", despesaAtual.getValor()) %></h5>
				          	<%		  
				          	  }else{
				          		 %> 
				          		 <h5>Você guardou R$ <%= String.format("%,.2f", despesaAtual.getValor()) %></h5>
				          	<%
				          	  }
				          	%>
			         
			              </div>
			              <button onclick="deleteItem(<%= despesaAtual.getId()%>)">
			                <i class="material-symbols-outlined" style="color: #FFF;">
			                  delete
			                </i>
			              </button>
			            </div>
			          </div>
	    	<%
	    			}
	    		%>
	    			</div>
	    	<%
	    		}
	    	}
	    	%>
    </div>
    <script type="text/javascript">
	    function deleteItem(id){
	    	const xhr = new XMLHttpRequest();
	    	xhr.open("POST", "http://localhost:8080/SaveMoney/despesa/excluir?id=" + id);
	    	xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	    	    		
	    	console.log(xhr.status);
	    	
	    	/*
	    	xhr.onload = function() {
	    		if (xhr.status >= 200 && xhr.status < 300) {
	    			console.log('Resposta:', xhr.responseText);
	    	 	} else {
	    	 			console.error('Erro na requisição:', xhr.statusText)
	    	 	}
	    	 };
	    	    	    
	    	 xhr.onerror = function() {
	    	 console.error('Erro na requisição');
	    	 };*/
	    	
	    	xhr.send();
	    	var div = document.getElementById(id);
	    	div.remove();
	    }
    </script>
</body>
</html>