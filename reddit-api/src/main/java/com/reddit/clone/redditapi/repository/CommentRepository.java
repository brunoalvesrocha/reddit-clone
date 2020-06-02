package com.reddit.clone.redditapi.repository;

import com.reddit.clone.redditapi.model.Comment;
import com.reddit.clone.redditapi.model.Post;
import com.reddit.clone.redditapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}