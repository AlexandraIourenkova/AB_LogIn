package alphaBank.logIn.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alphaBank.logIn.dto.ResponseLoginDto;
import alphaBank.logIn.service.ILoginService;

@RestController
@RequestMapping("/alphaBank")

public class LogInController {
	ILoginService service;
	
	@PostMapping("/signIn")
	public ResponseLoginDto logIn(Principal principal) {
		return service.login(principal.getName());
	}
	

}
