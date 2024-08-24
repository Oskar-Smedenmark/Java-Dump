/*PrimeSaver is a REST API that collects numbers separated by if they are prime or not.
 * Authors: Oskar Smedenmark*/

package assignment_5;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


@Path("LotterySystem")
public class LotterySystem {
	
	static TicketPool ticketPools;
	
	//Posts a number to the correct file based on if it's a prime or not
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String drawingRegistration(String inc, @Context ServletContext ctx)
	{
		JsonObject jsonObj = Json.createReader(new StringReader(inc)).readObject();
		Date currentDate = new Date(System.currentTimeMillis());
		Date drawDate = new Date();
		try {
			drawDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jsonObj.getString("drawDate"));
		} catch (ParseException e1) {
			e1.printStackTrace();
			return "Failed to parse date in JSON input.";
		}
		if(currentDate.after(drawDate))
		{
			return "Entered date has already occurred.";
		}
		String path = ctx.getRealPath(ctx.getContextPath());
		int numb = jsonObj.getInt("number");
		String email = jsonObj.getString("email");
		File draws = new File(path + "_" + drawDate +"_drawings.xml");
		try
		{
			FileWriter primeSaver = new FileWriter(draws, true);
			if(draws.length() != 0)
			{
				primeSaver.write("\n");
			}
			primeSaver.write("<Drawing>");
			primeSaver.write("\n <Number>"+numb+"</Number>\n");
			primeSaver.write("\n <Date>"+drawDate+"</Date>\n");
			primeSaver.write("\n <Email>"+email+"</Email>\n");
			primeSaver.write("</Drawing>");
			primeSaver.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		ticketPools.addTickets(numb,new User("",""));
		return "Success!";
		
	}
	//Returns all the drawings saved in the file
	@GET
	@Path("/drawings/{i}/{j}")
	@Produces(MediaType.APPLICATION_XML)
	public String retrieveHistoricalData(@PathParam("i") Date i, @PathParam("j") Date j, @Context ServletContext ctx){
		if(i.after(j))
		{
			return "Dates is in the wrong order.";
		}
		String path = ctx.getRealPath(ctx.getContextPath());
		File draws = new File(path + "_winners.xml");
		ArrayList<String> allDrawings = getFileAsArrayList(draws);
		int winners = 0;
		int winningTotal = 0;
		int luckyNumber = 0;
		Date currentDate = null;
		int[] drawnNumbers = new int[255];
		for(int n = 0; n < 255; n++)
		{
			drawnNumbers[n] = 0;
		}
		int pricePool = 0;
		String ret = "";
		int luckyNumberCount = 0;
		for(int n = 0; n < allDrawings.size(); n+=5)
		{
			String[] arr = allDrawings.get(n+1).split("((<WinningNumber>)|(</WinningNumber>))|((<Date>)|(</Date>))|((<PricePool>)|(</PricePool>))");
			Date d = null;
			try {
				d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[2]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(currentDate != d)
			{
				currentDate = d;
				pricePool += Integer.parseInt(arr[3]);
			}
			if(d.after(i) && d.before(j))
			{
				drawnNumbers[Integer.parseInt(arr[1])]++;
				int numb = drawnNumbers[Integer.parseInt(arr[1])];
				if(luckyNumberCount < numb)
				{
					luckyNumberCount = numb;
					luckyNumber = Integer.parseInt(arr[1]);
				}
				winners++;
			}
		}
		return "Drawn lucky number: " + luckyNumber + "\nNumber of winners: " + winners + "\nWinnings total: " + pricePool;
	}
	
	//Checks if the number i is in any of the files
	@GET
	@Path("number/exists/{i}")
	@Produces(MediaType.TEXT_PLAIN)
	public String exists(@PathParam("i")int i, @Context ServletContext ctx)
	{
		String path = ctx.getRealPath(ctx.getContextPath());
		File nonPrimes = new File(path + "_nonPrimes.xml");
		File primes = new File(path + "_Primes.xml");
		ArrayList<String> numberList = getFileAsArrayList(nonPrimes);
		numberList.addAll(getFileAsArrayList(primes));
		
		for(int j = 0; j < numberList.size(); j+=3)
		{
			String[] arr = numberList.get(j+1).split("((<NonPrime>)|(</NonPrime>))|((<Prime>)|(</Prime>))");
			int num = Integer.parseInt(arr[1]);
			if(i == num)
			{
				return "true";
			}
		}
		return "false";
	}
	
	//Returns the content of the file as a string
	private String getFileAsString(File f)
	{
		String ret = "";
		try
		{
			Scanner reader = new Scanner(f);	
			while(reader.hasNext())
			{
				ret += reader.nextLine() + "\n";
			}
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
			return "<Error>File not found!</Error>";
		}
		return ret;
	}
	//Returns the content of the file as an array list with every row as an element.
	private ArrayList<String> getFileAsArrayList(File f)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Scanner reader = new Scanner(f);	
			String entry = "";
			while(reader.hasNext())
			{
				String currentRow = reader.nextLine();
				entry += currentRow;
				if(currentRow.equals("</Drawing>"))
				{
					list.add(entry);
					entry = "";
				}
			}
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	private static int drawTicket(Date currentDate)
	{
		int drawn = (int)(Math.floor(Math.random()*256));
		if(ticketPools.isTicketBought(drawn))
		{
			ClientConfig config = new ClientConfig();

			Client client = ClientBuilder.newClient(config);

			WebTarget target = client.target(getBaseURI());
			
			target.request()
			.post(Entity.entity(Json.createObjectBuilder().add("Winner", "True")
			.add("WinningNumber", drawn)
			.add("Date", currentDate.toString())
			.add("PricePool", ticketPools.getPricePool())			
			.build().toString(), MediaType.APPLICATION_JSON),
			String.class);
		}
		return drawn;
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/assignment_5/rest/LotterySystem").build();
	}
	
	public static void main()
	{
		LotterySystem sys = new LotterySystem();
		Date currentTime = new Date(System.currentTimeMillis());
		while(true)
		{
			
		}
	}

}