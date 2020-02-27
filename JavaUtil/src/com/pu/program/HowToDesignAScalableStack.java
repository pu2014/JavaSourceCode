package com.pu.program;


import java.util.Arrays;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/27 18:24
 */
public class HowToDesignAScalableStack {

}
class  MyStack<T>{
    private Object[] storage;
    private int capacity;
    private int count;
    private static final int GROW_FACTOR = 2;
    //TODO:初始容量为8
    MyStack(){
        this.capacity = 8;
        this.storage = new Object[8];
        this.count = 0;
    }
    //TODO 带初始容量
    MyStack(int initialCapacity){
        if(initialCapacity < 1){
            throw new IllegalArgumentException("initialCapacity too samll");
        }

        this.capacity = initialCapacity;
        this.storage = new Object[initialCapacity];
        this.count = 0;
    }

    //todo push
    public  void push(T value){
        if(count == capacity){
            ensureCapacity();
        }
        storage[count++] = value;
    }
    //todo 确保容量大小
    private void ensureCapacity() {
        int newCapacity = capacity  + (capacity >> 1); // 模仿ArrayList
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    //todo peek
    private T peek(){
        if(count == 0){
            throw new IllegalArgumentException("stack is null");
        }else{
            return (T)storage[count - 1];
        }
    }

    //todo pop
    private T pop(){
        count--;
        if(count == 0){
            throw new IllegalArgumentException("stack is null");
        }else{
            return (T)storage[count];
        }
    }
    //todo isEmpty()
    private boolean isEmpty(){
        return count == 0;
    }

    //todo size()
    private int size(){
        return count;
    }

}
