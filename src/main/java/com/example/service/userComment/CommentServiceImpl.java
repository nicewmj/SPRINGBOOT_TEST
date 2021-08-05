package com.example.service.userComment;

import com.example.entity.Comment;
import com.example.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllCommentsByTargetId(Integer targetId) {
        Comment comment = new Comment();
        comment.setTargetId(targetId);

        /*Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("targetId", targetId);设置条件
        example.setOrderByClause("id asc"); id 排序*/

        List<Comment> commentList = commentMapper.selectByExample(comment);

        return commentList;
    }
}
