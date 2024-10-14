import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/categoria/visualizar")
public class VisualizarCategoriasDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		
		
		// Lógica para listar categorias
		//List<String> categorias = // Obtenha a lista de categoriass
		//request.setAttribute("categoriasDespesas", categorias);
		request.getRequestDispatcher("relatorioDespesas.jsp").forward(request, response);
	}

	
}
