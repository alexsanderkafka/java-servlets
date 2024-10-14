import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Despesa;

@WebServlet("/despesa/editar")
public class EditarDespesaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
		Integer id = Integer.valueOf(request.getParameter("quot;id&quot"));
		String descricao = request.getParameter("descricao");
		Double valor = Double.valueOf(request.getParameter("valor"));
		String categoria = request.getParameter("categoria");
		String data = request.getParameter("data");
		
		/*
		// Lógica para encontrar a despesa existente e atualizar os dados
		for (Despesa despesa : despesas) { // despesas deve ser uma lista disponível
			if (despesa.getId().equals(id)) {
				despesa.setDescricao(descricao);
				despesa.setValor(valor);
				despesa.setCategoria(categoria);
				despesa.setData(data);
				break;
			}
		}*/
		
		// Redireciona para a listagem de despesas após a edição
		response.sendRedirect("despesa/visualizar");
	}
	
	
}
