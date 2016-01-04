package io.hedwig.sideprojects.jfxpostman.request;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class AuthenticationHelper {

	public static HttpContext context = new BasicHttpContext();
	
	public static Header getBasicAuthHeader() {
//		return new BasicHeader("Authorization", "Basic cm9vdDpndG4="); // TODO
		return new BasicHeader("Authorization", "Basic c2xwZXhvOjEyMzQ1Ng=="); // TODO
	}
	

	public static HttpContext getHttpContext() {
		return context;
	}
	
}
