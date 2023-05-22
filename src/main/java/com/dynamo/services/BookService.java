package com.dynamo.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynamo.models.Book;
import com.dynamo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book){
        logger.info("save book " + this.getClass().getName());
        return bookRepository.save(book);
    }

    public List<Book> saveAll(List<Book> bookList){
        logger.info("save books " + this.getClass().getName());
        return  bookRepository.saveAll(bookList);
    }

    public Book findById(String id){
        logger.info("find book by id" + this.getClass().getName());
        return bookRepository.findById(id);
    }

    public List<Book> findAll(){
        logger.info("findAll books " + this.getClass().getName());
        return bookRepository.findAll();
    }

    public String update(String id, Book book){
        logger.info("update book " + this.getClass().getName());
        return bookRepository.update(id, book);
    }

    public String delete(String id){
        logger.info("Edit Configurations… book " + this.getClass().getName());
        return bookRepository.delete(id);
    }

}
