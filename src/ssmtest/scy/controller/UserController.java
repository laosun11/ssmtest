package ssmtest.scy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ssmtest.scy.pojo.User;
import ssmtest.scy.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService service;
	
	@RequestMapping("user/list.do")
	public String list(Model m,@RequestParam Map<String,Object> params){
		List<User> list=service.find(params);
		m.addAttribute("list", list);
		return "user/list";
	}
	@RequestMapping("user/load.do")
	public String load(Model m,@RequestParam Map<String,Object> params){
		List<User> list=service.find(params);
		m.addAttribute("list", list);
		return "user/load";
	}
	@RequestMapping("user/goadd.do")
	public String goadd(Model m){
		return "user/add";
	}
	
	@RequestMapping(value="user/save.do")
	@ResponseBody
	public void save(@RequestBody User u){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			service.save(u);
			result.put("ok", true);
			result.put("msg", "保存成功！");
		} catch (Exception e) {
			result.put("ok", false);
			result.put("msg", e.getMessage());
		}
	}
}
