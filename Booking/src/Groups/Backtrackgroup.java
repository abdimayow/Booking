package Groups;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Student;

/**
 * Servlet implementation class Backtrackgroup
 */
@WebServlet("/backtrackgroup")
public class Backtrackgroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupDao gd = new GroupDaoImp();
		 HttpSession session = request.getSession();
		 
		 String submit = request.getParameter("submit");
		 
		   String leader = (String)session.getAttribute("regno");
		     
			  
		   int one = gd.removegroup(leader);
		   System.out.println("Removed group with status"+one);
		   
          switch(submit)	{
          
          case "ok":
        	  response.sendRedirect("Creategroup.jsp");     
        	  break;

          default : 
        	  response.sendRedirect("booking.jsp");
             break;
          
          }

		 

		
		
		
		
		
		
		
		
	}


}
