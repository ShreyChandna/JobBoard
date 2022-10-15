package com.job.board.config;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.job.board.dao.UserRepository;
import com.job.board.entities.Users;




public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user from database
		Users user=userRepository.getUsersByuserName(username);
		if(user==null) 
		{
			throw new UsernameNotFoundException("could not find user!!");
		}
		CustomUserDetails customAdminDetails=new CustomUserDetails(user);  
		return customAdminDetails;
	}

}


