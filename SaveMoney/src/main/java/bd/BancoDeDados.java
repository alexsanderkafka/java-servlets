package bd;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Despesa;

public class BancoDeDados {
	
	private static BancoDeDados instanciaUnica;
	private List<Despesa> despesas;
	private final String dbFile = "despesas.json";
	private final ObjectMapper objectMapper;
	
	
    private BancoDeDados() {
    	objectMapper = new ObjectMapper();
        load();
    }
    
    private void load() {
		try {
			File file = new File(dbFile);
			
			if(!file.exists()) file.mkdirs();
			
			System.out.println("Path: " + file.getAbsolutePath());
			
			despesas = objectMapper.readValue(file, new TypeReference<List<Despesa>>(){});
			
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
		int id = despesas.get(despesas.size() - 1).getId() + 1;
		despesa.setId(id);
		despesas.add(despesa);
		save();
	}
	
	public double getLossTotal() {
		double total = 0.0;
		
		for(Despesa currentDespesa : despesas) {
			if(currentDespesa.getCategoria().toLowerCase().equals("gasto")) total += currentDespesa.getValor();
		}
		
		return total;
	}
	
	public double getSaveTotal() {
		double total = 0.0;
		
		for(Despesa currentDespesa : despesas) {
			if(currentDespesa.getCategoria().toLowerCase().equals("economia")) total += currentDespesa.getValor();
		}
		
		return total;
	}
	
	public void remove(Integer id) {
		despesas.remove(id - 1);
		save();
	}
	
	private void save() {
		try {
            File file = new File(dbFile);
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, despesas);
	        System.out.println("Despesas salvas com sucesso em " + dbFile);
        } catch (IOException e) {
            System.err.println("Erro ao salvar despesas no arquivo JSON: " + e.getMessage());
        }
	}
}
