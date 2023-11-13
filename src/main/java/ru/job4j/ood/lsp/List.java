package ru.job4j.ood.lsp;

import java.util.ArrayList;

class MyList {
    private ArrayList<Integer> numbers;


    void add(Integer value){
        numbers.add(value);
    }

    void delete(int index){
        numbers.remove(index);
    }

    int size(){
        return numbers.size();
    }
}

class NewList extends MyList {


    @Override
    void delete(int index) {
        /*изменение поведения ребенка*/
        super.delete(super.size());
    }
}
