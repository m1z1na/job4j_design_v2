package ru.job4j.ood.lsp;

public class Bird {
    String fly(){
        return "Я умею летать";
    }
}
class Penguin extends Bird{

    @Override
    String fly() {
       return null;
    }
}