package hal.tokyo.controller;

import hal.tokyo.dao.MailDao;

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
 * Servlet implementation class EnquiryCreateServlet
 */
@WebServlet("/EnquiryCreateServlet")
public class EnquiryCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		//HTTPレスポンスの文字コード設定
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("Enquiry Servletとうたつ");
		String jspName = "/WEB-INF/viws/enquirystart.jsp";
		MailDao dao = null;

		try {			
			String id = request.getParameter("user_id");
			String enq = request.getParameter("enq");
			String content = request.getParameter("content");
			
			System.out.println(id);
			System.out.println(enq);
			System.out.println(content);
			System.out.println("daoに行く手前");
			dao = new MailDao();		

			dao.Enqinsert(id,enq,content);
			dao.commit();
			jspName = "mailok";
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			jspName = "/WEB-INF/viws/mailok.jsp";
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
