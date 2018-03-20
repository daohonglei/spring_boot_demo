package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;

@RestController
public class GreetingController {

    @RequestMapping(value = "/demo1/student", method = RequestMethod.POST)
    public void addStudent(Student student) {
        System.out.println(student);
        System.out.println("添加成功");
    }

    @RequestMapping(value = "/demo1/student", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student) {
        System.out.println(student);
        System.out.println("更新成功");
    }

    @RequestMapping(value = "/demo1/student", method = RequestMethod.GET)
    public Student getAtudentById(String id) {
        System.out.println("接收到的的参数" + id);
        Student s = new Student();
        s.setId("12");
        s.setName("google");
        s.setAge(12);
        return s;
    }


    @RequestMapping(value = "/demo1/student/{id}", method = RequestMethod.GET)
    public void delStudent(@PathVariable("id") int id) {
       System.out.println(id);
        System.out.println("删除成功");
    }

}