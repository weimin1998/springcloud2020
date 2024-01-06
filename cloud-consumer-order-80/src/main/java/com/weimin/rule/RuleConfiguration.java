package com.weimin.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfiguration {

//    切换访问规则
    // 默认是轮询
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
