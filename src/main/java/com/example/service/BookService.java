package com.example.service;

// import java.util.List;

// import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {
    // Boolean save(Book book);

    // Boolean update(Book book);

    // Boolean delete(Integer id);

    void save(Book book);

    void update(Book book);

    void delete(Integer id);

    Book getById(Integer id);

    PageInfo<Book> getAll(int currentPage, int pageSize);

    // IPage<Book> getPage(int currentPage, int pageSize);
}
