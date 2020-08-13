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
		ps = conn1.prepareStatement("insert into students (name, regno, faculty, gender, department, year, email, recoveryemail, password)values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1, c.getName());	
		ps.setString(2, c.getRegno());
		ps.setString(3, c.getFaculty());
		ps.setString(4, c.getGender());
		ps.setString(5, c.getDepartment());
		ps.setString(6, c.getYear());
		ps.setString(7, c.getEmail());
		ps.setString(8, c.getRecoveryemail());
		ps.setString(9, pass);
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
		ps = conn1.prepareStatement("select * from students where regno=? and password=?");
		ps.setString(1, firstname);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			c.setName(rs.getString(1));
			c.setRegno(rs.getString(2));
			c.setFaculty(rs.getString(3));
			c.setGender(rs.getString(4));
			c.setDepartment(rs.getString(5));
			c.setYear(rs.getString(6));
			c.setEmail(rs.getString(7));
			c.setRecoveryemail(rs.getString(8));		
			c.setPassword(rs.getString(9));
			c.setStatus(rs.getString(10));
			c.setGrp(rs.getString(11));
			c.setReg(rs.getString(12));
				
			
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
		ps = conn1.prepareStatement("insert into admin(name, department, position, email, recoveryemail, password)values(?,?,?,?,?,?)");
		ps.setString(1, a.getName());	
		ps.setString(2, a.getDepartment());
		ps.setString(3, a.getPosition());
		ps.setString(4, a.getEmail());
		ps.setString(5, a.getRecoveryemail());
		ps.setString(6, pass);
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
			ps = conn1.prepareStatement("select * from admin where name=? and password=?");
			ps.setString(1, firstname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setDepartment(rs.getString(3));
				a.setPosition(rs.getString(4));
				a.setEmail(rs.getString(5));
				a.setRecoveryemail(rs.getString(6));
				a.setPassword(rs.getString(7));
					
				
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting admin data");
				}
				
				return a;
	}
	
}
