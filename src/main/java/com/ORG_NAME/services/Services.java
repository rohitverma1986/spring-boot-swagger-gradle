package com.ORG_NAME.services;

import com.ORG_NAME.commons.objects.Book;

import java.util.List;

/**
 * Created by rohit.verma on 16/11/17.
 */
public interface Services {
    /**
     * Return Generated Id of created object**/
    String create(Object obj);
    /**
     * Return object of given id**/
    Object get(String id);
    /**
     * Return true if delete operation succeeds els false**/
    boolean delete(String id);

    /**Return list of all books**/
    List<Book> getBooks();
}
