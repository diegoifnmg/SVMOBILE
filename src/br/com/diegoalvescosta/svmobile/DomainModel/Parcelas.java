package br.com.diegoalvescosta.svmobile.DomainModel;

import java.util.Date;

public class Parcelas {

	int codigo;
	int ativo;
	Date dataVencimento;
	Venda venda;
	public Parcelas() {
		super();
	}
	public Parcelas(int codigo, int ativo, Date dataVencimento, Venda venda) {
		super();
		this.codigo = codigo;
		this.ativo = ativo;
		this.dataVencimento = dataVencimento;
		this.venda = venda;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	@Override
	public String toString() {
		return "Parcelas [codigo=" + codigo + ", ativo=" + ativo
				+ ", dataVencimento=" + dataVencimento + ", venda=" + venda
				+ "]";
	}
	
	
	
	
}
