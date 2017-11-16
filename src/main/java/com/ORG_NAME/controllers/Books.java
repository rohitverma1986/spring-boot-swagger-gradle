package com.ORG_NAME.controllers;

import com.ORG_NAME.commons.objects.Book;
import com.ORG_NAME.services.Services;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by UGAM\rohit.verma on 16/11/17.
 */
@RestController
@RequestMapping(value = "/baseurl/v1/books")
//@Api(value = "/baseurl/v1/books", description = "Allows access to books")
public class Books {
    @Autowired
    Services booksService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get list of books.", notes = "Get list of books.", response = Book.class, responseContainer = "List")
    public List<Book> getBooks() {
        System.out.println("------For List of books------");
        return booksService.getBooks();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add book to list.", notes = "Add book to list.", response = String.class)
    public String create(@RequestBody Book book) {
        System.out.println("------For create book------" + book);
        return booksService.create(book);
    }


    @RequestMapping(value = "/id/{bookId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete book.", notes = "Delete book.")
    public boolean delete(@PathVariable("bookId") String bookId) {
        System.out.println("--------For delete book----" + bookId);
        return booksService.delete(bookId);
    }


    @RequestMapping(value = "/id/{bookId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get book.", notes = "Get book.")
    public Book get(@PathVariable("bookId") String bookId) {
        System.out.println("-------For get book-----" + bookId);
        return (Book) booksService.get(bookId);
    }

}
