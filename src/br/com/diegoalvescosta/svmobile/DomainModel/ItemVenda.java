package br.com.diegoalvescosta.svmobile.DomainModel;

public class ItemVenda {

	int codigo;
    int quantidade;
    Venda venda;
    Produto produto;
	
    public ItemVenda() {
		super();
	}

	public ItemVenda(int codigo, int quantidade, Venda venda, Produto produto) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.venda = venda;
		this.produto = produto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
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
		ItemVenda other = (ItemVenda) obj;
		if (codigo != other.codigo)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemVenda [codigo=" + codigo + ", quantidade=" + quantidade
				+ ", venda=" + venda + ", produto=" + produto + "]";
	}
	
    
	
}
