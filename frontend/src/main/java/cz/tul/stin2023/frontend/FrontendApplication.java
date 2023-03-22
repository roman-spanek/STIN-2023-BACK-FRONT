package cz.tul.stin2023.frontend;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FrontendApplication {


	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		URI targetURI = new URI("http://localhost:8081/");
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(targetURI)
				.GET()
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println(response.statusCode());
		System.out.println(response.body());

	}

}
