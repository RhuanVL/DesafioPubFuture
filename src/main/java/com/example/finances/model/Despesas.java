package com.example.finances.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.finances.enums.TipoDespesa;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "despesas")
public class Despesas {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "valor")
	private double valor;

	@Column(name = "data_pag")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataPagamento;

	@Column(name = "data_pag_esp")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataPagamentoEsperado;

	@Column(name = "tipo_despesa")
	@Enumerated(EnumType.ORDINAL)
	private TipoDespesa tipoDespesas;

	@Column(name = "conta")
	private String conta;

	// Metodo Generico
	public Despesas() {
	}

	// Sobrecarga com metodo super
	public Despesas(double valor, Date dataPagamento, Date dataPagamentoEsperado, TipoDespesa tipoDespesas) {
		super();
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesas = tipoDespesas;
	}

	// Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public TipoDespesa getTipoDespesas() {
		return tipoDespesas;
	}

	public void setTipoDespesas(TipoDespesa tipoDespesas) {
		this.tipoDespesas = tipoDespesas;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, dataPagamento, dataPagamentoEsperado, id, tipoDespesas, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Despesas other = (Despesas) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(dataPagamento, other.dataPagamento)
				&& Objects.equals(dataPagamentoEsperado, other.dataPagamentoEsperado) && id == other.id
				&& tipoDespesas == other.tipoDespesas
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
}
