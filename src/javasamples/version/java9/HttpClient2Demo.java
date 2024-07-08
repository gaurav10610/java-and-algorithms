package javasamples.version.java9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient2Demo {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://howtodoinjava.com/")).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.print("status code => " + response.statusCode());
		System.out.print("body => " + response.body());
	}
}
