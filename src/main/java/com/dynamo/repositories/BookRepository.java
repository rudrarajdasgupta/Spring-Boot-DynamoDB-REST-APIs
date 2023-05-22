package com.dynamo.repositories;

import java.util.List;

import com.dynamo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

@Repository
public class BookRepository  {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Book save(Book book){
        dynamoDBMapper.save(book);
        return book;
    }

    public List<Book> saveAll(List<Book> bookList){
        dynamoDBMapper.batchSave(bookList);
        return bookList;
    }
    
    public Book findById(String id){
       return dynamoDBMapper.load(Book.class, id);
    }

    public List<Book> findAll(){
        return dynamoDBMapper.scan(Book.class, new DynamoDBScanExpression());
    }

    public String update(String id, Book book){
        dynamoDBMapper.save(book,
                new DynamoDBSaveExpression()
        .withExpectedEntry("id",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(id)
                )));
        return id;
    }

    public String delete(String id){
       Book book = dynamoDBMapper.load(Book.class, id);
        dynamoDBMapper.delete(book);
        return "Book deleted successfully:: "+id;
    }


}