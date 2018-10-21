package edu.uddp.controller;

import edu.uddp.service.LuceneSerchService;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Api(tags="搜索API")
@Controller
@RequestMapping("/luceneSerch")
public class LuceneSerchController {

    @Resource
    private LuceneSerchService luceneSerchService;
    @ApiOperation(value="搜索")
    @RequestMapping("/serchCourses/{serchContext}")
    @ResponseBody
    @ApiImplicitParam(name="serchContext",value="搜索内容")
    public ResponseData sercheCourses(@PathVariable(required = false) String serchContext){
            if(serchContext.isEmpty()){
                return ResponseUtil.setResponse(5003,"输入内容为空",null);
            }
      return  luceneSerchService.serchCourses(serchContext);
    }
}
