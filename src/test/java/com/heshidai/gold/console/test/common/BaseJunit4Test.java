package com.heshidai.gold.console.test.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试公共类
 * 
 * @version 2017年1月7日下午1:02:29
 * @author dx.love
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration({ "classpath*:/spring-mvc*.xml", "classpath*:/spring-context*.xml",
        "classpath*:/spring-dubbo*.xml" })
// 加载配置文件
public class BaseJunit4Test {
	

    
}
