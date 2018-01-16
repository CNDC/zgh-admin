package com.uintell.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by chen on 2017/10/22.
 */
@Controller
@RequestMapping("/index/")
public class IndexController extends BaseController {

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
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

    @RequestMapping("main")
    public String main(Model model) {

        return "main";
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
