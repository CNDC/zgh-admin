package com.uintell.demo.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro配置
 */
@Configuration
public class ShiroConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(AuthRealm authRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/user/page");

        //oauth过滤
        /*Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", new OAuth2Filter());
		shiroFilter.setFilters(filters);*/

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login/*", "anon");
        filterMap.put("/error", "anon");
        filterMap.put("/api/**", "anon");
        filterMap.put("/**/*.css", "anon");
        filterMap.put("/**/*.js", "anon");
        filterMap.put("/**/*.png", "anon");
        filterMap.put("/**/*.jpg", "anon");
        filterMap.put("/**/*.html", "anon");
        filterMap.put("/**/*.html", "anon");
        filterMap.put("/*/images/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/plugins/**", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        LOGGER.info("-------------shiro已经加载---------------");
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
