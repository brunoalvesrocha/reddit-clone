package com.reddit.clone.redditapi.repository;

import com.reddit.clone.redditapi.model.Post;
import com.reddit.clone.redditapi.model.User;
import com.reddit.clone.redditapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}