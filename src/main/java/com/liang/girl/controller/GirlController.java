package com.liang.girl.controller;

import com.liang.girl.domin.Girl;
import com.liang.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * liangbingtian
 * 2018/7/14 下午1:44
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("list.do")
    public List<Girl> getList(){

        return girlRepository.findAll();
    }

    @PostMapping("add.do")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    @GetMapping("{id}/search.do")
    public Girl girlSearch(@PathVariable("id") Integer id){

        Girl girl = girlRepository.findOne(id);
        return girl;
    }

    @PostMapping("{id}/update.do")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setId(id);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping("{id}/delete.do")
    public void girlDelete(@PathVariable("id") Integer id){

        girlRepository.delete(id);
    }

    @GetMapping("{age}/searchByAge.do")
    public List<Girl> searchByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }
}
