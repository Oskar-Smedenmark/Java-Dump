package uppgift_2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Item implements Comparable<Item> {
	public Date delivered; // utlånad datum, null när Item inte är utlånad
	public final String RFIDNR;
	public String name;

	public Item(String thename, String number) {
		name = thename;
		RFIDNR = number;
		delivered = null;
	}

	public void setDeliverDate(Date d) {
		delivered = d;
	}

	public Date getDeliverDate() {
		return delivered;
	}

	public String getItemNumber() {
		return RFIDNR;
	}

	public String getItemName() {
		return name;
	}

	//Compares based on name of item
	public int compareTo(Item other) {
		if(name.compareTo(other.name) < 0)
		{
			return -1;
		}
		else if(name.compareTo(other.name) > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public boolean equals(Item other) {
		return RFIDNR.equals(other.RFIDNR);
	}

	public String toString() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (delivered == null)
			return RFIDNR + " " + name + " " + "på lager";
		else
			return RFIDNR + " " + name + " " + df.format(delivered);
	}

	// See a simple program example to understand how Date class works;
	public static void main(String[] arg) {

		Calendar calendar = Calendar.getInstance();

		Date newDate = calendar.getTime();

		// Skapa item- object
		Item itm = new Item("Termometer", "1111111111");
		Item itm2 = new Item("Multimeter", "1111111112");

		// Gör item-obj utlånad
		itm.setDeliverDate(newDate);

		System.out.println(itm);
		System.out.println(itm.equals(itm2));

	}

}
