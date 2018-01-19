package com.uintell.demo.redis;

import com.uintell.demo.conf.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisUtil {
    private static RedisProperties redisProperties;

    @Autowired
    public JedisUtil(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    @Singleton
    public static JedisCluster getCluster() {
        String[] serverArray = redisProperties.getClusterNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes, redisProperties.getCommandTimeout());
    }
}
