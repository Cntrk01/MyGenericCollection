package com.example.kendigenericlistem;

public class Main {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>(10);
        myCollection.addData("Hello World");
        System.out.println(myCollection.size());
        System.out.println(myCollection.getCapacity());
    }
    public static void addListData() {
        MyCollection<String> myCollection = new MyCollection<>(10);
        System.out.println("Eleman Sayısı : "+myCollection.size());
        myCollection.addData("Hello World");
        System.out.println("Capasity : "+myCollection.getCapacity());
        myCollection.addData("Hello World");
        myCollection.addData("Hello World 123");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");
        myCollection.addData("Hello World");

        System.out.println("Capasity : "+ myCollection.getCapacity());
        System.out.println("Eleman Sayısı : "+ myCollection.size());
        System.out.println("3.İndexteki Eleman : "+myCollection.get(2)); //Hello World 123

        System.out.println(myCollection.elementsLenght());
    }

    //Eleman silip yerine yenisini ekliyoruz.
    public static void removeMethod() {
        MyCollection<Integer> liste = new MyCollection<>(10);
        liste.addData(10);
        liste.addData(20);
        liste.addData(30);
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.addData(40);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
    }

    //Verilen değerin indexini getiriyor
    public static void indexOfMethod() {
        MyCollection<Integer> liste = new MyCollection<>(10);
        liste.addData(10);
        liste.addData(20);
        liste.addData(30);
        liste.addData(40);
        System.out.println(liste.indexOf(40));
    }

    //Verilen değerin en sondaki pozisyonunu bulur [10, 20, 30, 40, 30, 50] 30 için 5.
    public static void lastIndexOfMethod(){
        MyCollection<Integer> liste = new MyCollection<>(10);
        liste.addData(10);
        liste.addData(20);
        liste.addData(30);
        liste.addData(40);
        liste.addData(20);
        liste.addData(20);
        liste.addData(30);
        liste.addData(20);
        MyCollection<Integer> sublist = liste.sublist(2, 4);
        System.out.println(sublist.toString());
        System.out.println(liste.lastIndexOf(20));
    }

    public static void isEmptyMethod() {
        MyCollection<Integer> liste = new MyCollection<>(10);
        System.out.println("Is Empty ? : " + liste.isEmpty());
    }
}
