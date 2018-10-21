package edu.uddp.service;

import edu.uddp.mapper.FeedbackPostMapper;
import edu.uddp.model.FeedbackPost;
import edu.uddp.model.FeedbackPostExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-22
 **/
@Service
public class FeedbackPostsServiceImpl implements FeedbackPostsService {
    @Autowired
    FeedbackPostMapper feedbackPostMapper;

    @Override
    public List<FeedbackPost> selectPosts() {
        FeedbackPostExample example = new FeedbackPostExample();
        return feedbackPostMapper.selectByExample(example);
    }
}
