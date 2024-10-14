package bd;

import java.util.ArrayList;
import java.util.List;

import model.Despesa;

public class BancoDeDados {
	private List<Despesa> despesas;
	
    public BancoDeDados() {
        despesas = new ArrayList<>();

        despesas.add(new Despesa(1, "Aluguel", 1200.00, "2024-01-01", "Gasto"));
        despesas.add(new Despesa(2, "Supermercado", 300.00, "2024-01-01", "Gasto"));
        despesas.add(new Despesa(3, "Extra do mês", 150.00, "2024-01-01", "Economia"));
        despesas.add(new Despesa(4, "Extra do mês", 100.00, "2024-01-01", "Economia"));
        despesas.add(new Despesa(5, "Internet", 90.00, "2024-01-01", "Gasto"));
        
        despesas.add(new Despesa(6, "Aluguel", 1200.00, "2024-01-02", "Gasto"));
        despesas.add(new Despesa(7, "Supermercado", 300.00, "2024-01-02", "Gasto"));
        despesas.add(new Despesa(8, "Extra do mês", 150.00, "2024-01-03", "Economia"));
        despesas.add(new Despesa(9, "Extra do mês", 100.00, "2024-01-03", "Economia"));
        despesas.add(new Despesa(10, "Internet", 90.00, "2024-01-04", "Gasto"));
        
        despesas.add(new Despesa(11, "Aluguel", 1200.00, "2024-01-07", "Gasto"));
        despesas.add(new Despesa(12, "Supermercado", 300.00, "2024-01-07", "Gasto"));
        despesas.add(new Despesa(13, "Extra do mês", 150.00, "2024-01-07", "Economia"));
        despesas.add(new Despesa(14, "Extra do mês", 100.00, "2024-01-08", "Economia"));
        despesas.add(new Despesa(15, "Internet", 90.00, "2024-01-09", "Gasto"));
    }

	public List<Despesa> getDespesas() {
		return despesas;
	}
    
    
}
