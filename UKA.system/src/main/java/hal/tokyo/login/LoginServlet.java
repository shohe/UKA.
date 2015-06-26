package hal.tokyo.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String MailAddress = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String Login = "login";
		System.out.println(request.getParameter("login"));

		String index = "/WEB-INF/views/index.jsp";

		LoginModule login = new LoginModule();


		HttpSession session = request.getSession(false);
		RequestDispatcher dis = request.getRequestDispatcher(index);
			if(request.getParameter("login").equals(Login)){
				String name = login.Login(MailAddress, Password);
				if(name.equals(MailAddress)){
					//認証成功
					session.setAttribute("Name", name);
					session.setAttribute("Status", "true");
					dis.forward(request, response);
				}else{
					session.setAttribute("Status", "false");
					dis.forward(request, response);
				}
			}else{
				session.removeAttribute("Name");
				session.removeAttribute("Status");
				dis.forward(request, response);
			}

	}

}
