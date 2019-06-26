package entity;

public class Diario {
    private int fid;
    private String anotacao;
    private String data_anotacao;

	public Diario(int fid, String anotacao, String data_anotacao){
	    this.fid = fid;
	    this.anotacao = anotacao;
	    this.data_anotacao = data_anotacao;
	}
	
	public Diario() {
		
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public String getData_anotacao() {
		return data_anotacao;
	}

	public void setData_anotacao(String data_anotacao) {
		this.data_anotacao = data_anotacao;
	}
	
	
	
}