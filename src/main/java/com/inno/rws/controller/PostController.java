package com.inno.rws.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.rws.model.service.post.PostService;
import com.inno.rws.model.vo.PostVO;
import com.inno.rws.model.vo.ResultVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value="게시글 조회", notes="아이디로 게시글 조회")
    @GetMapping("/posts/{crtId}")
    public ResultVO posts(@PathVariable String crtId) {
        return postService.selectPostList(crtId);
    }
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @PostMapping("/post")
    public ResultVO post(PostVO postVO) {
        return postService.insertPost(postVO);
    }
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @GetMapping("/post/{postId}")
    public ResultVO getPost(@PathVariable int postId) {
        return postService.selectPost(postId);
    }
    
    @DeleteMapping("/post/{postId}")
    public ResultVO deletePost(@PathVariable int postId) {
        return postService.deletePost(postId);
    }
    
    @PutMapping("/post")
    public ResultVO updatePost(PostVO postVO) {
        return postService.updatePost(postVO);
    }
}
