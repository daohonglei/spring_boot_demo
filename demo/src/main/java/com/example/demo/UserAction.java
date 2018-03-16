/**@date 2018年3月15日下午12:35:28
  *@email 858883986@qq.com
  *@author ldh
*/

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.User;

@Controller
public class UserAction {
	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("name","ldh");
		User u = new User();
		model.addAttribute("user", u);
		return "user";
	}
	@RequestMapping("/postform")
	public String postform(User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return "redirect:/user";
	}
}
