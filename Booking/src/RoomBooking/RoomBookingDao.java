package RoomBooking;



public interface RoomBookingDao {

	public int insertBookingStatus(BookStatus b) ;

	public boolean checkBookStatus(String status);
	
	public boolean checkBookStatus(String from,String to);
	
	public BookStatus getBookStatus(String status);
	
	public boolean closeBookStatus();
	
	public String getToDate(String status);
	
	 
}
