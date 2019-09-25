package shoponline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shoponline.constant.Constant;
import shoponline.dto.MyUser;
import shoponline.entity.RoleEntity;
import shoponline.entity.UserEntity;
import shoponline.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//AUTHENTICATION
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, Constant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		//getListRole
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		MyUser user = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, 
							 true, true, true, authorities);
		user.setUserName(userEntity.getFullName());
		return user;
	}

	
}
