package alphaBank.logIn.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import alphaBank.logIn.model.AccountEntity;

public interface AccountMongoRepository extends MongoRepository<AccountEntity, String> {

}
