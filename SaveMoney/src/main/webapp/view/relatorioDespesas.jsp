<%@page import="model.Despesa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Relatório</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	<link rel="stylesheet" href="../styles/style.css">
	<link rel="stylesheet" href="../styles/style-lista-despesas.css">
	<link rel="stylesheet" href="../styles/style-relatorio.css">
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
    
    <%
    	double lossTotal = (double) request.getAttribute("lossTotal");
    	double saveTotal = (double) request.getAttribute("saveTotal");
    %>
    
    <div id="container-total">
    	<div id="box-total">
    			<h1 id="total-loss">Total de despesas: R$ <%= String.format("%,.2f", lossTotal) %></h1>
    			<h1 id="total-save">Total economizado: R$ <%= String.format("%,.2f", saveTotal) %></h1>
    	</div>
    </div>
    
    <div id="container-custom-button">
	    <div id="custom-toggle-button">
	    	<input id="toggle-on" class="toggle toggle-left" name="toggle" value="false" type="radio" checked>
			<label for="toggle-on" class="btn-toggle-1">Período</label>
			<input id="toggle-off" class="toggle toggle-right" name="toggle" value="true" type="radio">
			<label for="toggle-off" class="btn-toggle-2">Categoria</label>
	    </div>
    </div>
       
    <div class="container-list" id="container-date-list-checked">
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
			          <div class="list-tile">
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
				          	  if(despesaAtual.getCategoria().toLowerCase() == "gasto"){
				          		  %>
				          		  <h5>Você gastou R$ <%= String.format("%,.2f", despesaAtual.getValor()) %></h5>
				          	<%		  
				          	  }else{
				          		 %> 
				          		 <h5>Você guardou R$ <%= String.format("%,.2f", despesaAtual.getValor()) %></h5>
				          	<%
				          	  }
				          	%>
			              </div>
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
  
  <div id="container-category-list-checked">
	  <div class="box-category-list"> 
		  <h1>Gastos</h1>
			<%
			  for(Despesa currentDespesa : despesas){
				  if(currentDespesa.getCategoria().toLowerCase().equals("gasto")){
					  %>
					  	<div class="list-tile">
							<img src="../images/logo/send-money.png" alt="">
							<div class="container-text-button">
							   <div class="text-list-tile">
							      <h1><%= currentDespesa.getDescricao() %></h1>
							      <h5>Você gastou R$ <%= String.format("%,.2f", currentDespesa.getValor()) %></h5>
							   </div>
							</div>
						</div>	  
					  <%
				  }
			  }
			 %>
		</div>
		<div class="box-category-list"> 
		  <h1>Economias</h1>
		  <%
		  for(Despesa currentDespesa : despesas){
			  if(currentDespesa.getCategoria().toLowerCase().equals("economia")){
				  %>
				  	<div class="list-tile">
						<img src="../images/logo/receive-money.png" alt="">
						<div class="container-text-button">
						   <div class="text-list-tile">
						      <h1><%= currentDespesa.getDescricao() %></h1>
						      <h5>Você guardou R$ <%= String.format("%,.2f", currentDespesa.getValor()) %></h5>
						   </div>
						</div>
					</div>	  
				  <%
			  }
		  }
		  %>
		</div>	
  </div>
  
  <script>
	  document.addEventListener("DOMContentLoaded", function() {
	      const toggleOn = document.getElementById("toggle-on");
	      const toggleOff = document.getElementById("toggle-off");
	
	      toggleOn.addEventListener("change", function() {
	          if (toggleOn.checked) {
	        	  var divDateList = document.getElementById("container-date-list-checked");
	        	  var divCategoryList = document.getElementById("container-category-list-checked");
	        	  
	        	  divCategoryList.style.display = "none";
	        	  divDateList.style.display = "flex";
	              
	              console.log("Período selecionado");
	          }
	      });
	
	      toggleOff.addEventListener("change", function() {
	          if (toggleOff.checked) {
	        	  console.log("Categoria selecionada");
	        	  var divDateList = document.getElementById("container-date-list-checked");
	        	  var divCategoryList = document.getElementById("container-category-list-checked");
	        	  
	        	  divDateList.style.display = "none";
	        	  divCategoryList.style.display = "flex";
	          }
	      });
	  });
  </script>
</body>
</html>