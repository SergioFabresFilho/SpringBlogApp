package br.com.sergio.blog.ui.controller;

import br.com.sergio.blog.io.entity.UserEntity;
import br.com.sergio.blog.service.PostService;
import br.com.sergio.blog.service.UserService;
import br.com.sergio.blog.shared.dto.PostDTO;
import br.com.sergio.blog.ui.model.request.PostRequestModel;
import br.com.sergio.blog.ui.model.response.PostRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}")
    public PostRest getPost(@PathVariable String id) {
        PostRest returnValue = new PostRest();

        PostDTO postDTO = postService.getPost(id);
        BeanUtils.copyProperties(postDTO, returnValue);

        return returnValue;
    }

    @PostMapping
    public PostRest createPost(@RequestBody PostRequestModel requestModel) throws RuntimeException {
        PostRest returnValue = new PostRest();

        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(requestModel, postDTO);

        PostDTO createdPost = postService.createPost(postDTO);
        BeanUtils.copyProperties(createdPost, returnValue);

        return returnValue;
    }
}
