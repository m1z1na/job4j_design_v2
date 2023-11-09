package ru.job4j.generics;

public class Predator extends  Animal{
    private String name;

    @Override
    public String toString() {
        return "Predator{" +
                "name='" + name + '\'' +
                '}';
    }
    public Predator( String name){
        super( name );
        this.name = name;
    }
}
