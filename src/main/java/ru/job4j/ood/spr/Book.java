package ru.job4j.ood.spr;

public class Book {
    void loadBook(String path){
        System.out.println("Загрузка файла");
        saveDatabase();
    }
    void saveDatabase(){
        System.out.println("Сохранение в бд");
    }
}
