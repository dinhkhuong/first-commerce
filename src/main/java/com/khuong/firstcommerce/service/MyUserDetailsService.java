package com.khuong.firstcommerce.service;

import com.khuong.firstcommerce.entities.MyUserDetails;
import com.khuong.firstcommerce.entities.Product;
import com.khuong.firstcommerce.entities.User;
import com.khuong.firstcommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new MyUserDetails(user);
    }

    public User loadUser(String username){
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }

    public void update(User user) {
        //List<Product> productlist1 = user.getProductList();
        //List<Product> productlist = (userRepository.findByUsername(user.getUsername())).getProductList();
        //productlist1.addAll(productlist);
        //user.setProductList(productlist1);
        userRepository.save(user);
    }

}
