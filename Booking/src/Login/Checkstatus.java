package Login;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Blocks.InsertDaoImp;
import Blocks.insertDao;
import Blocks.History;
import Groups.Group;
import Groups.GroupDao;
import Groups.GroupDaoImp;
import Groups.group2;
import Groups.group3;
import Groups.group4;
import Groups.groups;
import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;



/**
 * Servlet implementation class Checkstatus
 */
@WebServlet("/checkstatus")
public class Checkstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    GroupDao gd = new GroupDaoImp();
    

    RoomBookingDao rm = new RoomBookingDaoImp();
    HttpSession session = request.getSession();
  String user = (String)session.getAttribute("user");
		
		
		
	String gstatus=gd.checkGroupstates();

	String bstatus = rm.checkBookStatus();
	
	String gto  = gd.getToDate();
	
	String bto  = rm.getToDate();
	
	if(gstatus.equals("YES")) {
		

	
		LocalDate current = LocalDate.now();
		

		
		
		
		
		LocalDate  todate = LocalDate.parse(gto);
		//Compare current date with grouping deadline
		if(todate.compareTo(current) > 0) {
			gstatus = "YES";
			Group ps = gd.getGroup("YES");
			session.setAttribute("group", ps);
			ArrayList<groups> gs= gd.getroup();
			if(gs != null) {
				session.setAttribute("groups", gs);	
			}
			
			String reg = (String)session.getAttribute("regno");
			
			//If the user is a student
			if(reg !=null) {
				Student stu = gd.getRegno(reg);
				
			

				    	
				
				 
				
				session.setAttribute("ustatus", stu.getStatus());
				//If the user is a group leader	
					if(stu.getStatus().equals("L")) {

						String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
						session.setAttribute("grpn", grpname);
						if(stu.getGrp().equals("2")) {
							
					     group2 g2 = gd.getgroup2(reg);
					    
					     
					     Student leader = gd.getRegno(g2.getLeader());
					     Student snd = gd.getRegno(g2.getRegno2());
					     
					    String status = snd.getStatus();
					    if(status.equals("P")) {
					    	session.setAttribute("incomplete", "Members should confirm membership before deadline!");
					    }
					     
					     ArrayList <Student> members = new ArrayList<Student>();
					     members.add(leader);
					     members.add(snd);
					     session.setAttribute("members", members);
							
						}
						if(stu.getGrp().equals("3")) {
							
						     group3 g3 = gd.getgroup3(reg);
						     	
						     
						     Student leader = gd.getRegno(g3.getLeader());
						     Student snd = gd.getRegno(g3.getRegno2());
						     Student trd = gd.getRegno(g3.getRegno3());
						    
							    if(snd.getStatus().equals("P") || trd.getStatus().equals("P")) {
							    	session.setAttribute("incomplete", "Members should confirm membership before deadline!");
							    }
						     
						     
						     ArrayList <Student> members = new ArrayList<Student>();
						     members.add(leader);
						     members.add(snd);
						     members.add(trd);
						     session.setAttribute("members", members);
							
						}
						if(stu.getGrp().equals("4")) {
							
						     group4 g4 = gd.getgroup4(reg);
						     
						     
						     Student leader = gd.getRegno(g4.getLeader());
						     Student snd = gd.getRegno(g4.getRegno2());
						     Student trd = gd.getRegno(g4.getRegno3());
						     Student frt = gd.getRegno(g4.getRegno4());
						    
							    if(snd.getStatus().equals("P") || trd.getStatus().equals("P") || frt.getStatus().equals("P")){
							    	session.setAttribute("incomplete", "Members should confirm membership before deadline!");
							    }
						     
						     ArrayList <Student> members = new ArrayList<Student>();
						     members.add(leader);
						     members.add(snd);
						     members.add(trd);
						     members.add(frt);
						     session.setAttribute("members", members);
							
						}
						
					}
					//If the user is in a group	
					if(stu.getStatus().equals("C")) {
						String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
						session.setAttribute("grpn", grpname);
						if(stu.getGrp().equals("2")) {

					     group2 g2 = gd.student2(reg);
					     
					     

					     
					     Student leader = gd.getRegno(g2.getLeader());
					     Student snd = gd.getRegno(g2.getRegno2());
					     
					     ArrayList <Student> members = new ArrayList<Student>();
					     members.add(leader);
					     members.add(snd);
					     session.setAttribute("members", members);
					     
						}
						if(stu.getGrp().equals("3")) {
							group3 g3 = new group3();
						    
							
						    if(stu.getReg().equals("1")) {
								  g3 = gd.group3student2(reg);
						    }
						    if(stu.getReg().equals("2")) {
								 g3 = gd.group3student3(reg);
						    }
						    
						    if(g3.getLeader() != null) {
							     
							    

							     
							     
							     Student leader = gd.getRegno(g3.getLeader());
							     Student snd = gd.getRegno(g3.getRegno2());
							     Student trd = gd.getRegno(g3.getRegno3());
							     
							     ArrayList <Student> members = new ArrayList<Student>();
							     members.add(leader);
							     members.add(snd);
							     members.add(trd);
							     session.setAttribute("members", members); 
						    }

		   
							
						}
						if(stu.getGrp().equals("4")) {
							group4 g4 = new group4();
						    
							
						    if(stu.getReg().equals("1")) {
								  g4 = gd.group4student2(reg);
						    }
						    if(stu.getReg().equals("2")) {
								 g4 = gd.group4student3(reg);
						    }
						    if(stu.getReg().equals("3")) {
								 g4 = gd.group4student4(reg);
						    }
						    
						    if(g4.getLeader() != null) {
							     
							    

							     
							     
							     Student leader = gd.getRegno(g4.getLeader());
							     Student snd = gd.getRegno(g4.getRegno2());
							     Student trd = gd.getRegno(g4.getRegno3());
							     Student frt = gd.getRegno(g4.getRegno4());
							     
							     ArrayList <Student> members = new ArrayList<Student>();
							     members.add(leader);
							     members.add(snd);
							     members.add(trd);
							     members.add(frt);
							     session.setAttribute("members", members); 
						    }					

							
						}
						
					}
					//If the user has been requested by a group	
					if(stu.getStatus().equals("P")) {
						
						
						String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
						
						if(stu.getGrp().equals("2")) {

					     group2 g2 = gd.student2(reg);
					   
					     

					     
					     Student leader = gd.getRegno(g2.getLeader());
					    
					     session.setAttribute("grpnotification", leader.getName()+" has requested you to join group "+ grpname +"!");

			
					     
						}
						if(stu.getGrp().equals("3")) {
							group3 g3 = new group3();
						    
							
						    if(stu.getReg().equals("1")) {
								  g3 = gd.group3student2(reg);
						    }
						    if(stu.getReg().equals("2")) {
								 g3 = gd.group3student3(reg);
						    }
						    
						    if(g3.getLeader() != null) {
							    
							    
								
								
							     
							     
							     Student leader = gd.getRegno(g3.getLeader());
							     session.setAttribute("grpnotification", leader.getName()+" has requested you to join group "+ grpname +"!");
						    }

		   
							
						}
						if(stu.getGrp().equals("4")) {
							group4 g4 = new group4();
						    
							
						    if(stu.getReg().equals("1")) {
								  g4 = gd.group4student2(reg);
						    }
						    if(stu.getReg().equals("2")) {
								 g4 = gd.group4student3(reg);
						    }
						    if(stu.getReg().equals("3")) {
								 g4 = gd.group4student4(reg);
						    }
						    
						    if(g4.getLeader() != null) {
							     
							    
			
							     
							     
							     Student leader = gd.getRegno(g4.getLeader());
							     session.setAttribute("grpnotification", leader.getName()+" has requested you to join group "+ grpname +"!");
						    }					

							
						}
						
					}
					//If the user is a group leader with a declined group	
					if(stu.getStatus().equals("U")) {
						groups gr = gd.getgroup(reg);
						String message =gr.getMessage(); 
				        System.out.println("This is the message: "+ message);
						session.setAttribute("grpstatus",message);
						
					}
					//If the users group has been declined	
					if(stu.getStatus().equals("D")) {
						
						
						session.setAttribute("grpdeclined","Group could not be formed. A member exited the group");
						
					}
					
			    
			}

			
 
		}
		else {
			gd.closeGroup();
			gd.closeallgroups();
			gstatus = "NO";	
		}
		
	}
	else {
      gstatus = "NO";

	}
	
	if(bstatus.equals("YES")) {
		
		LocalDate current = LocalDate.now();
		
		
		
		LocalDate  todate = LocalDate.parse(bto);
		
		if(todate.compareTo(current) > 0) {
			bstatus = "YES";

		}
		else {
			rm.closeBookStatus();
			bstatus = "NO";	
		}
		
	}
	else {
		bstatus = "NO";	
	}
	

		if(user.equals("isAdmin")) {
					
			session.setAttribute("gstatus", gstatus);
			session.setAttribute("bstatus", bstatus);
			session.setAttribute("gto", gto);
			session.setAttribute("bto", bto);
			response.sendRedirect("home.jsp");
		}
		if(user.equals("isStudent")) {
			session.setAttribute("gstatus", gstatus);
			session.setAttribute("bstatus", bstatus);
			session.setAttribute("gto", gto);
			session.setAttribute("bto", bto);
			response.sendRedirect("booking.jsp");
		}
		 
	}

}
