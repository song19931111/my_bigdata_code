package com.nd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * describe:对非Controller层进行Bean注入:
 *
 * @author nd.414567
 * @date 2018/07/03
 */
@ComponentScan(value="com.nd",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class RootConfig {
}
