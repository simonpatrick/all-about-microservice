package io.hedwig.sideprojects.jfxpostman.request;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.Callable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestAction implements Callable<HttpResponse> {

	private static final Logger LOG = LoggerFactory.getLogger(RequestAction.class);

	private static final String ACTION_GET = "GET";
	private static final String ACTION_POST = "POST";

	private String url;
	private String action;
	private String filePath;

	public RequestAction(String url, String action, String filePath) {
		this.url = url;
		this.action = action;
		this.filePath = filePath;
	}

	@Override
	public HttpResponse call() throws Exception {
		HttpClient client = HttpClientHolder.getHttpClient();
		double r = Math.random();
		int topicId = (int) (r * 1000000000);
		String url = "http://zhuzhi1.asiapacific.hpqcorp.net:8080/rest/private/v2/community/document/upload?communityId=id666&currentPortal=hpes&currentFolder=&topicId=" + topicId;

		HttpRequestBase request = null;
		if (ACTION_GET.equals(action)) {
			request = new HttpGet(new URI(url));
		} else if (ACTION_POST.equals(action)) {
			HttpPost post = new HttpPost(new URI(url));
			File file = new File(filePath);
			// FileBody bin = new FileBody(file, ContentType.DEFAULT_BINARY,
			// file.getName() + "_" + filePath);
			FileBody bin = new FileBody(file);
			HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("filedata", bin).build();
			post.setEntity(reqEntity);
			request = post;
		}
		request.setHeader(AuthenticationHelper.getBasicAuthHeader());
		// HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
		// RequestConfig config =
		// RequestConfig.custom().setProxy(proxy).build();
		// request.setConfig(config);

		try {
			LOG.debug("filePath: {}", filePath);
			HttpResponse response = client.execute(request, AuthenticationHelper.getHttpContext());
			StatusLine statusLine = response.getStatusLine();
			LOG.debug("status: {}", statusLine.getStatusCode());
			LOG.debug("url: {}", url);
			if (statusLine.getStatusCode() == 200) {
				System.out.println(statusLine.getStatusCode());
				System.out.println(inputStream2String(response.getEntity().getContent()));
			} else {
				System.out.println(statusLine.getStatusCode());
				System.out.println(inputStream2String(response.getEntity().getContent()));
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.releaseConnection();
		}
		return null;
	}

	private String inputStream2String(InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = in.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}

}
