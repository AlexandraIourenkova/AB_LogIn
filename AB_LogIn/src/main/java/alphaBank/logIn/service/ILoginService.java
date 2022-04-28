package alphaBank.logIn.service;

import alphaBank.logIn.dto.ResponseLoginDto;

public interface ILoginService {

	public ResponseLoginDto login(String login, String password);

	public int getBalance(String id);
	
}
