package com.ORG_NAME.repositories;

import com.ORG_NAME.commons.objects.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by UGAM\rohit.verma on 16/11/17.
 */

@Repository("booksRepository")
public class BooksRepository implements Repositories {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BooksRepository() {
    }

    @PostConstruct
    private void configureDB() {
        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE books(" + "id VARCHAR(20), cat VARCHAR(255), name VARCHAR(255), author VARCHAR(255)," +
                " series_t VARCHAR(255), sequence_i VARCHAR(255), genre_s VARCHAR(255), in_stock boolean, price double(10), page int(10))");
        List<Object[]> splitUpNames = new ArrayList<>();
        splitUpNames.add(new String[]{"978-0641723445", "book, hardcover", "The Lightning Thief", "Rick Riordan", "Percy Jackson and the Olympians", "1", "fantasy", "true", "12.50", "384"});
        splitUpNames.add(new String[]{"978-1423103349", "book, paperback", "The Sea of Monsters", "Rick Riordan", "Percy Jackson and the Olympians", "2", "fantasy", "true", "6.49", "304"});
        jdbcTemplate.batchUpdate("INSERT INTO books(id, cat, name, author, series_t, sequence_i, genre_s, in_stock, price, page) VALUES (?,?,?,?,?,?,?,?,?,?)", splitUpNames);

    }

    class BookMapperImpl implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
            Book book = new Book(rs.getString(1), Arrays.asList(rs.getString(2).split(",")), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8), rs.getDouble(9), rs.getInt(10));
            return book;
        }
    }

    @Override
    public String create(Object object) {
        Book book = (Book) object;
        jdbcTemplate.update("INSERT INTO books(id, cat, name, author, series_t, sequence_i, genre_s, in_stock, price, page) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)", new Object[]{
                book.getId(), book.getCat().toString().replaceAll("\\[|]", ""), book.getName(), book.getAuthor(), book.getSeries_t(), book.getSequence_i(),
                book.getGenre_s(), book.isInStock(), book.getPrice(), book.getPages_i()
        });
        return book.getId();
    }

    @Override
    public Book get(String id) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE id = ? ;", new String[]{id}, new BookMapperImpl());
        if(null!=books && books.size()>0){
            return  books.get(0);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        int updateCount = jdbcTemplate.update("DELETE FROM books WHERE id = ? ;", new String[]{id});
        System.out.println("-------------" +updateCount );
        return updateCount == 1;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books;", new BookMapperImpl());
        for (Book book : books) {
            System.out.println(book);
        }
        return books;
    }
}
