package com.uintell.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by chen on 2017/10/22.
 */
@Controller
@RestController
public class IndexController extends BaseController {

    @RequestMapping("/error500")
    public void index1() {
        int a = 1 / 0;
        System.out.println(a);
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index_tab")
    public String index_tab() {
        return "index_tab";
    }


    /**
     * 获取菜单
     * @param session
     * @return
     */
    /*@ResponseBody
    @RequestMapping("getMenues")
	public ResultData getMenues(HttpSession session) {
		List<MenuVO> menuVOList = (List<MenuVO>) session.getAttribute("menus");
		return success(menuVOList);
	}*/

}
