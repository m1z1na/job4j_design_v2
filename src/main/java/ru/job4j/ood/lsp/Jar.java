package ru.job4j.ood.lsp;

class Jar_1l {

    private int volume;

    int get() {
        return volume;
    }

    void set(int value) {
        this.volume = value;
    }

    public void closeJar() {

        if (volume < 1) {
            throw new IllegalArgumentException("Need more jelly!");
        }
        /* other logic */
    }
}

class Jar_2l extends Jar_1l{

    public void closeJar() {

        if (super.get() < 2) { /* условие усилено */
            throw new IllegalArgumentException("Need more jelly!");
        }
        /* other logic */
    }
}