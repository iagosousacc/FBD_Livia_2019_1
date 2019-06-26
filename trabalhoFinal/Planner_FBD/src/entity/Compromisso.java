package entity;

public class Compromisso {
    private int id;
    private String nome;
    private String data_compromisso;
    private String descricao;
    private String criador;

	public Compromisso( int id, String nome, String data_compromisso, String descricao, String criador){
	    this.id = id;
	    this.nome = nome;
	    this.data_compromisso = data_compromisso;
	    this.descricao = descricao;
	    this.criador = criador;
	}
	
	public Compromisso() {
		
		
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

	public String getData_compromisso() {
		return data_compromisso;
	}

	public void setData_compromisso(String data_compromisso) {
		this.data_compromisso = data_compromisso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}
	
	
	
	
	
}