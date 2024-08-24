package assignment_5;

import java.net.URI;
import java.util.ArrayList;

import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class LotteryClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());
		ArrayList<Integer> triedNums = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			int number = (int) Math.floor(Math.random() * 100);
			int tries = 0;
			while (triedNums.contains(number) || Boolean.parseBoolean(target.path("number/exists/" + number + "/")
					.request().accept(MediaType.TEXT_PLAIN).get(String.class))) {
				number = (int) Math.floor(Math.random() * 100);
				tries++;
				if (tries > 100) {
					break;
				}
			}
			triedNums.add(number);
			Primes p = new Primes(number,
					(nn, r) -> System.out.println(
						target.request()
						.post(Entity.entity(Json.createObjectBuilder().add("num", nn)
						.add("isPrime", r).build().toString(), MediaType.APPLICATION_JSON),
						String.class)));
			p.start();
		}
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/assignment_3/rest/PrimeSaver").build();
	}
}
