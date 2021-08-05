package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@Table(name = "t_comment")
public class Comment {
    /**
     * 评论id
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 所属一级评论的id，如果当前评论为一级，则为0
     */
    private Integer pid;

    /**
     * 评论所属文章id
     */
//    @Column(name = "target_id")
    private Integer targetId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 该条评论的作者
     */
//    @Column(name = "user_id")
    private String userId;

    /**
     * 对谁回复，一级评论可以为null
     */
//    @Column(name = "to_user_id")
    private String toUserId;

    /**
     * 当前评论的点赞数
     */
//    @Column(name = "likes_count")
    private Integer likesCount;

    /**
     * 创建时间
     */
//    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
//    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 该评论下的回复，非数据库字段，用 @Transient
     */
//    @Transient
    private List<Comment> replies = new ArrayList<>();
}