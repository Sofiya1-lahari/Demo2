package com.javademo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeResource {
    

    Logger logger= LoggerFactory.getLogger(HomeResource.class);
    @RequestMapping("/")
    public String home()
    {
        logger.trace("Home method acceessed");
        return "hello";
    }
}
