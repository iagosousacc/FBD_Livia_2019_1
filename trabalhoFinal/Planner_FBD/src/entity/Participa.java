package entity;

public class Participa {
    private int fid;
    private int cid;
    private boolean compareceu;

	public Participa(int fid, int cid, boolean compareceu){
	    this.fid = fid;
	    this.cid = cid;
	    this.compareceu = compareceu;
	}
	
	public Participa() {
		
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

	public boolean isCompareceu() {
		return compareceu;
	}

	public void setCompareceu(boolean compareceu) {
		this.compareceu = compareceu;
	}
	
	
	
}