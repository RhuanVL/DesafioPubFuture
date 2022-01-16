package com.example.finances.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.finances.enums.TipoConta;

@Entity
@Table(name = "contas")
public class Contas {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "saldo")
	private double saldo;

	@Column(name = "tipo_conta")
	@Enumerated(EnumType.ORDINAL)
	private TipoConta tipoConta;

	@Column(name = "instituicao_financeira")
	private String instituicaoFinanceira;

	// Método genérico
	public Contas() {}

	// Sobrecarga com método super
	public Contas(double saldo, TipoConta tipoConta, String instituicaoFinanceira) {
		super();
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	// Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, instituicaoFinanceira, saldo, tipoConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Contas other = (Contas) obj;
		return id == other.id && Objects.equals(instituicaoFinanceira, other.instituicaoFinanceira)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo)
				&& tipoConta == other.tipoConta;
	}
}