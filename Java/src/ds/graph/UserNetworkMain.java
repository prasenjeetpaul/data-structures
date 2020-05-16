package ds.graph;

public class UserNetworkMain {

	public static void main(String args[]) {
		UserNetwork network = new UserNetwork();
		
		network.addUser("james", "James Thomas");
		network.addUser("thomas", "Thomas Jonson");
		network.addUser("stephnie", "Stephnie Clark");
		network.addUser("lucy", "Lucy");
		network.addUser("steve", "Steve Rogeres");
		
		network.addConnection("james", "lucy");
		network.addConnection("james", "steve");
		network.addConnection("james", "thomas");
		network.addConnection("stephnie", "lucy");
		network.addConnection("thomas", "lucy");
		
		network.printGraph();
		
		System.out.println("James is friend with Lucy: " + network.hasConnection("james", "lucy"));
		System.out.println("Steve is friend with Lucy: " + network.hasConnection("steve", "lucy"));
	}
}
