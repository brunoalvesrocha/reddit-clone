package com.reddit.clone.redditapi.repository;

import com.reddit.clone.redditapi.model.Post;
import com.reddit.clone.redditapi.model.Subreddit;
import com.reddit.clone.redditapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}