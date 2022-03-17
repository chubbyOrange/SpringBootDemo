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
    public Boolean delete(Integer id) {
        // TODO Auto-generated method stub
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        // TODO Auto-generated method stub
        return bookMapper.selectList(null);
    }

    @Override
    public Book getById(Integer id) {
        // TODO Auto-generated method stub
        return bookMapper.selectById(id);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        // TODO Auto-generated method stub
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        return bookMapper.selectPage(page, null);
    }

    @Override
    public Boolean save(Book book) {
        // TODO Auto-generated method stub
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        // TODO Auto-generated method stub
        return bookMapper.updateById(book) > 0;
    }

}
