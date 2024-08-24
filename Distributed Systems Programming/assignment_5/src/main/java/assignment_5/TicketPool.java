package assignment_5;

import java.util.ArrayList;
import java.util.Date;

public class TicketPool {
	private int[] numbers;
	private Date drawDate;
	private ArrayList<User> users;
	private int pricePool;
	
	public TicketPool(Date drawDate)
	{
		users = new ArrayList<User>();
		numbers = new int[256];
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = 0;
		}
		this.drawDate = drawDate;
		pricePool = 0;
	}
	
	//Returns true if ticket is free to be bought otherwise false
	public boolean addTickets(int number, User user)
	{
		if(this.numbers[number] == 0)
		{
			this.numbers[number] = 1;
			user.addTicket(number);
			pricePool += 100;
			users.add(user);
			return true;
		}
		return false;
	}
	
	public boolean isTicketBought(int number)
	{
		return numbers[number] == 1;
	}
	
	public boolean isAfterDate(Date checkDate)
	{
		return this.drawDate.after(checkDate);
	}
	
	public int getPricePool()
	{
		return pricePool;
	}
}
