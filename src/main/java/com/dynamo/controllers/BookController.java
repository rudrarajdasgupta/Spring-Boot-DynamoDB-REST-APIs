package com.dynamo.controllers;

import java.util.List;

import com.dynamo.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamo.models.Book;

@RestController
@RequestMapping("/book")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book){
        logger.info("save book " + this.getClass().getName());
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable(value = "id") String id){
        logger.info("find book by id" + this.getClass().getName());
        return bookService.findById(id);
    }

    @GetMapping
    public List<Book> findAll(){
        logger.info("findAll books " + this.getClass().getName());
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id,
    @RequestBody Book book){
        logger.info("update book " + this.getClass().getName());
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id){
        logger.info("Edit Configurations… book " + this.getClass().getName());
        return bookService.delete(id);
    }
}