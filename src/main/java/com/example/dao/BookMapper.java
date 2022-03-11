package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Book;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    // @Select("select * from books where bid=#{id}")
    // public Books getById(Integer id);
}
