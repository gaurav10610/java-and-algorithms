package java.version.java11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Composition of HTTP client allows using builder pattern to compose the
 * instance
 *
 */
public class HttpClient2Demo {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		System.out.println("executing synchronous api call...");
		synchronousRequest();
		System.out.println("cone executing synchronous api call...");
		System.out.println();

		System.out.println("executing asynchronous api calls...");
		asynchronousRequest();
		System.out.println("done executing all the asynchronous api calls...");

	}

	private static void synchronousRequest() throws URISyntaxException, IOException, InterruptedException {

		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).connectTimeout(Duration.ofSeconds(10))
				.build();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("status code: " + response.statusCode());
		System.out.println("headers: " + response.headers());
		System.out.println(response.body());
	}

	@SuppressWarnings({ "unchecked" })
	private static void asynchronousRequest() throws URISyntaxException, IOException, InterruptedException {
		List<URI> uris = Stream.of("https://postman-echo.com/get?foo1=bar1&foo2=bar2",
				"https://postman-echo.com/get?foo1=bar1&foo2=bar2", "https://postman-echo.com/get?foo1=bar1&foo2=bar2")
				.map(URI::create).collect(Collectors.toList());

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).connectTimeout(Duration.ofSeconds(10))
				.build();

		CompletableFuture<Void>[] futures = uris.stream().map(uri -> buildAsyncRequest(client, uri))
				.toArray(CompletableFuture[]::new);

		CompletableFuture.allOf(futures).join();

	}

	private static CompletableFuture<Void> buildAsyncRequest(HttpClient client, URI uri) {
		HttpRequest request = HttpRequest.newBuilder().uri(uri).timeout(Duration.ofSeconds(5)).build();

		return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply((response) -> {
			System.out.println("status code: " + response.statusCode());
			System.out.println("headers: " + response.headers());
			System.out.println(response.body());
			return response;
		}).thenApply(HttpResponse::statusCode).thenApply(statusCode -> statusCode == 200).exceptionally(ex -> false)
				.thenAccept((success) -> {
					if (success) {
						System.out.println("api call is successful");
					} else {
						System.out.println("api call is not successful");
					}
					System.out.println();
				});
	}

}
