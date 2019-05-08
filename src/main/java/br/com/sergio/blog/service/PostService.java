package br.com.sergio.blog.service;

import br.com.sergio.blog.io.entity.UserEntity;
import br.com.sergio.blog.shared.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostDTO getPost(String postId);
    List<PostDTO> getAllByAuthor(UserEntity userEntity);
    PostDTO updatePost(String postId, PostDTO postDTO);
    void  deletePost(String postId);
}
