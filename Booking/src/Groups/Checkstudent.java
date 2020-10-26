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
 * Servlet implementation class Checkstudent
 */
@WebServlet("/checkstudent")
public class Checkstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String member = (String)request.getAttribute("member");
     
     GroupDao gd = new GroupDaoImp();
		HttpSession session = request.getSession();
     
     if(member.equals("2members")) {
		  String reg2 [] = (String [])request.getAttribute("reg2");	
		  
    	  for(int i=0;i<reg2.length;i++)	{
    		  System.out.println(reg2[i]);
    		  Student stu = gd.getRegno(reg2[i]);
    		  
    		  if(stu.getName() == null) {
    			  int one = gd.removegroup((String)session.getAttribute("regno"));
    			request.setAttribute("failuregrps", "Regno "+reg2[i]+" does not exist");
				RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
				rd.forward(request, response);
    		  }
    		  if(i>0) {
    			  Student stubefore = gd.getRegno(reg2[i-1]);
	    		  if(stu.getName().equals(stubefore.getName())) {
	    			  int one = gd.removegroup((String)session.getAttribute("regno"));
	    			request.setAttribute("failuregrps", "A student cannot appear twice in a group ");
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
	    		  }

    	  }
    	  }
    	  
    	  Student leader = gd.getRegno((String)session.getAttribute("regno"));
    
    	  String faculty = leader.getFaculty();
    	  
    	  if(faculty.equals("SCIENCE")) {
  			RequestDispatcher rd = request.getRequestDispatcher("science");
  			rd.forward(request, response);
    	  }else if(faculty.equals("ENGINEERING")) {
  			RequestDispatcher rd = request.getRequestDispatcher("engineering");
  			rd.forward(request, response);  
    	  }else if(faculty.equals("HEALTH SCIENCE")) {
  			RequestDispatcher rd = request.getRequestDispatcher("hscience");
  			rd.forward(request, response);  
    	  }
    	  
    	  
    	  

	
			}else if(member.equals("3members")) {
				  String reg3 [] = (String [])request.getAttribute("reg3");	
				  
		    	  for(int i=0;i<reg3.length;i++)	{
		    		  System.out.println(reg3[i]);
		    		  Student stu = gd.getRegno(reg3[i]);
		    		 
		    		  if(stu.getName() == null) {
		    			  int one = gd.removegroup((String)session.getAttribute("regno"));
		    			request.setAttribute("failuregrps", "Regno "+reg3[i]+" does not exist");
						RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
						rd.forward(request, response);
		    		  }

		    		  if(i>0) {
		    			  Student stubefore = gd.getRegno(reg3[i-1]);
		    			  Student leader = gd.getRegno((String)session.getAttribute("regno"));
			    		  if(stu.getName().equals(stubefore.getName())) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "A student cannot appear twice in a group ");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
			    		  }
			    		  if(stu.getName().equals(leader.getName())) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "A student cannot appear twice in a group ");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
			    		  }

		    	  }
		    	  }
		    	  
		    	  Student leader = gd.getRegno((String)session.getAttribute("regno"));
		    	  String faculty = leader.getFaculty();
		    	  
		    	  if(faculty.equals("SCIENCE")) {
		  			RequestDispatcher rd = request.getRequestDispatcher("science");
		  			rd.forward(request, response);
		    	  }else if(faculty.equals("ENGINEERING")) {
		  			RequestDispatcher rd = request.getRequestDispatcher("engineering");
		  			rd.forward(request, response);  
		    	  }else if(faculty.equals("HEALTH SCIENCE")) {
		    		  System.out.println("It has proceeded to hsceince servlet");
		  			RequestDispatcher rd = request.getRequestDispatcher("hscience");
		  			rd.forward(request, response);  
		  			
		    	  }
				

				
				}else if(member.equals("4members")) {
					  String reg4 [] = (String [])request.getAttribute("reg4");	
					  
			    	  for(int i=0;i<reg4.length;i++)	{
			    		  System.out.println(reg4[i]);
			    		  Student stu = gd.getRegno(reg4[i]);
			    		  Student lead = gd.getRegno((String)session.getAttribute("regno"));
			    		  if(stu.getName() == null) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "Regno "+reg4[i]+" does not exist");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
			    		  }
                          if(i==1) {
    			    		  if(stu.getName().equals(lead.getName())) {
    			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
    			    			request.setAttribute("failuregrps", "You are already a member");
    							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
    							rd.forward(request, response);
    			    		  }
                          }
			    		  if(i>0) {
			    			  Student stubefore = gd.getRegno(reg4[i-1]);
			    			
				    		  if(stu.getName().equals(stubefore.getName())) {
				    			  int one = gd.removegroup((String)session.getAttribute("regno"));
				    			request.setAttribute("failuregrps", "A student cannot appear twice in a group ");
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
				    		  }
				    		  if(stu.getName().equals(lead.getName())) {
				    			  int one = gd.removegroup((String)session.getAttribute("regno"));
				    			request.setAttribute("failuregrps", "A student cannot appear twice in a group ");
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
				    		  }

			    	  }
		    		  if(i==3) {
		    			  Student stu2nd = gd.getRegno(reg4[i-2]);
			    		  if(stu.getName().equals(stu2nd.getName())) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "A student cannot twice appear in a group");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
			    		  }	  
		    			  
		    		  }


				}
			    	  
			    	  
			    	  Student leader = gd.getRegno((String)session.getAttribute("regno"));
			    	  String faculty = leader.getFaculty();
			    	  
			    	  if(faculty.equals("SCIENCE")) {
			  			RequestDispatcher rd = request.getRequestDispatcher("science");
			  			rd.forward(request, response);
			    	  }else if(faculty.equals("ENGINEERING")) {
			  			RequestDispatcher rd = request.getRequestDispatcher("engineering");
			  			rd.forward(request, response);  
			    	  }else if(faculty.equals("HEALTH SCIENCE")) {
			  			RequestDispatcher rd = request.getRequestDispatcher("hscience");
			  			rd.forward(request, response);  
			    	  }	 	  
	}

	}
}

