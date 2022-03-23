package com.example.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookMapper;
import com.example.domain.Book;
import com.example.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public /* Boolean */ void save(Book book) {
        // * Auto-generated method stub
        // return bookMapper.insert(book) > 0;
        bookMapper.save(book);
    }

    @Override
    public /* Boolean */ void update(Book book) {
        // * Auto-generated method stub
        // return bookMapper.updateById(book) > 0;
        bookMapper.update(book);
    }

    @Override
    public /* Boolean */ void delete(Integer id) {
        // * Auto-generated method stub
        // return bookMapper.deleteById(id) > 0;
        bookMapper.delete(id);
    }

    @Override
    public Book getById(Integer id) {
        // * Auto-generated method stub
        // return bookMapper.selectById(id);
        return bookMapper.getById(id);
    }

    @Override
    public List<Book> getAll() {
        // * Auto-generated method stub
        // return bookMapper.selectList(null);
        return bookMapper.getAll();
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        // * Auto-generated method stub
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        return bookMapper.selectPage(page, null);
    }
}
