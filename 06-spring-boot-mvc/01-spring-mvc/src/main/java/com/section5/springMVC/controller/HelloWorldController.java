package com.section5.springMVC.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    // @RequestMapping("/showform")
    // public String showForm(){
    //     return "helloworld-form";
    // }
     @GetMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processformVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String result = "Yo! "+ name;

        model.addAttribute("message", result);
        
        return "helloworld";

    }

    @PostMapping("/processformVersionThree")
    public String processformVersionThree(@RequestParam("studentName") String name, Model model){

        

        name = name.toUpperCase();

        String result = "Yo! "+ name;

        model.addAttribute("message", result);
        
        return "helloworld";

    }


    // @RequestMapping("/processformVersionThree")
    // public String processformVersionThree(@RequestParam("studentName") String name, Model model){

        

    //     name = name.toUpperCase();

    //     String result = "Yo! "+ name;

    //     model.addAttribute("message", result);
        
    //     return "helloworld";

    // }

}
