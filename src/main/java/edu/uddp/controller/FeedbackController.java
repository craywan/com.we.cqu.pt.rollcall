package edu.uddp.controller;

import edu.uddp.model.FeedbackPost;
import edu.uddp.service.FeedbackPostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-22
 **/
@Api(description = "反馈")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackPostsService feedbackPostsService;

    @ApiOperation(value = "反馈栏的公告")
    @GetMapping("/posts")
    public Map<String, Object> feedbackPost(){
        Map<String, Object> res = new HashMap<>();
        List<FeedbackPost> feedbackPosts = feedbackPostsService.selectPosts();
        res.put("data",feedbackPosts);
        res.put("message", "ok");
        res.put("status", 200);
        return res;
    }
}
