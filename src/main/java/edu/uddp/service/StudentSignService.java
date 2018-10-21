package edu.uddp.service;

import edu.uddp.vo.ResponseData;
import java.util.*;
public interface StudentSignService {
    ResponseData signHistory(List<String> lessonList,int page,int rows);
}
