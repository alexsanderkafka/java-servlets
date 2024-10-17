import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BancoDeDados;

@WebServlet("/despesa/excluir")
public class ExcluirDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BancoDeDados bd = BancoDeDados.getInstancia();

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("Id: " + id);
		
		bd.remove(id);
		
		//response.getStatus();
		//response.sendRedirect("/despesa/visualizar");
		//response.sendError(HttpServletResponse.SC_OK);
		
		response.setStatus(200);
		response.sendRedirect("/SaveMoney/despesa/visualizar");
		//request.getRequestDispatcher("/despesa/visualizar").forward(request, response);
	}
	
	

}
