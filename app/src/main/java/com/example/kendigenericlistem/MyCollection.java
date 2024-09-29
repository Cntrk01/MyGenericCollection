package com.example.kendigenericlistem;
import java.util.Arrays;

public class MyCollection<T>{
    private int position = 0;
    private int capacity = 0;
    private T[] elements;

    public MyCollection(){}

    @SuppressWarnings("unchecked")
    public MyCollection(int capacity){
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
    }

    public int size(){
        return position;
    }

    public int getCapacity(){
        return capacity;
    }

    public int elementsLenght() {
        return elements.length;
    }

    public void addData(T data){
        if (position >= capacity){
            capacity = capacity * 2;

            @SuppressWarnings("unchecked")
            T[] newElements = (T[]) new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length); //eski listeyi yeni listeye aktardık.
            elements = newElements; //sonrasında eski liste üzerinden devam ediyoruz.
        }

        elements[position] = data;
        position++;
    }

    public T get(int index){
        if (index<0 || index>=elements.length){
            return null;
        }
        return elements[index];
    }

    //verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.
    //yeni listeyi de döndürür
    public T[] remove(int index) {
        if (index < 0 || index >= elements.length) {
            return null;
        }
        position--;

        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        //elements[position - 1] = null; //İndexi boşa çektim

        return elements;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= elements.length) {
            return;
        }
        elements[index] = data;
    }

    public int indexOf(T data) {
        for(int i=0;i< elements.length - 1;i++) {
            if(elements[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {

        for (int i = position - 1; i >= 0; i--) {
            if (elements[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if(position == 0) {
            return true;
        }else {
            return false;
        }
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) new Object[position];

        System.arraycopy(elements, 0, resultArray, 0, position);

        return resultArray;
    }

    public void clear() {
        for (int i = 0; i < position; i++) {
            elements[i] = null;
        }

        position = 0;

        capacity = 10;
    }

    public MyCollection<T> sublist(int start, int finish) {
        if (start < 0 || finish > position || start > finish) {
            throw new IndexOutOfBoundsException("Geçersiz indeks aralığı");
        }

        MyCollection<T> subList = new MyCollection<>(finish - start);

        for (int i = start; i < finish; i++) {
            subList.addData(elements[i]);
        }

        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < position; i++) {
            if (elements[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "size = " + position +
                ", capacity = " + capacity +
                ", elements = " + Arrays.toString(elements) +
                '}';
    }
}