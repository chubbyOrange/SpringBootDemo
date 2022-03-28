package com.example;

// import java.io.File;
// import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

class JsonTest {

    // Java对象转为JSON字符串
    @Test
    void test01() throws IOException {
        // 1.创建Book对象
        Book book = new Book();
        book.setbid("201");
        book.setName("余华");
        book.setTitle("活着");
        book.setPrice(59.7f);
        book.setyear(new Date());
        book.setDescription("生的苦难与伟大");

        // 2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 3.转换
        String json = mapper.writeValueAsString(book);

        // *{"bid":"201","name":"余华","title":"活着","price":59.7,"year":2012,"description":"生的苦难与伟大"}
        System.out.println(json);

        // * writeValue将数据写到a.txt文件中
        // mapper.writeValue(new
        // File("E:\\apache-tomcat-9.0.56\\webapps\\ajax-demo\\a.txt"), book);

        // * writeValue将数据关联到Writer中
        // mapper.writeValue(new
        // FileWriter("E:\\apache-tomcat-9.0.56\\webapps\\ajax-demo\\b.txt"), book);
    }

    @Test
    public void test02() throws IOException {
        Student p1 = new Student();
        p1.setId(1l);
        p1.setName("张三");
        p1.setEmail("san.zhang@seaboxdata.com");
        p1.setAge(23);

        Student p2 = new Student();
        p2.setId(2l);
        p2.setName("李四");
        p2.setEmail("si.li@seaboxdata.com");
        p2.setAge(24);

        Student p3 = new Student();
        p3.setId(3l);
        p3.setName("王五");
        p3.setEmail("wu.wang@seaboxdata.com");
        p3.setAge(25);

        // 1.创建List集合
        ArrayList<Student> students = new ArrayList<>();
        students.add(p1);
        students.add(p2);
        students.add(p3);

        // 2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(students);

        // [{"id":1,"name":"张三","email":"san.zhang@seaboxdata.com","age":23},{"id":2,"name":"李四","email":"si.li@seaboxdata.com","age":24},{"id":3,"name":"王五","email":"wu.wang@seaboxdata.com","age":25}]
        System.out.println(json);
    }

    @Test
    public void test03() throws IOException {
        // 1.创建map对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");

        // 2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);
    }

    // JSON字符串转为Java对象
    @Test
    public void test5() throws IOException {
        // 1.初始化JSON字符串
        String json = "{\"id\":1,\"name\":\"张三\",\"email\":\"san.zhang@seaboxdata.com\",\"age\":23}";

        // 2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        // 3.转换为Java对象 Person对象
        Student student = mapper.readValue(json, Student.class);

        System.out.println(student);
    }
}
