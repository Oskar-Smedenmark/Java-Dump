package assignment_5;

import java.util.ArrayList;

public class User {
	String name;
	String email;
	ArrayList<Integer> tickets;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		tickets = new ArrayList<Integer>();
	}
	
	public void addTicket(int num)
	{
		tickets.add(num);
	}
	
	public void clearTickets()
	{
		tickets.clear();
	}
}
