import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/despesa/excluir")
public class ExcluirDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		// Lógica para encontrar e excluir a despesa da lista
		//despesas.removeIf(despesa -> despesa.getId().equals(id)); // despesas deve ser uma lista disponível
		// Redireciona para a listagem de despesas após a exclusão
		response.sendRedirect("despesa/visualizar");
	}
	
	

}
