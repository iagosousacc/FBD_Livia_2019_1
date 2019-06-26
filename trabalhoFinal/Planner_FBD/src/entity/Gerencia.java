package entity;

public class Gerencia {
    private int fid;
    private int cid;
    private String data_da_criacao;

	public Gerencia(int fid, int cid, String data_da_criacao){
	    this.fid = fid;
	    this.cid = cid;
	    this.data_da_criacao = data_da_criacao;
	}
	
	public Gerencia() {
		
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getData_da_criacao() {
		return data_da_criacao;
	}

	public void setData_da_criacao(String data_da_criacao) {
		this.data_da_criacao = data_da_criacao;
	}
	
	
	
}