package com.example.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.UserInfoDao;

public class CustomUserDetailsService implements UserDetailsService {
    //@Autowired  //数据库服务类
    //private SUserService suserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
    	SecurityUser user =new UserInfoDao().getDatabase(userName); 
    	System.out.println(userName);

        if (user==null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        SecurityUser securityUser = new SecurityUser(user.getId(),user.getUsername(), user.getPassword().toLowerCase(),user.isEnabled(),getAuthorities(user.getAccess()));
        System.out.println(securityUser);
        return securityUser; 

    }
    
    /**
	 * 获得访问角色权限
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (access.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return authList;
	}

}