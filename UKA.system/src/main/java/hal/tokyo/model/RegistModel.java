package hal.tokyo.model;

import hal.tokyo.dao.UsersDao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistModel
 */
@WebServlet("/RegistModel")
public class RegistModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistModel() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String jspName = "/WEB-INF/views/regist.jsp";

		UsersDao ud = new UsersDao();

		String mailaddress;
		String password;
		String name;
		String profileComment;
		int department_Id;
		String image;
		int status;

		int result;

		try{

			mailaddress = request.getParameter("mailaddress");
			password = request.getParameter("password");
			name = request.getParameter("name");
			profileComment = request.getParameter("profileComment");
			department_Id = 0;
			image = "ないよ";
			status = 0;

			System.out.println(mailaddress+password+name+profileComment+department_Id+image+status);

			result = ud.insert(mailaddress, password, name, profileComment, department_Id, image, status);

			if(result > 0){

				ud.commit();

			}else{

				ud.rollback();

			}

			RequestDispatcher dispatcher =
					request.getRequestDispatcher(jspName);

				dispatcher.forward(request, response);


		} catch (SQLException e) {

			try {

				ud.rollback();

			} catch (SQLException e1) {


				e1.printStackTrace();

			}

			e.printStackTrace();

		}


	}

}
