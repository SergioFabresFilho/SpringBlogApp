package br.com.sergio.blog.io.repository;

import br.com.sergio.blog.io.entity.PostEntity;
import br.com.sergio.blog.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByAuthor(UserEntity userEntity);
    PostEntity findByPostId(String postId);
}
