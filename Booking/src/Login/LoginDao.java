package Login;



public interface LoginDao {

public int insertStudent(Student c) ;

public Student getStudent(String firstname,String password);

public int insertAdmin(Admin a) ;

public Admin getAdmin(String firstname,String password);

}
