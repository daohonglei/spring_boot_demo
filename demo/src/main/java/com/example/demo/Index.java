/**@date 2018年3月15日上午11:49:27
  *@email 858883986@qq.com
  *@author ldh
*/

package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
