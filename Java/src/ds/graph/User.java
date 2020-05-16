package ds.graph;

public class User {

	private String name;
	private String userID;
	
	public User(String userID, String name) {	
		this.setName(name);
		this.setUserID(userID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public int hashCode() {
		return this.userID.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		return ((User) obj).hashCode() == this.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("%-15s", this.name);
	}
}
