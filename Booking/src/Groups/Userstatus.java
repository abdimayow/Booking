package Groups;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Login.Student;

/**
 * Servlet implementation class Userstatus
 */
@WebServlet("/userstatus")
public class Userstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		GroupDao gd = new GroupDaoImp();
		HttpSession session = request.getSession();
	
		
		String submit = request.getParameter("submit");

		
	
		
		if(submit.equals("confirm")) {

 
			response.sendRedirect("Creategroup.jsp");
			
			
		}else if(submit.equals("confirm members")) {
			String submitype = request.getParameter("members");
			Student leader = gd.getRegno((String)session.getAttribute("regno"));
		    String	regno1 = leader.getRegno();
			
			if(submitype.equals("2members")) {
			String regno2 = request.getParameter("Regno2");	
			String reg2 []= {regno1,regno2}; 
			
			request.setAttribute("reg2", reg2);
			
			request.setAttribute("member", "2members");
			
			RequestDispatcher rd = request.getRequestDispatcher("checkstudent");
			rd.forward(request, response);
			}else if(submitype.equals("3members")) {
				String regno2 = request.getParameter("Regno2");	
				String regno3 = request.getParameter("Regno3");
				String reg3 []= {regno1,regno2,regno3}; 
				
				request.setAttribute("reg3", reg3);
				request.setAttribute("member", "3members");
				RequestDispatcher rd = request.getRequestDispatcher("checkstudent");
				rd.forward(request, response);
				
				}else if(submitype.equals("4members")) {
					String regno2 = request.getParameter("Regno2");
					String regno3 = request.getParameter("Regno3");	
					String regno4 = request.getParameter("Regno4");	
					String reg4 []= {regno1,regno2,regno3,regno4}; 
					
					request.setAttribute("reg4", reg4);
					request.setAttribute("member", "4members");
					RequestDispatcher rd = request.getRequestDispatcher("checkstudent");
					rd.forward(request, response);
				}
		}
		

	}

}
