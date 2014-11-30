package br.com.diegoalvescosta.svmobile.DomainModel;

import java.util.Date;

public class Caixa {

	int codigo;
	Double saldo;
	Date dataCaixa;
	
	
	public Caixa() {
		super();
	}

	public Caixa(int codigo, Double saldo, Date dataCaixa) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.dataCaixa = dataCaixa;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public Date getDataCaixa() {
		
		
		return dataCaixa;
	}


	public void setDataCaixa(Date dataCaixa) {
		this.dataCaixa = dataCaixa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result
				+ ((dataCaixa == null) ? 0 : dataCaixa.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caixa other = (Caixa) obj;
		if (codigo != other.codigo)
			return false;
		if (dataCaixa == null) {
			if (other.dataCaixa != null)
				return false;
		} else if (!dataCaixa.equals(other.dataCaixa))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caixa [codigo=" + codigo + ", saldo=" + saldo + ", dataCaixa="
				+ dataCaixa + "]";
	}
		
}
