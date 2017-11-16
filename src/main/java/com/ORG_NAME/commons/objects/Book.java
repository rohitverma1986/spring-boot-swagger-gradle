package com.ORG_NAME.commons.objects;

import java.util.List;

/**
 * Created by UGAM\rohit.verma on 16/11/17.
 */
public class Book {

    private String id; //"978-0641723445"
    private List<String> cat;//["book","hardcover"]
    private String name; //"The Lightning Thief"
    private String author;//"Rick Riordan"
    private String series_t;//"Percy Jackson and the Olympians"
    private int sequence_i;//1
    private String genre_s;//"fantasy"
    private boolean inStock;//true
    private double price;//12.50
    private int pages_i;//384

    public Book() {
    }

    public Book(String id, List<String> cat, String name, String author, String series_t, int sequence_i, String genre_s, boolean inStock, double price, int pages_i) {
        this.id = id;
        this.cat = cat;
        this.name = name;
        this.author = author;
        this.series_t = series_t;
        this.sequence_i = sequence_i;
        this.genre_s = genre_s;
        this.inStock = inStock;
        this.price = price;
        this.pages_i = pages_i;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%s, Category='%s', Name='%s', Author='%s', Sereies='%s', Sequence='%s', Genre='%s', In Stock='%s', Price='%s', Page='%s']",
                id, cat, name, author, series_t, sequence_i, genre_s, inStock, price, pages_i);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCat() {
        return cat;
    }

    public void setCat(List<String> cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public void setSeries_t(String series_t) {
        this.series_t = series_t;
    }

    public int getSequence_i() {
        return sequence_i;
    }

    public void setSequence_i(int sequence_i) {
        this.sequence_i = sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public void setGenre_s(String genre_s) {
        this.genre_s = genre_s;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages_i() {
        return pages_i;
    }

    public void setPages_i(int pages_i) {
        this.pages_i = pages_i;
    }
}
