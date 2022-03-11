package com.example.service.implement;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.IBookService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceImplTest2 {
    @Autowired
    private IBookService iBookService;
    Book books = new Book();

    @Test
    void testGetById() {
        System.out.println(iBookService.getById(201));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("Test");
        book.setPrice(40);
        book.setDescription("Test");
        iBookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setbid("208");
        book.setName("Testabc");
        book.setPrice(50);
        book.setDescription("Testabc");
        iBookService.updateById(book);
    }

    @Test
    void testDelete() {
        iBookService.removeById(208);
    }

    @Test
    void testGetAll() {
        iBookService.list();
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<Book>(2, 3);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
