package com.liang.girl.repository;

import com.liang.girl.domin.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * liangbingtian
 * 2018/7/14 下午1:47
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

     List<Girl> findByAge(Integer age);

}
