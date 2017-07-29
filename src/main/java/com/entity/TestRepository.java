package com.entity;

/**
 * Created by tony.duan on 4/22/17.
 */
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LYJ on 2016/9/27.
 */
public interface TestRepository extends JpaRepository<Test,Integer> {
    Test findByName(String userName);
}
