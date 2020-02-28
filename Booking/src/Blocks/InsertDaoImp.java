package Blocks;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Login.ConnectionProvider;

public class InsertDaoImp implements insertDao {

	static Connection conn1;
	static PreparedStatement ps;
	
	
	@Override
	public int insertRoom(Room n) {
		 int status = 0;
		 System.out.println("The room number is "+n.getRoomnumber());
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into hostel (hostelid, hostelname, roomnumber)values(?,?,?)");
			ps.setInt(1, n.getHostelid());	
			ps.setString(2, n.getHostelname());
			ps.setInt(3, n.getRoomnumber());
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into hostel table");
			}
			
			return status;
	}

	@Override
	public int insertHostel(Hostel n) {
		 int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into block (NoOfRooms, NoOfSingleRooms, NoOfDoubleRooms, NoOfTripleRooms, NoOfQuadRooms)values(?,?,?,?,?)");
			ps.setString(1, n.getNoOfRooms());	
			ps.setString(2, n.getNoOfSingleRooms());
			ps.setString(3, n.getNoOfDoubleRooms());
			ps.setString(4, n.getNoOfTripleRooms());
			ps.setString(5, n.getNoOfQuadRooms());
			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into block table");
			}
			
			return status;
	}

	@Override
	public Hostel getHostel(int hostelid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRoom(int roomid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRooms(int roomnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRooms2(String hostelnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels(String Single) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels2(String Double) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels3(String Triple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels4(String Quad) {
		// TODO Auto-generated method stub
		return null;
	}

}
