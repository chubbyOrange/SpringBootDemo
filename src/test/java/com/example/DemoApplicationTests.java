package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookMapper;
// import com.example.service.ShoppingCart;
import com.example.domain.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    Book books = new Book();

    @Test
    void contextLoads() {
        System.out.println(bookMapper.selectById(201));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("Test");
        book.setPrice(40);
        book.setDescription("Test");
        bookMapper.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setbid("207");
        book.setName("Testabc");
        book.setPrice(50);
        book.setDescription("Testabc");
        bookMapper.updateById(book);
    }

    @Test
    void testDelete() {
        bookMapper.deleteById(207);
    }

    @Test
    void testGetAll() {
        bookMapper.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<Book>(2, 3);
        bookMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
