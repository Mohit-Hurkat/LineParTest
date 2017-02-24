
  import java.io.IOException;
    import java.security.SecureRandom;

    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;
import com.test.helper.SendEmailUsingGMailSMTP;



    public class forgetPass extends HttpServlet {
    	private static final long serialVersionUID = 1L;


    	protected void doGet(HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub

    	}

    	public static String generateCode() {
    		String password = "";
    		SecureRandom random = new SecureRandom();
    		for (int i = 0; i < 8; i++) {
    			password = password + (char) (random.nextInt(26) + 97);
    		}
    		return password;
    	}

    	protected void doPost(HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		if (request.getSession().getAttribute("error") != null) {
    			request.getSession().removeAttribute("error");
    		}
    		if (request.getSession().getAttribute("messages") != null) {
    			request.getSession().removeAttribute("messages");
    		}
//    		PasswordDAO pass = new PasswordDAO();
    		String mailId;
    		mailId = request.getParameter("email");
//    		EmployeeDAO empDao = EmployeeDAO.getInstance();
    		StudentDao sDao= new StudentDaoImpl();
    		try {
    			if (sDao.search(mailId)!= null) {
    				String code = forgetPass.generateCode();
    				if(SendEmailUsingGMailSMTP.sendMail(mailId,code));
    				{request.getSession().setAttribute("messages",
    						"check your mail for further process");
    				response.sendRedirect("./reset.jsp");
    				}
    			} else {
    				request.getSession().setAttribute("messages",
    						"invalid employee id");
    				response.sendRedirect("./ForgetPassword/forgetPassword.jsp");
    			}
    		} catch (Exception e) {
    			request.getSession()
    					.setAttribute("messages", "invalid employee id");
    			response.sendRedirect("../ForgetPassword/forgotPassword.jsp");
    		}
    	}
    }


