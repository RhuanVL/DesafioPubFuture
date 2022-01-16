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

import com.example.finances.enums.TipoReceita;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "receitas")
public class Receitas {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "valor")
	private double valor;

	@Column(name = "data_rec")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataRecebimento;

	@Column(name = "data_rec_esp")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataRecebimentoEsperado;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "tipo_receita")
	@Enumerated(EnumType.ORDINAL)
	private TipoReceita tipoReceita;

	@Column(name = "conta")
	private String conta;

	// Método genérico
	public Receitas() {
	}

	// Sobrecarga com método super
	public Receitas(double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao,
			TipoReceita tipoReceita) {
		super();
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.tipoReceita = tipoReceita;
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

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, dataRecebimento, dataRecebimentoEsperado, descricao, id, tipoReceita, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Receitas other = (Receitas) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(dataRecebimento, other.dataRecebimento)
				&& Objects.equals(dataRecebimentoEsperado, other.dataRecebimentoEsperado)
				&& Objects.equals(descricao, other.descricao) && id == other.id && tipoReceita == other.tipoReceita
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
}
