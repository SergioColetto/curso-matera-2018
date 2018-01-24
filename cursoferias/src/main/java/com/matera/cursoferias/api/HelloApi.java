package com.matera.cursoferias.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloApi {

	@GetMapping(path = "/aula/hello", produces = "text/plain")
	public ResponseEntity<String> sayHello(@RequestParam String who) {
		return ResponseEntity.ok(who);
	}
	
}
