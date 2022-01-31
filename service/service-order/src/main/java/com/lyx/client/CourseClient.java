package com.lyx.client;

import com.lyx.entity.CourseInfoOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author liao 2021/10/30
 */
@FeignClient(name = "service-edu")
@Component
public interface CourseClient {

    @PostMapping("/eduservice/courseFront/{id}")
    public CourseInfoOrderVo getCourseOrderInfoById(@PathVariable String id);

}
