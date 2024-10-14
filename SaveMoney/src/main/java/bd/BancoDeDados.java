package bd;

import java.util.ArrayList;
import java.util.List;

import model.Despesa;

public class BancoDeDados {
	private List<Despesa> despesas;
	
	
    public BancoDeDados() {
        despesas = new ArrayList<>();

        despesas.add(new Despesa(1, "Aluguel", 1200.00, "2024-01-01", "Moradia"));
        despesas.add(new Despesa(2, "Supermercado", 300.00, "2024-01-05", "Alimentação"));
        despesas.add(new Despesa(3, "Conta de Luz", 150.00, "2024-01-10", "Utilidades"));
        despesas.add(new Despesa(4, "Transporte", 100.00, "2024-01-15", "Transporte"));
        despesas.add(new Despesa(5, "Internet", 90.00, "2024-01-20", "Utilidades"));
    }


	public List<Despesa> getDespesas() {
		return despesas;
	}
    
    
}
