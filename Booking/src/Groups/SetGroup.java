package Groups;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetGroup
 */
@WebServlet("/setgroup")
public class SetGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   GroupDao gd = new GroupDaoImp();
		
	   HttpSession session = request.getSession();
	  
		
		String from = request.getParameter("from");
	   String to = request.getParameter("to");
	   String submitype = request.getParameter("submit");
	   String status = "YES";
	  Group g = new Group();
	  if(submitype.equals("confirmDate")) {
		  
		  
		  g.setFrom(from);
		  g.setTo(to);
		  
		  g.setStatus(status);
		  
		if( gd.checkGroup("YES")== false) {
			int one = gd.insertGroup(g);
			session.setAttribute("gstatus","YES");
			System.out.println(one);
			
			
		}
		else {
			gd.closeGroup();
			int one = gd.insertGroup(g);
			System.out.println(one);
			session.setAttribute("gstatus","YES");
		}
		 
		
		 response.sendRedirect("home.jsp");
	  }
	  if(submitype.equals("Confirm")) {
		
		  
		if( gd.checkGroup("YES")== true) {
			
			gd.closeGroup();
			session.setAttribute("gstatus","NO");
		}
		else {
			session.setAttribute("disabled","Group is already disabled");
		}
		 response.sendRedirect("home.jsp");
	  } 
	  
	  
	}

}
