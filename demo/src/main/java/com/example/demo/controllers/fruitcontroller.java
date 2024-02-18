package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Fruit;
import com.example.demo.repository.FruitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;






@RestController
@RequestMapping("/fruits")
public class fruitcontroller {
    @Autowired
    private FruitRepository FruitRepository;

    @GetMapping("")
    public ModelAndView getfruits(){
        ModelAndView mav = new ModelAndView("list.html");
        List<Fruit> fruits=this.FruitRepository.findAll();
        mav.addObject("fruits", fruits);
        return mav;
    }
    
    @GetMapping("add-fruit")
    public ModelAndView addfruit() {
        ModelAndView mav = new ModelAndView("add-fruit.html");
        Fruit fruit = new Fruit();
        mav.addObject("fruit", fruit);
        return mav;
    }

    @SuppressWarnings("null")
    @PostMapping("save-fruit")
    public ModelAndView savefruit(@ModelAttribute Fruit fruit) {
        this.FruitRepository.save(fruit);
        return new ModelAndView("redirect:/fruits");
    }
    
    
    
    
}
