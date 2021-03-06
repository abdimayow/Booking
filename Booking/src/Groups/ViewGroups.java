package Groups;

import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Student;

/**
 * Servlet implementation class ViewGroups
 */
@WebServlet("/ViewGroups")
public class ViewGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   GroupDao gd = new GroupDaoImp();
		   RoomBookingDao rm = new RoomBookingDaoImp();
			
		   HttpSession session = request.getSession();
		   String submit = request.getParameter("submit");
		   
		   switch(submit) {
		   case "view":
		   
		   
		  
		   
		   String category = request.getParameter("select");
		   
		   if(category !=null) {
			   String type = "";
			   if(category.equals("Normal")) {
				   type="normal";
			   }else if(category.equals("Health Science")) {
				   type = "health science";
			   }else {
				   type="engineering";
			   }
			   ArrayList<groups> l= gd.getspecificgroups(type);
			   
			   if(l !=null) {
				   session.setAttribute("viewgroups", l);
				   
				   response.sendRedirect("ListFile.jsp");
			   }
			   else {
				   session.setAttribute("failuregrps", category+"student groups are not available at the moment");
				   response.sendRedirect("home.jsp");
			   }
		   }
		   
		  break;
		   case "View Members":

			   String leader = request.getParameter("leader");
		   if(leader != null) {
			  
			   Student stu = gd.getRegno(leader);
			
				//If the user is a group leader	
					if(stu.getStatus().equals("L")) {

						String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
						session.setAttribute("grpn", grpname);
						if(stu.getGrp().equals("2")) {
							
					     group2 g2 = gd.getgroup2(leader);
					    
					     
					     Student leader1 = gd.getRegno(g2.getLeader());
					     Student snd = gd.getRegno(g2.getRegno2());
					     
					     ArrayList <Student> members = new ArrayList<Student>();
					     members.add(leader1);
					     members.add(snd);
					     session.setAttribute("members", members);
							
						}
						if(stu.getGrp().equals("3")) {
							
						     group3 g3 = gd.getgroup3(leader);
						     	
						     
						     Student leader1 = gd.getRegno(g3.getLeader());
						     Student snd = gd.getRegno(g3.getRegno2());
						     Student trd = gd.getRegno(g3.getRegno3());
						    
						     
						     ArrayList <Student> members = new ArrayList<Student>();
						     members.add(leader1);
						     members.add(snd);
						     members.add(trd);
						     session.setAttribute("members", members);
							
						}
						if(stu.getGrp().equals("4")) {
							
						     group4 g4 = gd.getgroup4(leader);
						     
						     
						     Student leader1 = gd.getRegno(g4.getLeader());
						     Student snd = gd.getRegno(g4.getRegno2());
						     Student trd = gd.getRegno(g4.getRegno3());
						     Student frt = gd.getRegno(g4.getRegno4());
						    
						     
						     ArrayList <Student> members = new ArrayList<Student>();
						     members.add(leader1);
						     members.add(snd);
						     members.add(trd);
						     members.add(frt);
						     session.setAttribute("members", members);
							
						}
						
					}
			   
			   response.sendRedirect("ListFile.jsp");
		   }
		   
	break;
	
	case "search":
		String from = request.getParameter("from");
		LocalDate  sfrom = LocalDate.parse(from);

		
		Group ps = gd.getGroup("YES");
		String fdate = ps.getFrom();
		LocalDate  fromdate = LocalDate.parse(fdate);
		
		LocalDate current = LocalDate.now();
		
		String test="ba";
		

		if(fromdate.compareTo(sfrom) > 0) {
			test = test+"ba";
		}
		if(current.compareTo(fromdate) > 0) {
			test = test+"ba";
		}

		switch(test) {
		case "ba":
			from = from+" 00:00:00:00";
			
			String to = current+" 23:59:59:59";
			System.out.println(from +" "+to);
			
			ArrayList<groups> gs = gd.getroups(from,  to);
			
			   if(gs !=null) {
				   session.setAttribute("viewgroups", gs);
				   
				   response.sendRedirect("ListFile.jsp");
			   }
			   else {
				   session.setAttribute("failuregrps", "student groups are not available at the moment");
				   response.sendRedirect("home.jsp");
			   }
		//groups g = 	(groups)session.getAttribute("groups");
			break;
		default:
			System.out.println("failure");
			session.setAttribute("searchfailure", "Date should be from the beginning of  grouping date to todays date ");
			response.sendRedirect("home.jsp");
			break;
		}
		
		
		
		
		
		

		
	break;
	default:
		response.sendRedirect("home.jsp");
	break;	
	
		  
		   }	
	}

}
