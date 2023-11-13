package ru.job4j.ood.isp;

interface Person {
    void eat() ;
    void talk();
    void sleap();
}
class JavaDeveloper implements Person {
    @Override
    public void eat() {

    }
    /* разработчику не нужно общение*/
    @Override
    public void talk() {

    }

    @Override
    public void sleap() {

    }
}