package model;

public class ScoringMethod {
	private int id;
	private String method;
	
	public ScoringMethod(int id, String method) {
		this.id = id;
		this.method = method;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
