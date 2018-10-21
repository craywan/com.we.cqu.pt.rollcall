package edu.uddp.service;

import edu.uddp.model.Lessons;
import edu.uddp.vo.ResponseData;

import java.util.List;

public interface LuceneSerchService {
    ResponseData serchCourses(String serchContext);
}
