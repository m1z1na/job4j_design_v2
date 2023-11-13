package ru.job4j.ood.ocp;

class Phone{
    public void call() {
        System.out.println("Я звоню");
    }

    public void doPhoto() {
        System.out.println("Я фотографирую");
    }

}

class IPhone extends Phone{

}

class Watch extends Phone{


    @Override
    public void doPhoto() {
      /*  return null;*/
    }
}
