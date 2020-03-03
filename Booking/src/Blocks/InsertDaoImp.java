package Blocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Login.ConnectionProvider;


public class InsertDaoImp implements insertDao {

	static Connection conn1;
	static PreparedStatement ps;
	
	
	@Override
	public int insertRoom(Room n) {
		 int status = 0;

		 System.out.println(n.getHostelid());
		 System.out.println(n.getRoomno());
		 System.out.println(n.getType());
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into rooms (hostelid, roomno, type) values(?,?,?)");
			
			ps.setInt(1, n.getHostelid());
			ps.setInt(2, n.getRoomno());
			ps.setString(3, n.getType());
			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into rooms table");
			}
			
			return status;
	}

	@Override
	public int insertHostel(Hostel n) {
		 int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into hostels (hostelname, NoOfRooms, NoOfSingleRooms, NoOfDoubleRooms, NoOfTripleRooms, NoOfQuadRooms, NoOfSextupleRooms)values(?,?,?,?,?,?,?)");
			ps.setString(1, n.getHostelname());
			ps.setString(2, n.getNoOfRooms());
			ps.setString(3, n.getNoOfSingleRooms());
			ps.setString(4, n.getNoOfDoubleRooms());
			ps.setString(5, n.getNoOfTripleRooms());
			ps.setString(6, n.getNoOfQuadRooms());
			ps.setString(7, n.getNoOfSextupleRooms());
			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into hostels table");
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

	@Override
	public int insertBlocks(Blocks b) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into blocks (blockname)values(?)");
			ps.setString(1, b.getBlockname());	

			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into blocks table");
			}
			
			return status;
	}

	@Override
	public ArrayList<Blocks> getBlocks() {
		ArrayList <Blocks> b = new ArrayList<Blocks>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from blocks");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Blocks c = new Blocks();
			c.setBlockid(rs.getInt(1));
			c.setBlockname(rs.getString(2));
	
			
			b.add(c);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting blocks from blocks table");
		}
		
	
		return b;
	}

	@Override
	public ArrayList<Hostel> getHostels() {
     ArrayList<Hostel> h = new ArrayList<Hostel>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from hostels");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Hostel i = new Hostel();
			i.setHostelid(rs.getInt(1));
			i.setHostelname(rs.getString(2));
			i.setNoOfRooms(rs.getString(3));
			i.setNoOfSingleRooms(rs.getString(4));
			i.setNoOfDoubleRooms(rs.getString(5));
			i.setNoOfTripleRooms(rs.getString(6));
			i.setNoOfQuadRooms(rs.getString(7));
			i.setNoOfSextupleRooms(rs.getString(8));
	
			
			h.add(i);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting hostels from hostels table");
		}
		
	
		return h;
	}

	@Override
	public int insertBlock(Block b) {
		int status = 0;

		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into block (blockid, hostelid)values(?,?)");
		ps.setInt(1, b.getBlockid());	
		ps.setInt(2, b.getHostelid());

		

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
	public int checkBlock(int hostelid) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select blockid from block where hostelid=?");
			ps.setInt(1, hostelid);	

			
	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
	    			
	       status = rs.getInt("blockid");
			}else {
				status = 0;
			}
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in checking  blocks table");
			}
			
			return status;
	}

	@Override
	public String getHostelname(int hostelid) {
		 String status = "";

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select hostelname from hostels where hostelid=?");
			ps.setInt(1, hostelid);	

			
	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
	    			
	       status = rs.getString("hostelname");
			}else {
				status = "No Hostel found";
			}
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostelname from hostels table");
			}
			
			return status;
	}

	@Override
	public ArrayList<Room> getRooms() {
ArrayList<Room> h = new ArrayList<Room>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from rooms");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Room i = new Room();
			i.setRoomid(rs.getInt(1));
			i.setHostelid(rs.getInt(2));
			i.setRoomno(rs.getInt(3));
			i.setType(rs.getString(4));
	
	
			
			h.add(i);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting Rooms from Room table");
		}
		
	
		return h;
	}

	@Override
	public int insertBed(Bed b) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into bed (roomid, bedno) values(?,?)");
			
			ps.setInt(1, b.getRoomid());
			ps.setInt(2, b.getBedno());
			
			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into bed table");
			}
			
			return status;
	}

}
