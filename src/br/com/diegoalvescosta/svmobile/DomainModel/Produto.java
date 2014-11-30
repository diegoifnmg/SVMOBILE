package br.com.diegoalvescosta.svmobile.DomainModel;

public class Produto {
	
	int codigo;
	String nome;
	int QTD;
	Double preco;
	int Ativo;
	
	
	public Produto() {
		super();
		Ativo = 1;
	}


	public Produto(int codigo, String nome, int qTD, Double preco, int ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		QTD = qTD;
		this.preco = preco;
		Ativo = ativo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQTD() {
		return QTD;
	}


	public void setQTD(int qTD) {
		QTD = qTD;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public int getAtivo() {
		return Ativo;
	}


	public void setAtivo(int ativo) {
		Ativo = ativo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Ativo;
		result = prime * result + QTD;
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Produto other = (Produto) obj;
		if (Ativo != other.Ativo)
			return false;
		if (QTD != other.QTD)
			return false;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  nome + ", Estoque=" + QTD + ", Preco=" + preco;
	}

	


	
}
