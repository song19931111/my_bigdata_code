package com.nd.s414567.service;

import com.nd.s414567.annotation.AnnoService;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */

@AnnoService("testService")
public class TestService {

    public String query(String name,String age){
        return "success";

    }
}
