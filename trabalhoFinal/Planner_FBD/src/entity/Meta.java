package entity;

public class Meta {
    private int fid;
    private String nome_meta;
    private String descricao;

    public Meta(int fid, String nome_meta, String descricao){
    	this.fid = fid;
    	this.nome_meta = nome_meta;
    	this.descricao = descricao;
    }
    
    public Meta() {
    	
    }

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getNome_meta() {
		return nome_meta;
	}

	public void setNome_meta(String nome_meta) {
		this.nome_meta = nome_meta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
}