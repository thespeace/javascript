package com.example.mythymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/signup")
    public String signup(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "signup";
    }
    @PostMapping("/getUserInfo")
    public ModelAndView getUserInfo(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/main");

        try {
            HashMap<String, Object> map = new HashMap<>();

            map.put("id", req.getParameter("id"));
            map.put("pwd", req.getParameter("pwd"));
            map.put("email", req.getParameter("email"));
            map.put("addr1", req.getParameter("addr1"));
            map.put("addr2", req.getParameter("addr2"));
            map.put("addr3", req.getParameter("addr3"));
            System.out.println(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }

}
