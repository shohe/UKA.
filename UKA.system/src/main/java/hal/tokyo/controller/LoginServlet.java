package hal.tokyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MailAddress = request.getParameter("Email-Form");
		String Password = request.getParameter("Password-Form");
		String dis = "/webapp/WEB-INF/views/headear_login.jsp";

		LoginModule login = new LoginModule();
		String result = login.Login(MailAddress, Password);

		HttpSession session = null;
		if(MailAddress == result){
			//認証成功
			session = request.getSession(true);
			session.setAttribute("MailAddress", MailAddress);
		}else{
			response.sendRedirect(dis);
		}
	}

}
