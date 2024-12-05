package com.scaler.productservicejune24.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration // when app will start spring will create all the bean methods
public class ApplicationConfig
{
    @Bean // Spring will create only one object in the IOC
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate(); // This class is used for HTTP call
    }
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
