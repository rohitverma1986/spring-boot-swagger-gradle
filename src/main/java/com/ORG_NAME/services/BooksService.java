package com.ORG_NAME.services;

import com.ORG_NAME.commons.objects.Book;
import com.ORG_NAME.repositories.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by UGAM\rohit.verma on 16/11/17.
 */
@Service("booksService")
public class BooksService implements Services {
    @Autowired
    Repositories booksRepository;

    @Override
    public String create(Object book) {
        return booksRepository.create(book);
    }

    @Override
    public Object get(String id) {
        return booksRepository.get(id);
    }

    @Override
    public boolean delete(String id) {
        return booksRepository.delete(id);
    }

    @Override
    public List<Book> getBooks() {
        return booksRepository.getBooks();
    }
}
