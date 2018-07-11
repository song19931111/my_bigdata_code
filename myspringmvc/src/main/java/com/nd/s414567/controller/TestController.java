package com.nd.s414567.controller;

import com.nd.s414567.annotation.AnnoController;
import com.nd.s414567.annotation.AnnoQualifier;
import com.nd.s414567.annotation.AnnoRequestMapping;
import com.nd.s414567.annotation.AnnoRequestParam;
import com.nd.s414567.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
@AnnoController
@AnnoRequestMapping("/test")
public class TestController {

    @AnnoQualifier("testService")
    private TestService testService;
    @AnnoRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response, @AnnoRequestParam(value = "name")String name ,@AnnoRequestParam(value="age")String age ) throws IOException {

        String query = testService.query(name, age);
        response.getWriter().write(query);
    }
}
