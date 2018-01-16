package com.uintell.demo.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author admin
 * @date 2018/1/3 14:17
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cache")
public class RedisProperties {
    private String clusterNodes;
    private Integer commandTimeout;

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public Integer getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(Integer commandTimeout) {
        this.commandTimeout = commandTimeout;
    }
}

