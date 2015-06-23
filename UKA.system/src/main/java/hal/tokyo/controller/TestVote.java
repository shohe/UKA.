package hal.tokyo.controller;

import hal.tokyo.dao.VotesDao;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestVote
 */
@WebServlet("/TestVote")
public class TestVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestVote() {
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
		
		System.out.println("投票servletとうたつ");
		String jspName = "/WEB-INF/viws/testvote.jsp";
		VotesDao dao = null;

		try {			
			String post_id = request.getParameter("post_id");
			
			System.out.println(post_id);
			System.out.println("daoに行く手前");
			dao = new VotesDao();		

			dao.Voteupdate(post_id);
			dao.commit();
			jspName = "/WEB-INF/views/voteok.jsp";
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			jspName = "/WEB-INF/views/testvote.jsp";
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(jspName);

			dispatcher.forward(request, response);
		
	
	}

}
