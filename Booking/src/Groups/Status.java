package Groups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Student;

/**
 * Servlet implementation class Status
 */
@WebServlet("/status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String member = (String)request.getAttribute("member");
	    request.removeAttribute("member");
	     System.out.println(member);
	     GroupDao gd = new GroupDaoImp();
			HttpSession session = request.getSession();
	
	     if(member.equals("2members")) {
			  String reg2 [] = (String [])request.getAttribute("reg2");	
			  request.removeAttribute("reg2");
			  groups group = gd.getgroup((String)session.getAttribute("regno"));
			  group2 group2 = new group2(); 
			  
	    	  for(int i=0;i<reg2.length;i++)	{
	    		  String status = gd.getstudentstatus(reg2[i]);
	    		  Student stu = gd.getRegno(reg2[i]);
	    		 

	    		  if(status.equals("P")){
	    			int one = gd.removegroup((String)session.getAttribute("regno"));
                
	    			String grpname = gd.getgrpname(stu.getRegno(),stu.getGrp(),stu.getReg());
	    			System.out.println("Removed group with status "+one);
	    			System.out.println("Regno is "+stu.getRegno());
	    			System.out.println("Grp is "+stu.getGrp());
	    			System.out.println("Regn is "+stu.getReg());
	    			System.out.println("Group name is "+grpname);
	    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has been requested by "+grpname+ " Convince them to decline the group ");
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    		  if(status.equals("C")){
	    			int one = gd.removegroup((String)session.getAttribute("regno"));

	    			System.out.println("Removed group with status "+one);
	    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
	    			System.out.println("Regno is "+stu.getRegno());
	    			System.out.println("Grp is "+stu.getGrp());
	    			System.out.println("Regn is "+stu.getReg());
	    			System.out.println("Group name is "+grpname);
	    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has joined "+grpname+ " Convince them to exit the group ");
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    		  if(status.equals("L")){
	    			int one = gd.removegroup((String)session.getAttribute("regno"));
                   
                   
                  
	    			System.out.println("Removed group with status "+one);
	    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
	    			System.out.println("Regno is "+stu.getRegno());
	    			System.out.println("Grp is "+stu.getGrp());
	    			System.out.println("Regn is "+stu.getReg());
	    			System.out.println("Group name is "+grpname);
	    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has created "+grpname+ " Convince them to delete the group ");
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    		  if(status.equals("D") || status.equals("U")){
	    			int one = gd.removegroup((String)session.getAttribute("regno"));
                   
                   
                  
	    			System.out.println("Removed group with status "+one);
	    			
	    			System.out.println("Regno is "+stu.getRegno());
	    			System.out.println("Grp is "+stu.getGrp());
	    			System.out.println("Regn is "+stu.getReg());
	    			
	    			request.setAttribute("failuregrps", " Inform Student "+stu.getRegno()+" to Confirm exiting the group they formed");
					RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
					rd.forward(request, response);
				
	    		  }
	    		  if(status.equals("S")) {
		    		  if(i==0) {
		    			  group2.setGroupid(group.getGroupid());
		    			  group2.setLeader(stu.getRegno());

		    		  }else if(i==1) {
		    			  group2.setRegno2(stu.getRegno());
		    	
		    		  }
	    		  }
	    		  

	    		  

	    	  }
	    	  
	    	  groups check = gd.getgroup((String)session.getAttribute("regno"));
	    	  
	    	  
	    	  if(check.getGroupname() != null) {
	    		  
	    		  for(int i=0;i<reg2.length;i++) {
		    		  if(i==0) {
	
		    			  int one = gd.grp2(reg2[i]);
		    			  int two = gd.reg1(reg2[i]);
		    			  int three = gd.confirmedLeader(reg2[i]);
		    			  
		    			  System.out.println("registration number "+reg2[i]+" has status grp2="+one +" reg1="+two+" confirmleader="+three);
		    		  }else if(i==1) {
		    			 
		    			  int one = gd.grp2(reg2[i]); 
		    			  int two = gd.reg2(reg2[i]);
		    			  int three = gd.pendingStudent(reg2[i]);
		    			  System.out.println("registration number "+reg2[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
		    		  }
	    		  }
	    		  
	    		  
	    		  
		    	  int last  = gd.insertgroup2(group2);
		    	  System.out.println("inserted group2 with status="+last);

				     Student leader = gd.getRegno(group2.getLeader());
				     Student snd = gd.getRegno(group2.getRegno2());
				     
				     ArrayList <Student> members = new ArrayList<Student>();
				     members.add(leader);
				     members.add(snd);
				     request.setAttribute("members", members);
		    	  
			    	String grpname = gd.getgrpname(leader.getRegno(), leader.getGrp(), leader.getReg());
			    	request.setAttribute("grpn",grpname);
			    	request.setAttribute("ustatus","L");
		    	    request.setAttribute("successgrps","Successfully created group "+group.getGroupname());
		  			RequestDispatcher rd = request.getRequestDispatcher("statusL");
		  			rd.forward(request, response);
	    	  }

	  			  
		
				}else if(member.equals("3members")) {
					  String reg3 [] = (String [])request.getAttribute("reg3");	
					  request.removeAttribute("reg3");	
					  groups group = gd.getgroup((String)session.getAttribute("regno"));
					  group3 group3 = new group3(); 
					  
			    	  for(int i=0;i<reg3.length;i++)	{
			    		  String status = gd.getstudentstatus(reg3[i]);
			    		  Student stu = gd.getRegno(reg3[i]);
			    		 

			    		  if(status.equals("P")){
			    			int one = gd.removegroup((String)session.getAttribute("regno"));
		                
			    			String grpname = gd.getgrpname(stu.getRegno(),stu.getGrp(),stu.getReg());
			    			System.out.println("Removed group with status "+one);
			    			System.out.println("Regno is "+stu.getRegno());
			    			System.out.println("Grp is "+stu.getGrp());
			    			System.out.println("Regn is "+stu.getReg());
			    			System.out.println("Group name is "+grpname);
			    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has been requested by "+grpname+ " Convince them to decline the group ");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
						    return;
						    
			    		  }
			    		  if(status.equals("C")){
			    			int one = gd.removegroup((String)session.getAttribute("regno"));

			    			System.out.println("Removed group with status "+one);
			    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
			    			System.out.println("Regno is "+stu.getRegno());
			    			System.out.println("Grp is "+stu.getGrp());
			    			System.out.println("Regn is "+stu.getReg());
			    			System.out.println("Group name is "+grpname);
			    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has joined "+grpname+ " Convince them to exit the group ");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
						    return;
						  
			    		  }
			    		  if(status.equals("L")){
			    			int one = gd.removegroup((String)session.getAttribute("regno"));
		                   
		                   
		                  
			    			System.out.println("Removed group with status "+one);
			    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
			    			System.out.println("Regno is "+stu.getRegno());
			    			System.out.println("Grp is "+stu.getGrp());
			    			System.out.println("Regn is "+stu.getReg());
			    			System.out.println("Group name is "+grpname);
			    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has created "+grpname+ " Convince them to delete the group ");
							RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
							rd.forward(request, response);
						    return;
						    
			    		  }
			    		  if(status.equals("S")) {
				    		  if(i==0) {
				    			  group3.setGroupid(group.getGroupid());
				    			  group3.setLeader(stu.getRegno());

				    		  }else if(i==1) {
				    			  group3.setRegno2(stu.getRegno());

				    		  }else if(i==2) {
				    			  group3.setRegno3(stu.getRegno());
				    		
				    		  }
			    		  }
			    		  

			    		  

			    	  }
			    	  
			    	  groups check = gd.getgroup((String)session.getAttribute("regno"));
			    	  
			    	  
			    	  if(check.getGroupname() != null) {
			    		  for(int i=0;i<reg3.length;i++) {
				    		  if(i==0) {
				    			
				    			  
				    			  int one = gd.grp3(reg3[i]);
				    			  int two = gd.reg1(reg3[i]);
				    			  int three = gd.confirmedLeader(reg3[i]);
				    			  
				    			  System.out.println("registration number "+reg3[i]+" has status grp2="+one +" reg1="+two+" confirmleader="+three);
				    		  }else if(i==1) {
				    			
				    			  int one = gd.grp3(reg3[i]); 
				    			  int two = gd.reg2(reg3[i]);
				    			  int three = gd.pendingStudent(reg3[i]);
				    			  System.out.println("registration number "+reg3[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
				    		  }else if(i==2) {
				    			 
				    			  int one = gd.grp3(reg3[i]); 
				    			  int two = gd.reg3(reg3[i]);
				    			  int three = gd.pendingStudent(reg3[i]);
				    			  System.out.println("registration number "+reg3[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
				    		  }
			    		  }
				    	  int last  = gd.insertgroup3(group3);
				    	  System.out.println("inserted group3 with status="+last);
				 
				    	  
						     Student leader = gd.getRegno(group3.getLeader());
						     Student snd = gd.getRegno(group3.getRegno2());
						     Student trd = gd.getRegno(group3.getRegno3());
						    
						     
						     ArrayList <Student> members = new ArrayList<Student>();
						     members.add(leader);
						     members.add(snd);
						     members.add(trd);
						     request.setAttribute("members", members);
						     
					    	String grpname = gd.getgrpname(leader.getRegno(), leader.getGrp(), leader.getReg());
					    	request.setAttribute("grpn",grpname);
					    	request.setAttribute("ustatus","L");
				    	    request.setAttribute("successgrps","Successfully created group "+group.getGroupname());
				  			RequestDispatcher rd = request.getRequestDispatcher("statusL");
				  			rd.forward(request, response);
			    	  }
			    	  
			  			
					}else if(member.equals("4members")) {
						  String reg4 [] = (String [])request.getAttribute("reg4");	
						  request.removeAttribute("reg4");	
						  groups group = gd.getgroup((String)session.getAttribute("regno"));
						  group4 group4 = new group4(); 
						  
				    	  for(int i=0;i<reg4.length;i++)	{
				    		  String status = gd.getstudentstatus(reg4[i]);
				    		  Student stu = gd.getRegno(reg4[i]);
				    		 

				    		  if(status.equals("P")){
				    			int one = gd.removegroup((String)session.getAttribute("regno"));
			                
				    			String grpname = gd.getgrpname(stu.getRegno(),stu.getGrp(),stu.getReg());
				    			System.out.println("Removed group with status "+one);
				    			System.out.println("Regno is "+stu.getRegno());
				    			System.out.println("Grp is "+stu.getGrp());
				    			System.out.println("Regn is "+stu.getReg());
				    			System.out.println("Group name is "+grpname);
				    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has been requested by "+grpname+ " Convince them to decline the group ");
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
							
				    		  }
				    		  if(status.equals("C")){
				    			int one = gd.removegroup((String)session.getAttribute("regno"));

				    			System.out.println("Removed group with status "+one);
				    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
				    			System.out.println("Regno is "+stu.getRegno());
				    			System.out.println("Grp is "+stu.getGrp());
				    			System.out.println("Regn is "+stu.getReg());
				    			System.out.println("Group name is "+grpname);
				    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has joined "+grpname+ " Convince them to exit the group ");
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
							
				    		  }
				    		  if(status.equals("L")){
				    			int one = gd.removegroup((String)session.getAttribute("regno"));
			                   
			                   
			                  
				    			System.out.println("Removed group with status "+one);
				    			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
				    			System.out.println("Regno is "+stu.getRegno());
				    			System.out.println("Grp is "+stu.getGrp());
				    			System.out.println("Regn is "+stu.getReg());
				    			System.out.println("Group name is "+grpname);
				    			request.setAttribute("failuregrps", "Student "+stu.getRegno()+" has created "+grpname+ " Convince them to delete the group ");
								RequestDispatcher rd = request.getRequestDispatcher("Creategroup.jsp");
								rd.forward(request, response);
							
				    		  }
				    		  if(status.equals("S")) {
					    		  if(i==0) {
					    			  group4.setGroupid(group.getGroupid());
					    			  group4.setLeader(stu.getRegno());

					    		  }else if(i==1) {
					    			  group4.setRegno2(stu.getRegno());

					    		  }else if(i==2) {
					    			  group4.setRegno3(stu.getRegno());
	
					    		  }else if(i==3) {
					    			  group4.setRegno4(stu.getRegno());

					    		  }
				    		  }
				    		  

				    		  

				    	  }
				    	  
				    	  groups check = gd.getgroup((String)session.getAttribute("regno"));
				    	  
				    	  
				    	  if(check.getGroupname() != null) {
				    		  
				    		  for(int i=0;i<reg4.length;i++) {
					    		  if(i==0) {
					    	
					    			  int one = gd.grp4(reg4[i]);
					    			  int two = gd.reg1(reg4[i]);
					    			  int three = gd.confirmedLeader(reg4[i]);
					    			  
					    			  System.out.println("registration number "+reg4[i]+" has status grp2="+one +" reg1="+two+" confirmleader="+three);
					    		  }else if(i==1) {
					    			  
					    			  int one = gd.grp4(reg4[i]); 
					    			  int two = gd.reg2(reg4[i]);
					    			  int three = gd.pendingStudent(reg4[i]);
					    			  System.out.println("registration number "+reg4[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
					    		  }else if(i==2) {
					    			 
					    			  int one = gd.grp4(reg4[i]); 
					    			  int two = gd.reg3(reg4[i]);
					    			  int three = gd.pendingStudent(reg4[i]);
					    			  System.out.println("registration number "+reg4[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
					    		  }else if(i==3) {
					    			 
					    			  int one = gd.grp4(reg4[i]); 
					    			  int two = gd.reg4(reg4[i]);
					    			  int three = gd.pendingStudent(reg4[i]);
					    			  System.out.println("registration number "+reg4[i]+" has status grp2="+one +" reg2="+two+" pendingstudent="+three);
					    		  }
				    		  }
				    		  
					    	  int last  = gd.insertgroup4(group4);
					    	  System.out.println("inserted group4 with status="+last);
					    	  
					    	  

					    	  
							     Student leader = gd.getRegno(group4.getLeader());
							     Student snd = gd.getRegno(group4.getRegno2());
							     Student trd = gd.getRegno(group4.getRegno3());
							     Student frt = gd.getRegno(group4.getRegno4());
							    
							     
							     ArrayList <Student> members = new ArrayList<Student>();
							     members.add(leader);
							     members.add(snd);
							     members.add(trd);
							     members.add(frt);
							     request.setAttribute("members", members);

							     
						    	String grpname = gd.getgrpname(leader.getRegno(), leader.getGrp(), leader.getReg());
						    	request.setAttribute("grpn",grpname);  
						    	request.setAttribute("ustatus","L"); 
					    	    request.setAttribute("successgrps","Successfully created group "+group.getGroupname());
					  			RequestDispatcher rd = request.getRequestDispatcher("statusL");
					  			rd.forward(request, response);
				    	  }
	}

}
}
