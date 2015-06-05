package hal.tokyo.model;

public class Access extends Object {
	String url;
	String servlet;
	String jsp;
	String method;
	
	public Access(String url, String[] jspWithServlet) {
		this.url = url;
		this.jsp = jspWithServlet[0];
		this.servlet = jspWithServlet[1];
	}
	
	public Access(String url, String[] jspWithServlet, String method) {
		this.url = url;
		this.jsp = jspWithServlet[0];
		this.servlet = jspWithServlet[1];
		this.method = method;
	}
	
	public String getServlet() { return servlet; }
	public void setServlet(String servlet) { this.servlet = servlet; }

	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
	
	public String getJsp() { return jsp; }
	public void setJsp(String jsp) { this.jsp = jsp; }

	public String getMethod() { return method; }
	public void setMethod(String method) { this.method = method; }
}
