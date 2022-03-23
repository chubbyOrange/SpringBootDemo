package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookMapper;
import com.example.domain.Book;
import com.example.service.IBookService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl2 extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        // * Auto-generated method stub
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        // * Auto-generated method stub
        LambdaQueryWrapper<Book> lQueryWrapper = new LambdaQueryWrapper<Book>();
        lQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lQueryWrapper.like(Strings.isNotEmpty(book.getTitle()), Book::getTitle, book.getTitle());
        lQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        bookMapper.selectPage(page, lQueryWrapper);
        // System.out.println("BookServiceImpl2 Called.");
        return page;
    }
}
