package com.example.demo.service;

import com.example.demo.entity.UserDocument;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private UserSearchRepository userSearchRepository;

    public Users saveUser(Users user) {
        Users saved = userRepository.save(user);

        // convert sang UserDocument và lưu
        UserDocument doc = new UserDocument();
        doc.setId(saved.getId().toString());
        doc.setName(saved.getName());
        doc.setEmail(saved.getEmail());

        userSearchRepository.save(doc);

        return saved;
    }

    public List<UserDocument> search(String keyword) {
        List<UserDocument> docs = userSearchRepository.findByNameContaining(keyword);

        return docs;
    }
}