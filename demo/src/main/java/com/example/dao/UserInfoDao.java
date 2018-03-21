package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.security.SecurityUser;

public class UserInfoDao {
	public SecurityUser getDatabase(String username) {
		List<SecurityUser> users = internalDatabase();
		for (SecurityUser dbUser : users) {
			if (dbUser.getUsername().equals(username) == true) {
				return dbUser;
			}
		}
		throw new RuntimeException("User does not exist!");
	}

	/**
	 * 初始化数据
	 */
	private List<SecurityUser> internalDatabase() {

		List<SecurityUser> users = new ArrayList<SecurityUser>();
		SecurityUser user = null;

		user = new SecurityUser(1,"admin","6d789d4353c72e4f625d21c6b7ac2982",true,1);
		users.add(user);

		
		user =new SecurityUser(2,"user","36f1cab655c5252fc4f163a1409500b8",true,2);
		users.add(user);

		return users;

	}
}
