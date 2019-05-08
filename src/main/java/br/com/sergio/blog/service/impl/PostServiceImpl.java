package br.com.sergio.blog.service.impl;

import br.com.sergio.blog.io.entity.PostEntity;
import br.com.sergio.blog.io.entity.UserEntity;
import br.com.sergio.blog.io.repository.PostRepository;
import br.com.sergio.blog.service.PostService;
import br.com.sergio.blog.shared.Utils;
import br.com.sergio.blog.shared.dto.PostDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    Utils utils;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        BeanUtils.copyProperties(postDTO, postEntity);

        String publicPostId = utils.generateUserId(30);
        postEntity.setPostId(publicPostId);

        postEntity.setAuthor(utils.getAuthenticatedUser());

        PostEntity storedPostDetaails = postRepository.save(postEntity);

        PostDTO returnValue = new PostDTO();
        BeanUtils.copyProperties(storedPostDetaails, returnValue);

        return returnValue;
    }

    @Override
    public PostDTO getPost(String postId) {
        PostEntity postEntity = postRepository.findByPostId(postId);

        if (postEntity == null) {
            throw new RuntimeException("No posts found");
        }

        PostDTO returnValue = new PostDTO();
        BeanUtils.copyProperties(postEntity, returnValue);

        return returnValue;
    }

    @Override
    public List<PostDTO> getAllByAuthor(UserEntity userEntity) {
        List<PostDTO> returnValue = new ArrayList<>();
        PostDTO addingValue = new PostDTO();

        for (PostEntity post : postRepository.findAllByAuthor(userEntity)) {
            BeanUtils.copyProperties(post, addingValue);
            returnValue.add(addingValue);
        }

        return returnValue;
    }

    @Override
    public PostDTO updatePost(String postId, PostDTO postDTO) {
        PostDTO returnValue = new PostDTO();
        PostEntity postEntity = postRepository.findByPostId(postId);

        if (postEntity == null) {
            throw new RuntimeException("No posts found");
        }

        postEntity.setTitle(postDTO.getTitle());
        postEntity.setText(postDTO.getText());

        PostEntity updatedPostDetails = postRepository.save(postEntity);
        BeanUtils.copyProperties(updatedPostDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deletePost(String postId) {
        PostEntity postEntity = postRepository.findByPostId(postId);

        if (postEntity == null) {
            throw new RuntimeException("No posts found");
        }

        postRepository.delete(postEntity);
    }
}
