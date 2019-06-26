package entity;

public class Funcionario {
    private int id;
    private String nome;
    private int time;

	public Funcionario(int id, String nome, int time){
	    this.id = id;
	    this.nome = nome;
	    this.time = time;
	}
	
	public Funcionario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	

}