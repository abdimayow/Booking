package Groups;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StatusL
 */
@WebServlet("/statusL")
public class StatusL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		
	if(request.getAttribute("grpn")!=null) {
		session.setAttribute("grpn",(String)request.getAttribute("grpn"));
		request.removeAttribute("grpn");
	}
	if(request.getAttribute("members")!=null) {
		session.setAttribute("members",(ArrayList)request.getAttribute("members"));
		request.removeAttribute("members");
	}
	if(request.getAttribute("ustatus")!=null) {
		session.setAttribute("ustatus",(String)request.getAttribute("ustatus"));
		request.removeAttribute("ustatus");
	}
	if(request.getAttribute("successgrps")!=null) {
		session.setAttribute("successgrps",(String)request.getAttribute("successgrps"));
		request.removeAttribute("successgrps");
	}
	if(request.getAttribute("failuregrps")!=null) {
		session.setAttribute("failuregrps",(String)request.getAttribute("failuregrps"));
		request.removeAttribute("failuregrps");
	}
	
	response.sendRedirect("booking.jsp");
	
	
	}

}
