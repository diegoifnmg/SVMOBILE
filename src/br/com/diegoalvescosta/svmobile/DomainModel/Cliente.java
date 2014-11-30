package br.com.diegoalvescosta.svmobile.DomainModel;

public class Cliente {
	
	
	int codigo;
	String Nome;
	String Telefone;
	String CPF;
	int Ativo;	
	
	public Cliente() {
		super();
	}
	public Cliente(int codigo, String nome, String telefone, String cPF,
			int ativo) {
		super();
		this.codigo = codigo;
		Nome = nome;
		Telefone = telefone;
		CPF = cPF;
		Ativo = ativo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result
				+ ((Telefone == null) ? 0 : Telefone.hashCode());
		result = prime * result + codigo;
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
		Cliente other = (Cliente) obj;
		if (Ativo != other.Ativo)
			return false;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		} else if (!Telefone.equals(other.Telefone))
			return false;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return Nome + ", Tel. " + Telefone;
	}
	
	
	
	
}
