package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.Result;
import com.example.domain.Book;
import com.example.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
// import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        if (book.getName().equals("123"))
            flag = false;
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Book book) throws IOException {
        boolean flag = bookService.updateById(book);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new Result(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    // @GetMapping("{currentPage}/{pageSize}")
    // public Result getPage(@PathVariable int currentPage, @PathVariable int
    // pageSize) {
    // IPage<Book> page = bookService.getPage(currentPage, pageSize);
    // // 如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
    // if (currentPage > page.getPages()) {
    // page = bookService.getPage((int) page.getPages(), pageSize);
    // }
    // return new Result(true, page);
    // }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,
            Book book) {
        // System.out.println("参数==>"+book);

        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new Result(true, page);
    }
}
