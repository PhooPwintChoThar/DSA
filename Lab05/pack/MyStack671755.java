package Lab05.pack;

import java.util.ArrayList;


public class MyStack671755 <T>{

    private ArrayList<T> items=new ArrayList<>();
    


    public void push(T d){
        items.add(d);

    }

    public T pop(){
        if (!isEmpty()){

            return items.removeLast();

        }

        return null;
        
    }

    public T peek(){
        if (!isEmpty()){
            return items.getLast();
        }

        return null;
        
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.size()==0;
    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(int i=items.size()-1; i>0 ; i--){
            sb.append(items.get(i)+",");
        }

        if (items.size()>0){
            sb.append(items.get(0));
        }

        sb.append(']');

        return sb.toString();

    }
    
}
