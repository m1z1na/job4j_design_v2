package ru.job4j.ood.ocp;


import java.util.List;

public class Bookshelf {
/*  public List<Book> books;*/
   public List<Object> books;
}
class Book {
}
class Toy {
}
class Person {
    private Bookshelf bookshelf;

    void getBookAndRead(int index){
        System.out.println(bookshelf.books.get(index));
    }
    void addBook(){
        bookshelf.books.add(new Toy());/*новый метод*/
        bookshelf.books.add(new Book());
    }


}