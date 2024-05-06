package model;

public class Cliente {

	String cpf;
	String nome;
	int idade;
	Double limiteCredito;

	public Cliente(String cpf, String nome, int idade, Double limiteCredito) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.limiteCredito = limiteCredito;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", limiteCredito=" + limiteCredito + "]";
	}

	

}
