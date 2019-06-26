package entity;

public class Externo{
    private int cid;
    private String cliente;
    private String local_compromisso;
    private String forma_de_alocacao;

    public Externo(int cid, String cliente, String local_compromisso, String forma_de_alocacao){
	    this.cid = cid;
	    this.cliente = cliente;
	    this.local_compromisso = local_compromisso;
	    this.forma_de_alocacao = forma_de_alocacao;
	}
    
    public Externo() {
    	
    }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getLocal_compromisso() {
		return local_compromisso;
	}

	public void setLocal_compromisso(String local_compromisso) {
		this.local_compromisso = local_compromisso;
	}

	public String getForma_de_alocacao() {
		return forma_de_alocacao;
	}

	public void setForma_de_alocacao(String forma_de_alocacao) {
		this.forma_de_alocacao = forma_de_alocacao;
	}
    
    
}
