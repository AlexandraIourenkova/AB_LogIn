package alphaBank.logIn.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alphaBank.logIn.dto.ResponseLoginDto;
import alphaBank.logIn.service.ILoginService;

@RestController
@RequestMapping("/alphaBank")
public class LogInController {
	
	ILoginService service;
	
	@Autowired
	public LogInController(ILoginService service) {
		this.service = service;
	}


	@PostMapping("/signIn/{id}/{password}")
	public ResponseLoginDto logIn(@PathVariable String id, @PathVariable String password ) {
		return service.login(id, password);
	}
	
	@GetMapping("/balance/id/{id}")
	public int getBalance(@PathVariable String id) {
		return service.getBalance(id);
	}
	

}
