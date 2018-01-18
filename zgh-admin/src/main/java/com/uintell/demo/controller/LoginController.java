package com.uintell.demo.controller;

import com.uintell.demo.redis.service.IRedisService;
import com.uintell.demo.service.MenuService;
import com.uintell.demo.utils.Constants;
import com.uintell.demo.utils.DESPcUtil;
import com.uintell.demo.utils.DateUtil;
import com.uintell.demo.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author admin
 * @date 2018/1/4
 */
@Controller
@RequestMapping("/user/")
public class LoginController extends BaseController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private IRedisService redisService;

    @Autowired
    private MenuService menuService;

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping("page/login")
    public String loginPage() {

        return "/page/login";
    }

    /**
     * 登录
     *
     * @param session
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Map<String, Object> login(String username, String password) {
        //参数的效验
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }
        Map<String, Object> resultMap = new LinkedHashMap<>();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录验证
        Subject currentUser = SecurityUtils.getSubject();
        //退出登录,防止未退出切换用户
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        try {
            currentUser.login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        } finally {
            //处理登录次数
            String key = Constants.RETRY_PRE + username;
            if (currentUser.isAuthenticated()) {
                //清除次数
                //清除验证码
                Session session = currentUser.getSession();
                session.removeAttribute(Constants.VERIFY_CODE);
                logger.info("[pc]{}登录成功", (Throwable) currentUser.getPrincipal());
                //更新session
                String uuid = UUID.randomUUID().toString();
                String currentTime = DateUtil.date2String(DateUtils.getCurrentDate(), DateUtil.DATE_PATTERN.YYYYMMDDHHMMSS);
                String csrftoken = DESPcUtil.encryption(uuid + currentTime, "cmosiegs");
                // session 中保存的是原始数据,给用户返回的是带时间戳的数据
                resetShiroSession(currentUser, uuid);
                //这里可以进行一些认证通过后的一些系统参数初始化操作
                resultMap.put("code", Constants.FRONT_SUCCESS);
                resultMap.put("message", "登录成功");
                resultMap.put("csrftoken", csrftoken);
            } else {
                //增加次数
                Long retryTimes = redisService.incr(key);
                //判断是否锁定
                String lockKey = Constants.LOCK_PRE + username;
                if (retryTimes == Constants.RETRY_LOCK24_LIMIT) {//锁定24小时
                    //redisCacheService.setex(lockKey, Constants.LOCK_STATUS, Constants.LOCK_24HORE);
                    //redisCacheService.expire(key, Constants.LOCK_24HORE);
                } else if (retryTimes == Constants.RETRY_LOCK1_LIMIT) {//锁定1小时
                    //redisCacheService.setex(lockKey, Constants.LOCK_STATUS, Constants.LOCK_1HORE);
                }
                //生成验证码字符串
                if (retryTimes >= Constants.RETRY_CODE_LIMIT) {
                    /*String[] imgCodes = getBase64ImgCode();
                    currentUser.getSession().setAttribute(Constants.VERIFY_CODE, imgCodes[0]); */
                    resultMap.put("imgCodeNeed", true);
                }
                token.clear();
            }
        }
        //获取菜单
        //if (session.getAttribute("menus") == null) {
        //List<MenuVO> menuVOList = menuService.getAuthMenus(admin.getId());
        //session.setAttribute("menus", menuVOList);
        //}
        //进行session的操作
        return resultMap;
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("loginOut")
    public Map<String, Object> loginOut(HttpSession session) {
        session.removeAttribute("admin");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return null;
    }

    /**
     * 更新session
     *
     * @param subject
     * @param csrftoken
     */
    private void resetShiroSession(Subject subject, String csrftoken) {
        //获取session数据
        Session session = subject.getSession();
        final LinkedHashMap<Object, Object> attributes = new LinkedHashMap<Object, Object>();
        final Collection<Object> keys = session.getAttributeKeys();
        for (Object key : keys) {
            final Object value = session.getAttribute(key);
            if (value != null) {
                attributes.put(key, value);
            }
        }
        session.stop();
        // 登录成功后复制session数据
        session = subject.getSession();
        for (final Map.Entry<Object, Object> entry : attributes.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }
        session.setAttribute("csrftoken", csrftoken);
    }

}
