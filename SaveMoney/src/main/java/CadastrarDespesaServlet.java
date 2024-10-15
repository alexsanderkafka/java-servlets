import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Despesa;

@WebServlet("/despesa/cadastrar")
public class CadastrarDespesaServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doPost(request, response);
		
		
		/*
		String description = request.getParameter("description");
		Double value = Double.valueOf(request.getParameter("value"));
		String category = request.getParameter("categoria");
		String date = request.getParameter("date");*/
		//Despesa despesa = new Despesa(descricao, valor, data, categoria);
		
		response.sendRedirect("/SaveMoney/despesa/visualizar");
		//request.getRequestDispatcher("/view/listaDespesas.jsp").forward(request, response);
	}
	
}
