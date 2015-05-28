package hal.tokyo.model;

public class Access {
	String url;
	String jsp;
	String method;
	
	public Access(String url, String jsp) {
		this.url = url;
		this.jsp = jsp;
	}
	
	public Access(String url, String jsp, String method) {
		this.url = url;
		this.jsp = jsp;
		this.method = method;
	}
	
	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
	
	public String getJsp() { return jsp; }
	public void setJsp(String jsp) { this.jsp = jsp; }

	public String getMethod() { return method; }
	public void setMethod(String method) { this.method = method; }
}
