package io.hedwig.sideprojects.jfxpostman.request;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestExecutor implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(RequestExecutor.class);

	private String url;
	private String action;
	private int threadNum;
	private String filePath;

	public RequestExecutor(String url, String action, int threadNum, String filePath) {
		this.url = url;
		this.action = action;
		this.threadNum = threadNum;
		this.filePath = filePath;
	}

	public List<HttpResponse> concurrentExecute() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);

		Set<RequestAction> callables = new HashSet<>();

		// temp
		List<HttpResponse> resList = new ArrayList<>();
		File f = new File("C:/Users/zouz/Desktop/Files");
//		File f = new File("C:/Users/zouz/Desktop/Sharepoint_PT_L_XLS_27MB.xls");
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					File file = files[i];
					callables.add(new RequestAction(url, action, file.getAbsolutePath()));
				}
			}
		} else {
			callables.add(new RequestAction(url, action, f.getAbsolutePath()));
		}

		List<Future<HttpResponse>> futures = executorService.invokeAll(callables);
		for (Future<HttpResponse> future : futures) {
			resList.add(future.get());
		}

		return resList;
	}

	@Override
	public void run() {
		try {
			this.concurrentExecute();
		} catch (InterruptedException | ExecutionException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
