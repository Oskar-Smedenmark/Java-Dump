package uppgift3_3;

public class Land
{
	private String name, capital;
	private int pop;
	private double area;
	
	public Land(String name, String capital, int pop, double area)
	{
		this.name = name;
		this.capital = capital;
		this.pop = pop;
		this.area = area;
	}
	
	public String getName()
	{
		return name;
	}
	public String getCapital()
	{
		return capital;
	}
	public int getPop()
	{
		return pop;
	}
	public double getArea()
	{
		return area;
	}
	
	public String toString()
	{
		return "Name: " + name + "\r\nCapital: " + capital + "\r\nArea: " + area + "km^2\r\nPopulation: " + pop;
	}
	

}
