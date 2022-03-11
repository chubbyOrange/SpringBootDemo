package com.example.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}
