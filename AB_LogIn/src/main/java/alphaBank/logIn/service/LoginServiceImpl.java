package alphaBank.logIn.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alphaBank.logIn.dao.AccountMongoRepository;
import alphaBank.logIn.dto.ResponseLoginDto;
import alphaBank.logIn.model.AccountEntity;

@Service
public class LoginServiceImpl implements ILoginService {
	
	AccountMongoRepository accountRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public LoginServiceImpl(AccountMongoRepository accountRepository, ModelMapper modelMapper) {
		this.accountRepository = accountRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseLoginDto login(String id, String password) {
		AccountEntity user = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("id " + id + " not found"));
		if (!user.getPasswordEncoded().equals(password)) {
			throw new RuntimeException("wrong password");
		}
		ResponseLoginDto response = new ResponseLoginDto("ok");
		return response;
	}

	@Override
	public int getBalance(String id) {
		return accountRepository.findById(id).orElseThrow(()-> new RuntimeException(id + " not found")).getBalance();
	}

	

}
