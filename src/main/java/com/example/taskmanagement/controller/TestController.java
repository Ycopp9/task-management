package com.example.taskmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @PostMapping("/none")
    @ResponseBody
    public String none(TestObject object) {
        System.out.println(object);
        return "Success";
    }

    @PostMapping("/rp")
    @ResponseBody
    public String requestParam(@RequestParam TestObject object) {
        System.out.println(object);
        return "Success";
    }

    @PostMapping("/rp2")
    @ResponseBody
    public String requestParam2(@RequestParam Long id, String name) {
        System.out.println(id + ":" + name);
        return "Success";
    }

    @PostMapping("/rb")
    @ResponseBody
    public String requestBody(@RequestBody TestObject object) {
        System.out.println(object);
        return "Success";
    }

    @PostMapping("/ma")
    @ResponseBody
    public String modelAttribute(@ModelAttribute TestObject object, Model model) {
        System.out.println(object);
        System.out.println(model.asMap().keySet());
        return "Success";
    }
}
class TestObject {
    private Long id;
    private String name;

    public TestObject (Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}