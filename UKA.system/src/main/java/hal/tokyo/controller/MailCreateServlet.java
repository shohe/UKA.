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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//HTTPレスポンスの文字コード設定
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		System.out.println("管理者メールservletとうたつ");
		String jspName = "/WEB-INF/views/error.jsp";
		MailDao dao = null;

		String user_id = request.getParameter("user_id");
		String post_id = request.getParameter("post_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");



		try {			

			System.out.println(user_id);
			System.out.println(post_id);
			System.out.println(title);
			System.out.println(content);
			System.out.println("daoに行く手前");
			dao = new MailDao();		

			dao.Mailinsert(user_id,post_id,title,content);
			dao.commit();
			jspName = "mailok";
		} catch (SQLException e) {
			e.printStackTrace();
			try{
				if(dao != null){
					dao.rollback();
				}
			}catch(SQLException e1){
				e1.printStackTrace();
				jspName = "/WEB-INF/views/error.jsp";
			}
		}	catch(NamingException e){
				e.printStackTrace();
		}	finally	{
				try{
					if(dao != null){
						dao.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
					jspName = "/WEB-INF/views/error.jsp";
				}
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(jspName);

		dispatcher.forward(request, response);
	}

}
