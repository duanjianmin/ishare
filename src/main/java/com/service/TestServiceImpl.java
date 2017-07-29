package com.service;

import com.entity.Test;
import com.entity.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tony.duan on 4/22/17.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Override
    public String findTest(String name) {
        Test test = testRepository.findByName(name);;;
        return test.getName()+" -- "+test.getNumber();
    }
}
