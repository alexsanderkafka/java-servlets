import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BancoDeDados;
import model.Despesa;

@WebServlet("/despesa/cadastrar")
public class CadastrarDespesaServlet extends HttpServlet{
	
	private BancoDeDados db = BancoDeDados.getInstancia();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doPost(request, response);
		
		String description = request.getParameter("description");
		Double value = Double.valueOf(request.getParameter("value"));
		String category = request.getParameter("category");
		String date = request.getParameter("date").toString();
		Despesa despesa = new Despesa(description, value, date, category);
		
		db.addDespesa(despesa);
		
		System.out.println("Descrição: " + description);
		
		response.sendRedirect("/SaveMoney/despesa/visualizar");
	}
	
}
