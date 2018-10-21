package edu.uddp.service;

import edu.uddp.model.FeedbackPost;

import java.util.List;

public interface FeedbackPostsService {
    List<FeedbackPost> selectPosts();
}
