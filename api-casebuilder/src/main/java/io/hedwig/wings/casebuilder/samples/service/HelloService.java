package io.hedwig.wings.casebuilder.samples.service;

import io.hedwig.wings.casebuilder.samples.config.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements CommandLineRunner {

	private final HelloProperties helloProperties;

	@Autowired
	public HelloService(HelloProperties helloProperties) {
		this.helloProperties = helloProperties;
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("======= " + helloProperties.getPrefix() + " " +
				helloProperties.getTarget());
	}

}