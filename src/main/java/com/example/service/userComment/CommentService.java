package com.example.service.userComment;

import com.example.entity.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> getAllCommentsByTargetId(Integer targetId);
}