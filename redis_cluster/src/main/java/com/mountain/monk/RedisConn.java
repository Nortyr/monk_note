package com.mountain.monk;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RedisConn {
    public static void main(String[] args) {
        //连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(5);
        //哨兵信息
        Set<String> sentinels = new HashSet<String>(Arrays.asList(
                "192.168.2.211:26379",
                "192.168.2.212:26379",
                "192.168.2.213:26379"
        ));
        //创建连接池
        //mymaster是我们配置给哨兵的服务名称
        //sentinels是哨兵信息
        //jedisPoolConfig是连接池配置
        //abcdefg是连接Redis服务器的密码
        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig, "123456");
        //获取客户端
        Jedis jedis = pool.getResource();
        //执行两个命令
        jedis.set("kafka", "kangll");
        String myvalue = jedis.get("kafka");
        //打印信息
        System.out.println(myvalue);




    }
}
