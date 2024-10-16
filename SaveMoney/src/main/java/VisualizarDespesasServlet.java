import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BancoDeDados;
import model.Despesa;

@WebServlet("/despesa/visualizar")
public class VisualizarDespesasServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BancoDeDados bd = BancoDeDados.getInstancia();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
				
		List<Despesa> despesas = bd.getDespesas();
		
		request.setAttribute("despesas", despesas);
		request.getRequestDispatcher("/view/listaDespesas.jsp").forward(request, response);
	}
}
