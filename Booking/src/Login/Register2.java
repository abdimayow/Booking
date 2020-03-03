package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register2")
public class Register2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 LoginDao cd = new LoginDaoImp();
			
			
			
			
		 String submitype = request.getParameter("submit");
			
			
			String boys[] = {"John","Mark","Paul","Elvin","Aaron","Ali","Hassan","Jake","Juma","Harry","Henry","Kane"};
			
			String girls[] = {"Arya","Anya","Amber","Aliz","Mulki","Fatma","Jane","Rose","Zahra","Sofia","Agnes","Adele"};
					
					
			
			if(submitype.equals("Register Student")) {
				String regno = request.getParameter("regno"); 
				String name = request.getParameter("name");	
				String faculty = request.getParameter("faculty");
				String gender  = request.getParameter("gender");
				String department = request.getParameter("department");
				String year = request.getParameter("year");
				String email = request.getParameter("email");
				String recoveryemail = request.getParameter("recoveryemail");
				String password = request.getParameter("password");
				
				Student c = new Student();
				
				c.setRegno(regno);
				c.setName(name);
				c.setFaculty(faculty );
				c.setDepartment	(department);
				c.setYear(year);
				c.setEmail(email);
				c.setRecoveryemail(recoveryemail);
				c.setPassword(password);
				
				
				
				 int n = cd.insertStudent(c);
				 
				 System.out.println(n);
                
				 HttpSession session = request.getSession();
				session.setAttribute("success","Student has been successfully registered");
				
			    response.sendRedirect("StudentReg.jsp");	
			
					
				}
			else if(submitype.equals("Register Admin")) {
					String name = request.getParameter("name");
					String department = request.getParameter("department");
					String position = request.getParameter("position");
					String email = request.getParameter("email");
					String recoveryemail = request.getParameter("recoveryemail");
					String password = request.getParameter("password");
				    
					Admin c = new Admin();
					
					
					c.setName(name);
					c.setDepartment	(department);
					c.setPosition(position);
					c.setEmail(email);
					c.setRecoveryemail(recoveryemail);
					c.setPassword(password);

					
					 int n = cd.insertAdmin(c);
					 
					 System.out.println(n);
					
					HttpSession session = request.getSession();
					session.setAttribute("success", "Admin has been successfully registered");
				

					
				    response.sendRedirect("adminreg.jsp");
					}else if(submitype.equals("RHM")) {
											
						for(int i=0;i<boys.length;i++) {
							String reg = "HB13/01";
							String regno = reg+i+"/16"; 
							String name = boys[i]+"h";	
							String faculty = "HEALTH SCIENCE";
							String gender  = "MALE";
							String department = "NURSING";
							String year = "2016";
							String email = name+"@gmail.com";
							String recoveryemail = name+2+"@gmail.com";
							String password = name;
							
							Student c = new Student();
							
							c.setRegno(regno);
							c.setName(name);
							c.setFaculty(faculty );
							c.setGender(gender);
							c.setDepartment	(department);
							c.setYear(year);
							c.setEmail(email);
							c.setRecoveryemail(recoveryemail);
							c.setPassword(password);
							
							 int n = cd.insertStudent(c);
							 
							 System.out.println(n+i);
						}
						
		                
						 HttpSession session = request.getSession();
						session.setAttribute("success","Health Science Male Student has been successfully registered");
						
					    response.sendRedirect("AutoRegister.jsp");	
					
							
						}else if(submitype.equals("REM")) {
							for(int i=0;i<boys.length;i++) {
								String reg = "E13/01";
								String regno = reg+i+"/16"; 
								String name = boys[i]+"e";	
								String faculty = "ENGINEERING";
								String gender  = "MALE";
								String department = "CIVIL";
								String year = "2016";
								String email = name+"@gmail.com";
								String recoveryemail = name+2+"@gmail.com";
								String password = name;
								
								Student c = new Student();
								
								c.setRegno(regno);
								c.setName(name);
								c.setFaculty(faculty );
								c.setGender(gender);
								c.setDepartment	(department);
								c.setYear(year);
								c.setEmail(email);
								c.setRecoveryemail(recoveryemail);
								c.setPassword(password);
								
								 int n = cd.insertStudent(c);
								 
								 System.out.println(n+i);
							}
							
			                
							 HttpSession session = request.getSession();
							session.setAttribute("success","Engineering Science Male Student has been successfully registered");
							
						    response.sendRedirect("AutoRegister.jsp");	
						
								
							}else if(submitype.equals("RNM")) {
								for(int i=0;i<boys.length;i++) {
									String reg = "S13/01";
									String regno = reg+i+"/16"; 
									String name = boys[i]+"s";	
									String faculty = "SCIENCE";
									String gender  = "MALE";
									String department = "COMPUTER SCIENCE";
									String year = "2016";
									String email = name+"@gmail.com";
									String recoveryemail = name+2+"@gmail.com";
									String password = name;
									
									Student c = new Student();
									
									c.setRegno(regno);
									c.setName(name);
									c.setFaculty(faculty );
									c.setGender(gender);
									c.setDepartment	(department);
									c.setYear(year);
									c.setEmail(email);
									c.setRecoveryemail(recoveryemail);
									c.setPassword(password);
									
									 int n = cd.insertStudent(c);
									 
									 System.out.println(n+i);
								}
								
				                
								 HttpSession session = request.getSession();
								session.setAttribute("success","Computer Science Male Student has been successfully registered");
								
							    response.sendRedirect("AutoRegister.jsp");	
							
									
								}else if(submitype.equals("RHF")) {
									for(int i=0;i<girls.length;i++) {
										String reg = "HB13/10";
										String regno = reg+i+"/16"; 
										String name = girls[i]+"h";	
										String faculty = "HEALTH SCIENCE";
										String gender  = "FEMALE";
										String department = "NURSING";
										String year = "2016";
										String email = name+"@gmail.com";
										String recoveryemail = name+2+"@gmail.com";
										String password = name;
										
										Student c = new Student();
										
										c.setRegno(regno);
										c.setName(name);
										c.setFaculty(faculty );
										c.setGender(gender);
										c.setDepartment	(department);
										c.setYear(year);
										c.setEmail(email);
										c.setRecoveryemail(recoveryemail);
										c.setPassword(password);
										
										 int n = cd.insertStudent(c);
										 
										 System.out.println(n+i);
									}
									
					                
									 HttpSession session = request.getSession();
									session.setAttribute("success","Health Science Female  Student has been successfully registered");
									
								    response.sendRedirect("AutoRegister.jsp");	
								
										
									}else if(submitype.equals("REF")) {
										for(int i=0;i<girls.length;i++) {
											String reg = "E13/10";
											String regno = reg+i+"/16"; 
											String name = girls[i]+"e";	
											String faculty = "ENGINEERING";
											String gender  = "FEMALE";
											String department = "CIVIL";
											String year = "2016";
											String email = name+"@gmail.com";
											String recoveryemail = name+2+"@gmail.com";
											String password = name;
											
											Student c = new Student();
											
											c.setRegno(regno);
											c.setName(name);
											c.setFaculty(faculty );
											c.setGender(gender);
											c.setDepartment	(department);
											c.setYear(year);
											c.setEmail(email);
											c.setRecoveryemail(recoveryemail);
											c.setPassword(password);
											
											 int n = cd.insertStudent(c);
											 
											 System.out.println(n+i);
										}
										
						                
										 HttpSession session = request.getSession();
										session.setAttribute("success","Engineering Science Female Student has been successfully registered");
										
									    response.sendRedirect("AutoRegister.jsp");	
									
											
										}else if(submitype.equals("RNF")) {
											for(int i=0;i<girls.length;i++) {
												String reg = "S13/10";
												String regno = reg+i+"/16"; 
												String name = girls[i]+"s";	
												String faculty = "SCIENCE";
												String gender  = "FEMALE";
												String department = "COMPUTER SCIENCE";
												String year = "2016";
												String email = name+"@gmail.com";
												String recoveryemail = name+2+"@gmail.com";
												String password = name;
												
												Student c = new Student();
												
												c.setRegno(regno);
												c.setName(name);
												c.setFaculty(faculty );
												c.setGender(gender);
												c.setDepartment	(department);
												c.setYear(year);
												c.setEmail(email);
												c.setRecoveryemail(recoveryemail);
												c.setPassword(password);
												
												 int n = cd.insertStudent(c);
												 
												 System.out.println(n+i);
											}
											
							                
											 HttpSession session = request.getSession();
											session.setAttribute("success","Computer Science Female Student has been successfully registered");
											
										    response.sendRedirect("AutoRegister.jsp");	
										
												
											}else {
						 response.sendRedirect("register.jsp");
				}
			
			
		}

	}


