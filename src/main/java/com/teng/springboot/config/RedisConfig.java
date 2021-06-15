package com.teng.springboot.config;

import com.teng.springboot.bean.Department;
import com.teng.springboot.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author shkstart
 * @create 2021-06-15 20:22
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Primary
    @Bean
    public RedisCacheManager empRedisCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(empRedisTemplate);
        redisCacheManager.setUsePrefix(true);

        return redisCacheManager;
    }


    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Bean
    public RedisCacheManager deptRedisCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(deptRedisTemplate);
        redisCacheManager.setUsePrefix(true);

        return redisCacheManager;
    }
}
