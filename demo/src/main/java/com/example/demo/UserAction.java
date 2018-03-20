/**@date 2018年3月15日下午12:35:28
  *@email 858883986@qq.com
  *@author ldh
*/

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pojo.User;

@Controller
@RequestMapping("/user")
public class UserAction {
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String user(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "userlist";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		model.addAttribute("method","/user/add");
		return "user";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(Model model,@PathVariable("id") int id) {
		System.out.println(id);
		User u = new User();
		u.setAge(18);
		u.setName("233");
		model.addAttribute("user", u);
		model.addAttribute("method","/user/update");
		return "user";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return "redirect:/user/users";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int idd) {
		System.out.println(idd);
		return "redirect:/user/users";
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "test";
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}
