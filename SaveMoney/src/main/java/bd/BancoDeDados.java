package bd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import model.Despesa;

public class BancoDeDados {
	
	private static BancoDeDados instanciaUnica;
	private List<Despesa> despesas;
	private final String dbFile = "despesas.json";
	private final ObjectMapper objectMapper;
	
	
    private BancoDeDados() {
        load();
        objectMapper = new ObjectMapper();
        		/*
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
        despesas.add(new Despesa(15, "Internet", 90.00, "2024-01-09", "Gasto"));*/
    }
    
    private void load() {
		try {
			File file = new File(dbFile);
			if(file.exists()) {
				despesas = objectMapper.readValue(file, new TypeReference<List<Despesa>>(){});
			}
		}catch (IOException e) {
			System.err.println("Erro ao carregar despesas do arquivo JSON: " + e.getMessage());
		}
	}

	public static BancoDeDados getInstancia() {
    	if (instanciaUnica == null) {
            instanciaUnica = new BancoDeDados();
        }
        return instanciaUnica;
    }

	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public void addDespesa(Despesa despesa) {
		despesas.add(despesa);
		save();
	}
	
	private void save() {
		try {
            objectMapper.writeValue(new File(dbFile), despesas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar despesas no arquivo JSON: " + e.getMessage());
        }
	}
	
	
    
    
}
