package com.example.mapper;

import com.example.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户评论 mapper
 */
@Component
public interface CommentMapper {

    List<Comment> selectByExample(Comment comment);
}