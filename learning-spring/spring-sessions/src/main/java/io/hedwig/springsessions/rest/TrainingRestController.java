package io.hedwig.springsessions.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/rest")
public class TrainingRestController {

	@RequestMapping("/test")
	public String test(HttpSession session) {
		Random r = new Random();
		session.setAttribute("boot:" + r.nextLong(), UUID.randomUUID()
				.toString());
		return "rest:controller:hello:world";
	}

}
