package hal.tokyo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.tokyo.beans.Administrator_MAILBean;
import hal.tokyo.dao.MailDao;
/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//initializer
		String jspName = "/WEB-INF/jsp/error.jsp";
		MailDao dao = null;

		
		
		//値を受け取る
		String administrator_mail_id = request.getParameter("administrator_mail_id");
		//String date = request.getParameter("date");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String posting_id = request.getParameter("posting_id");

		MailDao newRecord = new MailDao();
		newRecord.setName(request.getParameter("name"));

		dao = new MailDao();
		dao.commit();

		jspName = "/select";




		RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);

		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
