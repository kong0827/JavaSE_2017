import java.util.ArrayList;
import java.util.List;



public class GetUser {
	
	
	List<User> list = new ArrayList<>();
	User user1 = new User();
	User user2 = new User();
	
	
	public List<User> getUser(){
		
		
		
		user1.setName("a");
		user2.setName("b");
		user1.setAge(12);
		user2.setAge(22);
		list.add(user1);
		list.add(user2);
		return list;
		
	}

}
