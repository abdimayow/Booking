package Groups;



public interface GroupDao {
	public int insertGroup(Group g) ;

	public boolean checkGroup(String status);
	
	public Group getGroup(String status);
	
	public boolean closeGroup();
	
	
}
