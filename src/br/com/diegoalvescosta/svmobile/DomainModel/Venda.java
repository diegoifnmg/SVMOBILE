package br.com.diegoalvescosta.svmobile.DomainModel;

import java.util.Date;
import java.util.List;

public class Venda {
	
	int codigo;
	Cliente cliente;
	List<Produto> produto;
	Date dataVenda;
	int Tipo;
	int numParcelas;
	
	public Venda() {
		super();
	}

	public Venda(int codigo, Cliente cliente, List<Produto> produto,
			Date dataVenda, int tipo, int numParcelas) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.produto = produto;
		this.dataVenda = dataVenda;
		Tipo = tipo;
		this.numParcelas = numParcelas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	public int getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Tipo;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + codigo;
		result = prime * result
				+ ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + numParcelas;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		Venda other = (Venda) obj;
		if (Tipo != other.Tipo)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo != other.codigo)
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (numParcelas != other.numParcelas)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", cliente=" + cliente
				+ ", produto=" + produto + ", dataVenda=" + dataVenda
				+ ", Tipo=" + Tipo + ", numParcelas=" + numParcelas + "]";
	}
}
