package com.example.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Book;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Insert("insert into books values(#{name},#{title},#{description})")
    public void save(Book book);

    @Update("update books set name=#{name}, title=#{title}, description=#{description} where bid=#{bid}")
    public void update(Book book);

    @Delete("delete from books where bid=#{bid}")
    public void delete(Integer id);

    @Select("select * from books where bid=#{id}")
    public Book getById(Integer id);

    @Select("select * from books")
    List<Book> getAll();
}
