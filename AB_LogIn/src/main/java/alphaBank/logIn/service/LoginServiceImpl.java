package alphaBank.logIn.service;

import org.modelmapper.ModelMapper;

import alphaBank.logIn.dao.AccountMongoRepository;
import alphaBank.logIn.dto.ResponseLoginDto;
import alphaBank.logIn.model.AccountEntity;

public class LoginServiceImpl implements ILoginService {
	
	AccountMongoRepository accountRepository;
	ModelMapper modelMapper;

	@Override
	public ResponseLoginDto login(String loginId) {
		AccountEntity account = accountRepository.findById(loginId).orElseThrow(() -> new RuntimeException("User with "+loginId+" not found"));
		
		return modelMapper.map(account, ResponseLoginDto.class);
		
	}

}
