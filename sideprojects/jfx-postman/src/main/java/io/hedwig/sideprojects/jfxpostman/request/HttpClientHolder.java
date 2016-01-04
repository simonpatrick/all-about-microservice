package io.hedwig.sideprojects.jfxpostman.request;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientHolder {

	private static HttpClient client = HttpClientBuilder.create().build();

	public static HttpClient getHttpClient() {
		return client;
	}

}
