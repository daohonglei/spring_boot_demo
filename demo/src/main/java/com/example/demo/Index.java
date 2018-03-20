/**@date 2018年3月15日上午11:49:27
  *@email 858883986@qq.com
  *@author ldh
*/

package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.User;

@RestController
public class Index {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/getUser")
	public User getUser() {
		User u=new User();
		u.setAge(18);
		u.setName("ldh");
		u.setBirthday(new Date());
		return u;
	}
}
