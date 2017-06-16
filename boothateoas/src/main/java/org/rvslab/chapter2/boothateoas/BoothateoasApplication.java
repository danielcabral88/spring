package org.rvslab.chapter2.boothateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.DummyInvocationUtils;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableGlobalMethodSecurity
@SpringBootApplication
public class BoothateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoothateoasApplication.class, args);
	}

		@RestController
	class GreetingController {
//		@RequestMapping("/")
//		Greet greet() {
//			return new Greet("Hello World!");
//		}
		
		@RequestMapping("/greeting")
		@ResponseBody
		public HttpEntity<Greet> greeting(
				@RequestParam(value = "name", required = false, defaultValue = "HATEOAS") String name) {
			Greet greet = new Greet("Hello " + name);
			greet.add(ControllerLinkBuilder.linkTo(DummyInvocationUtils.methodOn(GreetingController.class).greeting(name)).withSelfRel());
			return new ResponseEntity<Greet>(greet, HttpStatus.OK);
		}
	}

	class Greet extends ResourceSupport {
		private String message;

		public Greet() {
		}

		public Greet(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
