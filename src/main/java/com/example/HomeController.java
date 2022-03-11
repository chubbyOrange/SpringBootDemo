package com.example;

import com.example.dao.BookMapper;
// import com.example.service.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${country}")
    private String country;

    @Value("${user1.name}")
    private String name;

    @Value("${hobbies[2]}")
    private String hobby;

    @Value("${tempDir}")
    private String tempDir;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @Autowired
    private BookMapper booksMapper;

    @GetMapping
    public String home() {
        System.out.println(country + " " + name + " " + hobby + " " + tempDir);
        System.out.println(env.getProperty("server.port"));
        System.out.println(myDataSource);
        System.out.println(booksMapper.selectById(201));
        return "你好，欢迎使用Visual Studio Code!";
    }
}
