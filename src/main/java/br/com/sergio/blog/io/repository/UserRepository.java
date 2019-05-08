package br.com.sergio.blog.io.repository;

import br.com.sergio.blog.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByUserId(String userId);
}
