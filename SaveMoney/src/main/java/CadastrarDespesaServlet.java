import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Despesa;

@WebServlet("/despesa/cadastrar")
public class CadastrarDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
		// Lógica para cadastrar nova despesa
		String descricao = request.getParameter("descricao");
		Double valor = Double.valueOf(request.getParameter("valor"));
		String categoria = request.getParameter("categoria");
		String data = request.getParameter("data");
		Despesa despesa = new Despesa(descricao, valor, data, categoria);
		// Adicione a despesa à lista ou banco de dados
		response.sendRedirect("despesa/visualizar"); // Redireciona para a listagem de despesas
	}
	
}
