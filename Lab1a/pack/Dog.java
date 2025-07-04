package pack;

import java.util.Objects;

public class Dog {
    private Breed b;
    private int weight;

    public Dog ( Breed b ,int w){
        this.b=b;
        this.weight=w;
    }

    public Breed getBreed(){
        return b;
    }

    @Override
    public String toString(){
        return "Dog ( " + b + " , " + weight + ")";
    }
    @Override
    public boolean equals(Object ob){
        if (this==ob){
            return true;
        }
        if( ob==null || getClass() != ob.getClass()){
            return false;
        }

        Dog dog= (Dog) ob;
        return weight==dog.weight && b==dog.b;
    }

    @Override
    public int hashCode(){
        return Objects.hash(b ,weight);
    }
    
}
