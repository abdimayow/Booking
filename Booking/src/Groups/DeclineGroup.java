package Groups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Student;



@WebServlet("/DeclineGroup")
public class DeclineGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	    GroupDao gd = new GroupDaoImp();

	  
	    HttpSession session = request.getSession();
		
		String submit = request.getParameter("submit");
		
		//When a member exited the group
		if(submit.equals("OK")) {
			
			if(session.getAttribute("grpstatus") != null){
				session.removeAttribute("grpstatus");
				
				String reg = (String)session.getAttribute("regno");
				
				int one = gd.deletestatus(reg);
				
				int two = gd.removegroup(reg);
				
				System.out.println(one + " "+ two);
			}
			if(session.getAttribute("grpdeclined") != null) {
				
				session.removeAttribute("grpdeclined");
				
				String reg = (String)session.getAttribute("regno");
				
				int one = gd.deletestatus(reg);
				
				System.out.println(one);
			}

			
			
			
		}	
		//When accepting to join a group
		if(submit.equals("accept")) {
			
			session.removeAttribute("grpnotification");
			
			String reg = (String)session.getAttribute("regno");
			
			Student stu = gd.getRegno(reg);
			
			
			
			int one = gd.confirmedStudent(reg);
			
			System.out.println(one);
			
			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
			session.setAttribute("grpn", grpname);
			if(stu.getGrp().equals("2")) {

		     group2 g2 = gd.student2(reg);

		     
		     Student leader = gd.getRegno(g2.getLeader());
		     Student snd = gd.getRegno(g2.getRegno2());
		     
		     ArrayList <Student> members = new ArrayList<Student>();
		     members.add(leader);
		     members.add(snd);
		     
		     int sev = gd.editmessage(g2.getLeader(), "COMPLETE");
	         System.out.println("Edited groups table with value "+sev); 
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
				     
				     int count =0;
				     for(int i=0;i<members.size();i++) {
				    
				    	 Student a = members.get(i);
				    	 if( a.getStatus().equals("C") || a.getStatus().equals("L") ) {
				    		 count++;
				    	 }
				    	 
				     }
				     if(count == 3) {
					     int sev = gd.editmessage(g3.getLeader(), "COMPLETE");
				         System.out.println("Edited groups table with value "+sev); 
				     }
				     
				     
				     
				     
				     
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
				     
				     int count =0;
				     for(int i=0;i<members.size();i++) {
				    
				    	 Student a = members.get(i);
				    	 if( a.getStatus().equals("C") || a.getStatus().equals("L") ) {
				    		 count++;
				    	 }
				    	 
				     }
				     if(count == 4) {
					     int sev = gd.editmessage(g4.getLeader(), "COMPLETE");
				         System.out.println("Edited groups table with value "+sev); 
				     }
				     
				     session.setAttribute("members", members); 
			    }					

				
			}
			
		} 
		//When declining to join a group 
		if(submit.equals("decline")) {
			
			session.removeAttribute("grpnotification");
		
			String reg = (String)session.getAttribute("regno");
			
			
			

				 
				Student stu = gd.getRegno(reg);
		

					//If the user has been requested by a group	
					if(stu.getStatus().equals("P")) {
		
						
						if(stu.getGrp().equals("2")) {

					     group2 g2 = gd.student2(reg);
					     
				    	 Student leader = gd.getRegno(g2.getLeader());
					     Student snd = gd.getRegno(g2.getRegno2());
					   					     
					     int one = gd.declineLeader(leader.getRegno());
					     int two = gd.deletestatus(snd.getRegno());
					     
					     int three = gd.deletereg(g2.getLeader());
					     int four = gd.deletereg(g2.getRegno2());
					     
					     int five = gd.deletegrp(g2.getLeader());
					     int six = gd.deletegrp(g2.getRegno2());
					     
                         int sev = gd.editmessage(g2.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
					     
					     
					     int eight = gd.deletegroup2(g2.getLeader());
					     
                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" ");
			
					     
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
							    
							     int one = gd.declineLeader(leader.getRegno());
							     int two = 0;
							     int three = 0;
							     if(snd.getStatus().equals("P")) {
							    	 two = gd.deletestatus(g3.getRegno2());
							     }
							     if(snd.getStatus().equals("C")) {
							    	two = gd.declineStudent(g3.getRegno2()); 
							     }
							     if(trd.getStatus().equals("P")) {
							    	 three = gd.deletestatus(g3.getRegno3());
							     }
							     if(trd.getStatus().equals("C")) {
							    	 three = gd.declineStudent(g3.getRegno3()); 
							     }
							     
							      
							     
							     
							     int four = gd.deletereg(g3.getLeader());
							     int five = gd.deletereg(g3.getRegno2());
							     int six = gd.deletereg(g3.getRegno3());
							     
							     int sev = gd.deletegrp(g3.getLeader());
							     int eight = gd.deletegrp(g3.getRegno2());
							     int nine = gd.deletegrp(g3.getRegno3());
							     
		                         int ten = gd.editmessage(g3.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
							     
							     
							     int ele = gd.deletegroup3(g3.getLeader());
							     
		                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" ");
								
								
							     
							     
							     
							     
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
							     
							    
							     int one = gd.declineLeader(leader.getRegno());
							     int two = 0;
							     int three = 0;
							     int four = 0;
							     if(snd.getStatus().equals("P")) {
							    	 two = gd.deletestatus(g4.getRegno2());
							     }
							     if(snd.getStatus().equals("C")) {
							    	two = gd.declineStudent(g4.getRegno2()); 
							     }
							     if(trd.getStatus().equals("P")) {
							    	 three = gd.deletestatus(g4.getRegno3());
							     }
							     if(trd.getStatus().equals("C")) {
							    	 three = gd.declineStudent(g4.getRegno3()); 
							     }
							     if(frt.getStatus().equals("P")) {
							    	 four = gd.deletestatus(g4.getRegno4());
							     }
							     if(frt.getStatus().equals("C")) {
							    	 four = gd.declineStudent(g4.getRegno4()); 
							     }
							     
							     int five = gd.deletereg(g4.getLeader());
							     int six = gd.deletereg(g4.getRegno2());
							     int sev = gd.deletereg(g4.getRegno3());
							     int eight = gd.deletereg(g4.getRegno4());
							     
							     int nine = gd.deletegrp(g4.getLeader());
							     int ten = gd.deletegrp(g4.getRegno2());
							     int ele = gd.deletegrp(g4.getRegno3());
							     int twel = gd.deletegrp(g4.getRegno4());
							     
		                         int thir = gd.editmessage(g4.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
							     
							     
							     int fort = gd.deletegroup4(g4.getLeader());
							     
		                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" "+twel +" "+thir +" "+fort +" ");
							    
							     
						    }					

							
						}
						
					}
			    
			
			
			
			
			
		}
		//When exiting a group
		if(submit.equals("Confirm")) {
			
			session.removeAttribute("grpn");
            request.removeAttribute("grpn");
			session.removeAttribute("members");
			request.removeAttribute("members");
			 
			String reg = (String)session.getAttribute("regno");
			
			
			

			 
			Student stu = gd.getRegno(reg);
	

			
			//If the user is a group leader	
			if(stu.getStatus().equals("L")) {

				
				if(stu.getGrp().equals("2")) {


			     group2 g2 = gd.getgroup2(reg);
			     
		    	 Student leader = gd.getRegno(g2.getLeader());
			     Student snd = gd.getRegno(g2.getRegno2());
			   					     
			     int one = gd.deletestatus(leader.getRegno());
			     int two = 0;
			     
			     if(snd.getStatus().equals("P")) {
			    	 two = gd.deletestatus(g2.getRegno2());
			     }
			     if(snd.getStatus().equals("C")) {
			    	two = gd.declineStudent(g2.getRegno2()); 
			     }
			     
			     int three = gd.deletereg(g2.getLeader());
			     int four = gd.deletereg(g2.getRegno2());
			     
			     int five = gd.deletegrp(g2.getLeader());
			     int six = gd.deletegrp(g2.getRegno2());
			     
                 int sev = gd.removegroup(reg); 					     
			     
			     
			     int eight = gd.deletegroup2(g2.getLeader());
			     
                 System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" ");
	
			     
				}
				if(stu.getGrp().equals("3")) {

					
					group3 g3 = gd.getgroup3(reg);
				    
					

				    
				    if(g3.getLeader() != null) {
				    	
				    	 Student leader = gd.getRegno(g3.getLeader());
					     Student snd = gd.getRegno(g3.getRegno2());
					     Student trd = gd.getRegno(g3.getRegno3());
					    
					     int one = gd.deletestatus(leader.getRegno());
					     int two = 0;
					     int three = 0;
					     if(snd.getStatus().equals("P")) {
					    	 two = gd.deletestatus(g3.getRegno2());
					     }
					     if(snd.getStatus().equals("C")) {
					    	two = gd.declineStudent(g3.getRegno2()); 
					     }
					     if(trd.getStatus().equals("P")) {
					    	 three = gd.deletestatus(g3.getRegno3());
					     }
					     if(trd.getStatus().equals("C")) {
					    	 three = gd.declineStudent(g3.getRegno3()); 
					     }
					     
					      
					     
					     
					     int four = gd.deletereg(g3.getLeader());
					     int five = gd.deletereg(g3.getRegno2());
					     int six = gd.deletereg(g3.getRegno3());
					     
					     int sev = gd.deletegrp(g3.getLeader());
					     int eight = gd.deletegrp(g3.getRegno2());
					     int nine = gd.deletegrp(g3.getRegno3());
					     
                         int ten = gd.removegroup(reg); 					     
					     
					     
					     int ele = gd.deletegroup3(g3.getLeader());
					     
                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" ");
						
						
					     
					     
					     
					     
				    }

   
					
				}
				if(stu.getGrp().equals("4")) {

					
					group4 g4 = gd.getgroup4(reg);
				    

				    
				    if(g4.getLeader() != null) {
				    	
					     Student leader = gd.getRegno(g4.getLeader());
					     Student snd = gd.getRegno(g4.getRegno2());
					     Student trd = gd.getRegno(g4.getRegno3());
					     Student frt = gd.getRegno(g4.getRegno4());
					     
					    
					     int one = gd.deletestatus(leader.getRegno());
					     int two = 0;
					     int three = 0;
					     int four = 0;
					     if(snd.getStatus().equals("P")) {
					    	 two = gd.deletestatus(g4.getRegno2());
					     }
					     if(snd.getStatus().equals("C")) {
					    	two = gd.declineStudent(g4.getRegno2()); 
					     }
					     if(trd.getStatus().equals("P")) {
					    	 three = gd.deletestatus(g4.getRegno3());
					     }
					     if(trd.getStatus().equals("C")) {
					    	 three = gd.declineStudent(g4.getRegno3()); 
					     }
					     if(frt.getStatus().equals("P")) {
					    	 four = gd.deletestatus(g4.getRegno4());
					     }
					     if(frt.getStatus().equals("C")) {
					    	 four = gd.declineStudent(g4.getRegno4()); 
					     }
					     
					     int five = gd.deletereg(g4.getLeader());
					     int six = gd.deletereg(g4.getRegno2());
					     int sev = gd.deletereg(g4.getRegno3());
					     int eight = gd.deletereg(g4.getRegno4());
					     
					     int nine = gd.deletegrp(g4.getLeader());
					     int ten = gd.deletegrp(g4.getRegno2());
					     int ele = gd.deletegrp(g4.getRegno3());
					     int twel = gd.deletegrp(g4.getRegno4());
					     
                         int thir = gd.removegroup(reg); 					     
					     
					     
					     int fort = gd.deletegroup4(g4.getLeader());
					     
                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" "+twel +" "+thir +" "+fort +" ");
					    
					     
				    }					

					
				}
				session.setAttribute("ustatus", "S");
			}
				//If the user is a group member	
				if(stu.getStatus().equals("C")) {
	
					
					if(stu.getGrp().equals("2")) {

				     group2 g2 = gd.student2(reg);
				     
			    	 Student leader = gd.getRegno(g2.getLeader());
				     Student snd = gd.getRegno(g2.getRegno2());
				   					     
				     int one = gd.declineLeader(leader.getRegno());
				     int two = gd.deletestatus(snd.getRegno());
				     
				     int three = gd.deletereg(g2.getLeader());
				     int four = gd.deletereg(g2.getRegno2());
				     
				     int five = gd.deletegrp(g2.getLeader());
				     int six = gd.deletegrp(g2.getRegno2());
				     
                     int sev = gd.editmessage(g2.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
				     
				     
				     int eight = gd.deletegroup2(g2.getLeader());
				     
                     System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" ");
		
				     
					}
					if(stu.getGrp().equals("3")) {

						
						group3 g3 = new group3();
					    
				    	 Student leader = new Student();
					     Student snd = new Student();
					     Student trd = new Student();
					     
					     int two = 0;
					     int three = 0;
						
					    if(stu.getReg().equals("1")) {
							  g3 = gd.group3student2(reg);
							  
					    	  leader = gd.getRegno(g3.getLeader());
						      snd = gd.getRegno(g3.getRegno2());
						      trd = gd.getRegno(g3.getRegno3());
						      
							     
							    	 two = gd.deletestatus(g3.getRegno2());
							     
							   
							     if(trd.getStatus().equals("P")) {
							    	 three = gd.deletestatus(g3.getRegno3());
							     }
							     if(trd.getStatus().equals("C")) {
							    	 three = gd.declineStudent(g3.getRegno3()); 
							     }
						      
					    }
					    if(stu.getReg().equals("2")) {
							 g3 = gd.group3student3(reg);
							 
					    	  leader = gd.getRegno(g3.getLeader());
						      snd = gd.getRegno(g3.getRegno2());
						      trd = gd.getRegno(g3.getRegno3());
						      
							     if(snd.getStatus().equals("P")) {
							    	 two = gd.deletestatus(g3.getRegno2());
							     }
							     if(snd.getStatus().equals("C")) {
							    	two = gd.declineStudent(g3.getRegno2()); 
							     }
							     
							     three = gd.deletestatus(g3.getRegno3());

						      
					    }
					    
					    if(g3.getLeader() != null) {
					    	

						    
						     int one = gd.declineLeader(leader.getRegno());


						     
						      
						     
						     
						     int four = gd.deletereg(g3.getLeader());
						     int five = gd.deletereg(g3.getRegno2());
						     int six = gd.deletereg(g3.getRegno3());
						     
						     int sev = gd.deletegrp(g3.getLeader());
						     int eight = gd.deletegrp(g3.getRegno2());
						     int nine = gd.deletegrp(g3.getRegno3());
						     
	                         int ten = gd.editmessage(g3.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
						     
						     
						     int ele = gd.deletegroup3(g3.getLeader());
						     
	                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" ");
							
							
						     
						     
						     
						     
					    }

	   
						
					}
					if(stu.getGrp().equals("4")) {

						
						group4 g4 = new group4();
					    
					     Student snd = new Student();
					     Student trd = new Student();
					     Student frt = new Student();
					     
					     int two = 0;
					     int three = 0;
					     int four = 0;
						
					    if(stu.getReg().equals("1")) {
							  g4 = gd.group4student2(reg);
							  
							      snd = gd.getRegno(g4.getRegno2());
							      trd = gd.getRegno(g4.getRegno3());
							      frt = gd.getRegno(g4.getRegno4());
							      
								     
								    	 two = gd.deletestatus(g4.getRegno2());
								  
								     if(trd.getStatus().equals("P")) {
								    	 three = gd.deletestatus(g4.getRegno3());
								     }
								     if(trd.getStatus().equals("C")) {
								    	 three = gd.declineStudent(g4.getRegno3()); 
								     }
								     if(frt.getStatus().equals("P")) {
								    	 four = gd.deletestatus(g4.getRegno4());
								     }
								     if(frt.getStatus().equals("C")) {
								    	 four = gd.declineStudent(g4.getRegno4()); 
								     }
							  
					    }
					    if(stu.getReg().equals("2")) {
							 g4 = gd.group4student3(reg);
							 
						      snd = gd.getRegno(g4.getRegno2());
						      trd = gd.getRegno(g4.getRegno3());
						      frt = gd.getRegno(g4.getRegno4());
						      
							     if(snd.getStatus().equals("P")) {
							    	 two = gd.deletestatus(g4.getRegno2());
							     }
							     if(snd.getStatus().equals("C")) {
							    	two = gd.declineStudent(g4.getRegno2()); 
							     }
							   
							    	 three = gd.deletestatus(g4.getRegno3());
				
							     if(frt.getStatus().equals("P")) {
							    	 four = gd.deletestatus(g4.getRegno4());
							     }
							     if(frt.getStatus().equals("C")) {
							    	 four = gd.declineStudent(g4.getRegno4()); 
							     }
							 
					    }
					    if(stu.getReg().equals("3")) {
							 g4 = gd.group4student4(reg);
							 
						      snd = gd.getRegno(g4.getRegno2());
						      trd = gd.getRegno(g4.getRegno3());
						      frt = gd.getRegno(g4.getRegno4());
						      
							     if(snd.getStatus().equals("P")) {
							    	 two = gd.deletestatus(g4.getRegno2());
							     }
							     if(snd.getStatus().equals("C")) {
							    	two = gd.declineStudent(g4.getRegno2()); 
							     }
							     if(trd.getStatus().equals("P")) {
							    	 three = gd.deletestatus(g4.getRegno3());
							     }
							     if(trd.getStatus().equals("C")) {
							    	 three = gd.declineStudent(g4.getRegno3()); 
							     }
							    
							    	 four = gd.deletestatus(g4.getRegno4());
							
							 
					    }
					    
					    if(g4.getLeader() != null) {
					    	
						     Student leader = gd.getRegno(g4.getLeader());

						     
						    
						     int one = gd.declineLeader(leader.getRegno());


						     
						     int five = gd.deletereg(g4.getLeader());
						     int six = gd.deletereg(g4.getRegno2());
						     int sev = gd.deletereg(g4.getRegno3());
						     int eight = gd.deletereg(g4.getRegno4());
						     
						     int nine = gd.deletegrp(g4.getLeader());
						     int ten = gd.deletegrp(g4.getRegno2());
						     int ele = gd.deletegrp(g4.getRegno3());
						     int twel = gd.deletegrp(g4.getRegno4());
						     
	                         int thir = gd.editmessage(g4.getLeader(), "Group could not be formed "+stu.getRegno()+" declined to join the group"); 					     
						     
						     
						     int fort = gd.deletegroup4(g4.getLeader());
						     
	                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" "+twel +" "+thir +" "+fort +" ");
						    
						     
					    }					

						
					}
					session.setAttribute("ustatus", "S");	
				}
		    
		
			
		}
		
		
		
	response.sendRedirect("booking.jsp");	
		
		
	}

}
