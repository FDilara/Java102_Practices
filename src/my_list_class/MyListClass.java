package my_list_class;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyListClass<T> {
    private int capacity, count = 0;

    private T[] array;

    public MyListClass() {
        this.capacity = 10;
        array = (T[]) new Object[this.capacity];
    }

    public MyListClass(int newCapacity) {
        this.capacity = newCapacity;
        array = (T[]) new Object[this.capacity];
    }

    public void add(T data) {
        if(this.count!=this.capacity){
            array[this.count] = (data);
            this.count++;
        } else {
            growCapacity();
        }
    }

    public void growCapacity() {
        T[] tempArray = (T[]) new Object[this.capacity*2];
        for(int i=0; i<this.capacity; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
        setCapacity(this.capacity*2);
    }

    public void print() {
        System.out.println("Size of array: "+this.count);
        System.out.println("Capacity of array: "+this.capacity);
        for (int i = 0; i<this.count; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");
    }

    public int size() {
        return this.count;
    }

    public boolean setIndex(int index, T data) {
        if(index>=0 && index<=this.count) {
            array[index] = data;
            return true;
        }
        else{
            return false;
        }
    }

    public T get(int index) {
        if(index>=0 && index<=this.count) {
            return array[index];
        }
        else{
            return null;
        }
    }

    public boolean remove(int index) {
        if(index>=0 && index<=this.count) {
            for(int i=index; i<this.count-1; i++) {
                array[i] = array[i+1];
            }
            array[this.count - 1] = array[this.count+1];
            this.count--;
            return true;
        } else {
            return false;
        }
    }

    public int indexOf(T data) {
        for(int i=0; i<this.count; i++) {
            if(array[i]==data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int index = -1;
        for(int i=0; i<this.count; i++) {
            if(array[i]==data) {
                index = i;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        if(this.count>0)
            return false;
        return true;
    }

    public T[] toArray() {
        return array;
    }

    public void clear() {
        for(int i=0; i<this.count; i++) {
            remove(i);
        }
    }

    public T[] sublist(int start, int finish) {
        T[] tempArray = Arrays.copyOfRange(array, start, finish);
        return tempArray;
    }

    public boolean contains(T data) {
        for(int i=0; i<this.count; i++) {
            if(array[i]==data) {
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
