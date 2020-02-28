package Blocks;

public interface insertDao {
	
	public int insertHostel (Hostel n);
	public int insertRoom (Room n);
	
	public Hostel getHostel(int hostelid);
	public Room   getRoom(int roomid);
	
	public Room  getRooms(int roomnumber);
	public Room  getRooms2(String hostelnumber);
	public Hostel getHostels(String Single);
	public Hostel getHostels2(String Double);
	public Hostel getHostels3(String Triple);
	public Hostel getHostels4(String Quad);
	
	
	
	

}
