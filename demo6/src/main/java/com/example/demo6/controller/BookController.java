package com.example.demo6.controller;

import com.example.demo6.entity.Book;
import com.example.demo6.entity.Category;
import com.example.demo6.services.BookService;
import com.example.demo6.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import  java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public  String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }
    @GetMapping("/add")
    public  String addBookForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return  "book/add";
    }
    @PostMapping("/add")
    public  String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return  "redirect:/books";
    }
    @RequestMapping("/delete/{id}")

    public ModelAndView deleteBook(@PathVariable("id") Long id) {
       bookService.deleteBook(id);
        return new ModelAndView("redirect:/books");
    }

    @GetMapping ("/edit/{id}")
    public  String editForm(@PathVariable("id") Long id , Model model){
        Book edit=null;
        for (Book book : ){

        }
    }




    /*RequestMapping("/editBook/{id}")
    public ModelAndView editList(@PathVariable("id") Long id, Model model) {
        Book b = bookService.getBookBtId(id) ;
        model.addAttribute("book" , b) ;
        bookService.deleteBook(id);
        return new ModelAndView("edit") ;
    }*/
}
