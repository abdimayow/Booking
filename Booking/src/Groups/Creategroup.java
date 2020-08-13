package Groups;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Creategroup
 */
@WebServlet("/Creategroup")
public class Creategroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   GroupDao gd = new GroupDaoImp();
		  
		   HttpSession session = request.getSession();
		   
		   String submit = request.getParameter("submit");
           
		   
		   if(submit.equals("creategroup")) {

			   
			   String gname = request.getParameter("groupname");
			   String no = request.getParameter("NoOfMembers");
			   String leader = (String)session.getAttribute("regno");

			   groups g = new groups();			   
			   g.setGroupname(gname);
               g.setNoOfMembers(no);
               g.setLeader(leader);

            	 if(no.equals("2")) {
            		 String regno1 = (String)session.getAttribute("regno");
            		 String check = gd.getLeader( regno1); 
            		 String grpname = gd.checkgrpname(gname);
                     if((check == null) & (grpname == null)) {
		                     int one = gd.insertgroups(g);
		                     System.out.println(one);
		                     request.setAttribute("leader", leader);
		             		 RequestDispatcher dis = request.getRequestDispatcher("2members.jsp");
		            		 dis.forward(request, response);
                     }else if(check != null){
                            request.setAttribute("grpfailure2", "Unable to create group You are a member of group "+check); 
                		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
              		        dis.forward(request, response);
                     }else if(grpname != null){
                         request.setAttribute("grpfailure2", "Unable to create group. Group "+grpname+" already exists"); 
             		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
           		        dis.forward(request, response);
                  }
            	  } else if(no.equals("3")) {
             		 String regno1 = (String)session.getAttribute("regno");
             		 String check = gd.getLeader( regno1); 
             		String grpname = gd.checkgrpname(gname);
                     if((check == null) & (grpname == null)) {
	                     int one = gd.insertgroups(g);
	                     System.out.println(one);
	                     request.setAttribute("leader", leader);
	             		 RequestDispatcher dis = request.getRequestDispatcher("3members.jsp");
	            		 dis.forward(request, response);
                 }else if(check != null){
                        request.setAttribute("grpfailure2", "Unable to create group You are a member of group "+check); 
            		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
          		        dis.forward(request, response);
                 }else if(grpname != null){
                     request.setAttribute("grpfailure2", "Unable to create group. Group "+grpname+" already exists"); 
         		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
       		        dis.forward(request, response);
              }
             	 }else if(no.equals("4")) {
            		 String regno1 = (String)session.getAttribute("regno");
            		 String check = gd.getLeader( regno1);
            		 String grpname = gd.checkgrpname(gname);
                     if((check == null) & (grpname == null)) {
	                     int one = gd.insertgroups(g);
	                     System.out.println(one);
	                     request.setAttribute("leader", leader);
	             		 RequestDispatcher dis = request.getRequestDispatcher("4members.jsp");
	            		 dis.forward(request, response);
                 }else if(check != null){
                        request.setAttribute("grpfailure2", "Unable to create group You are a member of group "+check); 
            		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
          		        dis.forward(request, response);
                 }else if(grpname != null){
                     request.setAttribute("grpfailure2", "Unable to create group. Group "+grpname+" already exists"); 
         		    RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
       		        dis.forward(request, response);
              }
             	 }
             	 else {
 
                      request.setAttribute("failuregrps", "Unable to create group Enter the right group number!"); 
             		  RequestDispatcher dis = request.getRequestDispatcher("Creategroup.jsp");
           		      dis.forward(request, response);
             	 }
            	 
            	      
               
              
            

 
               
               
               
               
             
               
			   
		   }
		   
	}

}
