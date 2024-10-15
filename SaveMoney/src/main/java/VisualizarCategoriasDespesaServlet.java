import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BancoDeDados;
import model.Despesa;

@WebServlet("/categoria/visualizar")
public class VisualizarCategoriasDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BancoDeDados db = new BancoDeDados();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		
		List<Despesa> despesas = db.getDespesas();
		
		request.setAttribute("despesas", despesas);
		request.getRequestDispatcher("/view/relatorioDespesas.jsp").forward(request, response);
	}

	
}
