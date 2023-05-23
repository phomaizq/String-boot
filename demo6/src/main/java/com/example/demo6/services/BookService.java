package com.example.demo6.services;


import com.example.demo6.entity.Book;
import com.example.demo6.repository.IBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    @Transactional
    public Book findById(Long id) {
        return bookRepository.findById(id).get() ;
    }
    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }
    public  Book getBookBtId(Long id){
        Optional<Book> optional =bookRepository.findById(id);
        return optional.orElse(null);
    }
    public  void  addBook(Book book){
        bookRepository.save(book);
    }
    public  void  updateBook(Book book){
        bookRepository.save(book);
    }
    public  void  deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void save(Book book ) {
//        System.out.println("good-service");
        bookRepository.save(book) ;
    }


}
