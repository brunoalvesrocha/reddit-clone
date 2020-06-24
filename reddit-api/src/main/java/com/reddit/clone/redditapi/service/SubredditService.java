package com.reddit.clone.redditapi.service;

import com.reddit.clone.redditapi.dto.SubredditDTO;
import com.reddit.clone.redditapi.model.Subreddit;
import com.reddit.clone.redditapi.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;

    @Transactional
    public SubredditDTO save(SubredditDTO subredditDTO) {
        Subreddit subredditSaved = subredditRepository.save(mapSubredditDTO(subredditDTO));
        subredditDTO.setId(subredditSaved.getId());
        return subredditDTO;
    }

    @Transactional(readOnly = true)
    public List<SubredditDTO> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(this::mapToDTO)
        .collect(Collectors.toList());
    }

    private SubredditDTO mapToDTO(Subreddit subreddit) {
        return SubredditDTO.builder()
                .name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }

    private Subreddit mapSubredditDTO(SubredditDTO subredditDTO) {
        return Subreddit.builder()
                .name(subredditDTO.getName())
                .description(subredditDTO.getDescription())
                .build();
    }

}
