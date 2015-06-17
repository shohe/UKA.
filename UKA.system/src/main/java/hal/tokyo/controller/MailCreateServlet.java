package hal.tokyo.controller;

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
 * Servlet implementation class MailCreateServlet
 */
@WebServlet("/MailCreateServlet")
public class MailCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servletとうたつ");
		String jspName = "/WEB-INF/jsp/error.jsp";
		MailDao dao = null;

		try {			
			String id = request.getParameter("product_id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			System.out.println(id);
			System.out.println(title);
			System.out.println(content);
			System.out.println("daoに行く手前");
			dao = new MailDao();		

			dao.Mailinsert(id,title,content);
			dao.commit();
			jspName = "";
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			jspName = "mailok";
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(jspName);

			dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
