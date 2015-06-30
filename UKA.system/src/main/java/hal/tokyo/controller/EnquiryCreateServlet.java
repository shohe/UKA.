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
		
		System.out.println("Enquiry Servletとうたつ");
		String jspName = "";
		MailDao dao = null;

		try {			
			String enq_id = request.getParameter("enq_id");
			String kenmei = request.getParameter("kenmei");
			String naiyou = request.getParameter("naiyou");
			
			System.out.println(enq_id);
			System.out.println(kenmei);
			System.out.println(naiyou);
			System.out.println("daoに行く手前");
			dao = new MailDao();		

			dao.Enqinsert(enq_id,kenmei,naiyou);
			dao.commit();
			jspName = "messageComplete";
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
		//System.out.println("おっぱい"+jspName);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(jspName);

			dispatcher.forward(request, response);
		
	}

}
