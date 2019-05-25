/**
 * 
 */
package com.zjh.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjh.dubbo.api.service.DemoService;

/**
 * @author Thunisoft
 *
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
