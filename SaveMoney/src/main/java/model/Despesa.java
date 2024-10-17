package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
public class Despesa {
	private Integer id;
	private String descricao;
	private Double valor;
	private String data;
	private String categoria;
	
	public Despesa() {
		
	}
	
	public Despesa(String descricao, Double valor, String data, String categoria) {
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
	}
	
	public Despesa(Integer id, String descricao, Double valor, String data, String categoria) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData() {
		try {
			String currentDate = LocalDate.parse(data).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return currentDate;
		}catch (Exception e) {
			System.out.println("Erro date: " + e.getLocalizedMessage());
			return this.data;
		}
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
