package Login;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.ConnectionProvider;
import Login.Student;


public class LoginDaoImp implements LoginDao{
	static Connection conn1;
	static PreparedStatement ps;
	@Override
	public int insertStudent(Student c) {
		int status = 0;
		
		try {
		//Create message digest intance for md5	
		MessageDigest md = MessageDigest.getInstance("MD5");
		//Add password bytes to digest
		md.update(c.getPassword().getBytes());
		//Get the hashes bytes
		byte[] bytes = md.digest();
		//Thus bytes [] has bytes in decimal format
		//convert it to hexadecimal format
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<bytes.length;i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
	
			
			
			
			
			
			
		String pass=sb.toString();	
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into student (regno, firstname, secondname, faculty, department,password)values(?,?,?,?,?,?)");
		ps.setString(1, c.getRegno());	
		ps.setString(2, c.getFirstname());
		ps.setString(3, c.getSecondname());
		ps.setString(4, c.getFaculty());
		ps.setString(5, c.getDepartment());
		ps.setString(6, pass);
		status = ps.executeUpdate();
		
		conn1.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into student table");
		}
		
		return status;
	}
	@Override
	public Student getStudent(String firstname, String password) {
		Student c = new Student();
		
	
		
	try {
		
		//Create message digest intance for md5	
				MessageDigest md = MessageDigest.getInstance("MD5");
				//Add password bytes to digest
				md.update(password.getBytes());
				//Get the hashes bytes
				byte[] bytes = md.digest();
				//Thus bytes [] has bytes in decimal format
				//convert it to hexadecimal format
				StringBuilder sb = new StringBuilder();
				
				for(int i =0; i<bytes.length;i++) {
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
			
					
					
					
					
					
					
				String pass=sb.toString();
		
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from student where firstname=? and password=?");
		ps.setString(1, firstname);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			c.setRegno(rs.getString(1));
			c.setFirstname(rs.getString(2));
			c.setSecondname(rs.getString(3));
			c.setFaculty(rs.getString(4));
			c.setDepartment	(rs.getString(5));
			c.setPassword(rs.getString(6));
				
			
		}
		
		
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting student data");
			}
			
			return c;
		}
	@Override
	public int insertAdmin(Admin a) {
      int status = 0;
		
		try {
		//Create message digest intance for md5	
		MessageDigest md = MessageDigest.getInstance("MD5");
		//Add password bytes to digest
		md.update(a.getPassword().getBytes());
		//Get the hashes bytes
		byte[] bytes = md.digest();
		//Thus bytes [] has bytes in decimal format
		//convert it to hexadecimal format
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<bytes.length;i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
	
			
			
			
			
			
			
		String pass=sb.toString();	
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into admin(firstname, secondname, department, position, password)values(?,?,?,?,?)");
		ps.setString(1, a.getFirstname());	
		ps.setString(2, a.getSecondname());
		ps.setString(3, a.getDepartment());
		ps.setString(4, a.getPosition());
		ps.setString(5, pass);
		status = ps.executeUpdate();
		
		conn1.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into Admin table");
		}
		
		return status;
	}
	@Override
	public Admin getAdmin(String firstname, String password) {
		Admin a = new Admin();
		
		
		
		try {
			
			//Create message digest intance for md5	
					MessageDigest md = MessageDigest.getInstance("MD5");
					//Add password bytes to digest
					md.update(password.getBytes());
					//Get the hashes bytes
					byte[] bytes = md.digest();
					//Thus bytes [] has bytes in decimal format
					//convert it to hexadecimal format
					StringBuilder sb = new StringBuilder();
					
					for(int i =0; i<bytes.length;i++) {
						sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
					}
				
						
						
						
						
						
						
					String pass=sb.toString();
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from admin where firstname=? and password=?");
			ps.setString(1, firstname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				a.setId(rs.getInt(1));
				a.setFirstname(rs.getString(2));
				a.setSecondname(rs.getString(3));
				a.setDepartment(rs.getString(4));
				a.setPosition(rs.getString(5));
				a.setPassword(rs.getString(6));
					
				
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting admin data");
				}
				
				return a;
	}
	
}
