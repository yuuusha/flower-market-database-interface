package com.yusha.flowermarket.service;

import java.util.ArrayList;
import java.util.List;

import com.yusha.flowermarket.dto.UserCredentials;
import com.yusha.flowermarket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserCredentials authUserInfo = usersRepository.findByLogin(username);

        List<String> roles = new ArrayList<>();
        roles.add("USER");
        if (authUserInfo.isAdmin()) {
            roles.add("ADMIN");
        }

        return User
                .withUsername(authUserInfo.user_login())
                .password(authUserInfo.user_password())
                .roles(roles.toArray(new String[0]))
                .build();
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY
//        // ROLE_ADMIN, ROLE_USER - это роли
//        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
//    }

}
