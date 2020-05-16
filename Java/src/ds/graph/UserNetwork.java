package ds.graph;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class UserNetwork {
	private Map<String, User> userMap;
	private Map<User, List<User>> graph;
	
	public UserNetwork() {
		this.userMap = new HashMap<>();
		this.graph = new HashMap<>();
	}
	
	public void addUser(String userId, String userName) {
		User user = new User(userId, userName);
		this.userMap.put(userId, user);
		this.graph.put(user, new ArrayList<>());
	}

	public void addConnection(String user1, String user2) {
		this.graph.get(this.userMap.get(user1)).add(this.userMap.get(user2));
		this.graph.get(this.userMap.get(user2)).add(this.userMap.get(user1));
	}
	
	public boolean hasConnection(String user1, String user2) {
		return this.graph.get(this.userMap.get(user1)).contains(this.userMap.get(user2));
	}
	
	public void printGraph() {
		for(User user: this.graph.keySet()) {
			System.out.print(user);
			Iterator<User> iterator = this.graph.get(user).iterator();
			while(iterator.hasNext()) {
				System.out.print(" -> " + iterator.next());
			}
			System.out.println();
		}
	}
}
