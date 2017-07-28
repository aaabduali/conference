package com.officemanagement.service;


import com.officemanagement.model.Role;
import com.officemanagement.model.Users;
import com.officemanagement.repository.RoleRepository;
import com.officemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setActive(true);
        Role role=roleRepository.findByRole("ADMIN");
        users.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(users);

    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users=userRepository.findByEmail(userName);
        List<GrantedAuthority> authorities=getUserAuthority(users.getRoles());
        return buildUserForAuthentication(users,authorities);
    }
    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles)
    {
        Set<GrantedAuthority> roles=new HashSet<GrantedAuthority>();
        for (Role role: userRoles){
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>(roles);
        return grantedAuthorities;
    }
    private UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities)
    {
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.isActive(),true,true,true,authorities);
    }
}
