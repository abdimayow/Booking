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
 * Servlet implementation class engineering
 */
@WebServlet("/engineering")
public class engineering extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String member = (String)request.getAttribute("member");
	     
	     GroupDao gd = new GroupDaoImp();
			HttpSession session = request.getSession();
			Student leader = gd.getRegno((String)session.getAttribute("regno"));
	     if(member.equals("2members")) {
			  String reg2 [] = (String [])request.getAttribute("reg2");	
			  String faculty = leader.getFaculty();
			  String gender = leader.getGender();
	    	  for(int i=0;i<reg2.length;i++)	{
	    		  
	    		  Student stu = gd.getRegno(reg2[i]);
	    		  if(!(stu.getFaculty().equals(faculty))) {
	    			  int one = gd.removegroup((String)session.getAttribute("regno"));
	    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not from "+faculty);
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    		  if(!(stu.getGender().equals(gender))) {
	    			  int one = gd.removegroup((String)session.getAttribute("regno"));
	    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not "+gender);
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    	  }
	    	 
	    
	    	
	    	  
	    	    request.setAttribute("member","2members");
	  			RequestDispatcher rd = request.getRequestDispatcher("status");
	  			rd.forward(request, response);  
	    	  
	    	  
	    	  
	    	  

		
				}else if(member.equals("3members")) {
					  String reg3 [] = (String [])request.getAttribute("reg3");	
					  String faculty = leader.getFaculty();
					  String gender = leader.getGender();
			    	  for(int i=0;i<reg3.length;i++)	{
			    		  System.out.println(reg3[i]);
			    		  Student stu = gd.getRegno(reg3[i]);
			    		  if(!(stu.getFaculty().equals(faculty))) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not from "+faculty);
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
							
			    		  }
			    		  if(!(stu.getGender().equals(gender))) {
			    			  int one = gd.removegroup((String)session.getAttribute("regno"));
			    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not "+gender);
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
							
			    		  }
			    	  }
			    	  
			    
			    	  request.setAttribute("member","3members");
			  			RequestDispatcher rd = request.getRequestDispatcher("status");
			  			rd.forward(request, response);  
			    	  
					

					
					}else if(member.equals("4members")) {
						  String reg4 [] = (String [])request.getAttribute("reg4");	
						  String faculty = leader.getFaculty();
						  String gender = leader.getGender();
				    	  for(int i=0;i<reg4.length;i++)	{
				    		  System.out.println(reg4[i]);
				    		  Student stu = gd.getRegno(reg4[i]);
				    		  if(!(stu.getFaculty().equals(faculty))) {
				    			  int one = gd.removegroup((String)session.getAttribute("regno"));
				    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not from "+faculty);
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
								
				    		  }
				    		  if(!(stu.getGender().equals(gender))) {
				    			  int one = gd.removegroup((String)session.getAttribute("regno"));
				    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" is not "+gender);
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
								
				    		  }
				    	  }
				    	  
				    	  request.setAttribute("member","4members");
				  			RequestDispatcher rd = request.getRequestDispatcher("status");
				  			rd.forward(request, response);  
				    	 }	
	}

}
