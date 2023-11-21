package org.mehmetgenc.repository;

import org.mehmetgenc.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
