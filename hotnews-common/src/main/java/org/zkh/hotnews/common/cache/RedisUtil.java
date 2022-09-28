package org.zkh.hotnews.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private final long defaultTime = 20;
    public boolean set(String key,Object value){
        try{
           // redisTemplate.opsForValue().set(key,value,defaultTime+ (long) (defaultTime*Math.random()),TimeUnit.HOURS);
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean set(String key,Object value,long time){
        try{
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean delete(String key){

        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

}