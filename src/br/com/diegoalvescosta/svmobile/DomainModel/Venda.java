package br.com.diegoalvescosta.svmobile.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	
	int codigo;
	Cliente cliente;
	List<Produto> produto;
	Caixa caixa;
	Date dataVenda;
	int Tipo;
	int numParcelas;
	Double valorTotal;
	ArrayList<ItemVenda> itensVenda;
	
	public Venda() {
		super();
		itensVenda = new ArrayList<ItemVenda>();
	}

	

	public Venda(int codigo, Cliente cliente, List<Produto> produto,
			Caixa caixa, Date dataVenda, int tipo, int numParcelas) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.produto = produto;
		this.caixa = caixa;
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



	public Caixa getCaixa() {
		return caixa;
	}



	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
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



	public ArrayList<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	public void addItemVenda(ItemVenda itemVenda) throws Exception{
        if(!itensVenda.contains(itemVenda)){
            itensVenda.add(itemVenda);
            
            double valor = itemVenda.getValorTotalItem() + getValorTotal();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item já esta na lista de Vendas");
        }
    }
	
	
	public void removeItemVenda(ItemVenda itemVenda) throws Exception{
        if(itensVenda.contains(itemVenda)){
            itensVenda.remove(itemVenda);
            
            double valor = getValorTotal() - itemVenda.getValorTotalItem();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item não existe na lista de Vendas!");
        }
    }
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Tipo;
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + codigo;
		result = prime * result
				+ ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result
				+ ((itensVenda == null) ? 0 : itensVenda.hashCode());
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
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
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
		if (itensVenda == null) {
			if (other.itensVenda != null)
				return false;
		} else if (!itensVenda.equals(other.itensVenda))
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
				+ ", produto=" + produto + ", caixa=" + caixa + ", dataVenda="
				+ dataVenda + ", Tipo=" + Tipo + ", numParcelas=" + numParcelas
				+ ", itensVenda=" + itensVenda + "]";
	}




	

	
}
