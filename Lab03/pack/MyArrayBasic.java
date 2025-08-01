package Lab03.pack;

public class MyArrayBasic {
    
    protected int MAX_SIZE=5;
    protected int data[]=new int[MAX_SIZE];
    protected int size=0;

    public MyArrayBasic(int...args){
         if (args == null) return;
        MAX_SIZE = args.length;
        size = args.length;
        data = args;
        
    }

    public MyArrayBasic(){
        
    }

    public void add (int d){
        //System.out.println("Add is called");
        data[size++]=d;

    }

    public void insert_unordered(int index, int value){
        data[size++]=data[index];
        data[index]=value;
    }

    public int find(int d){
        int index=-1;
        for (int i=0 ; i<data.length ; i++){
            if (data[i]==d){
                index=i;
                break;
            }
        }

        return index;
    }

    public void delete (int index){
        for(int i=index ; i<size-1; i++){
            data[i]=data[i+1];
        }

        --size;
    }

    public int getAt(int index){
        return data[index];
    }

     @Override
    public String toString(){
        StringBuffer s=new StringBuffer();
        s.append('[');
        for (int i =0; i < size-1 ; i++){
            s.append(data[i]);
            s.append(',');
        }

        if (size!=0){
            s.append(data[size-1]);
        }

        s.append(']');

        return s.toString();
        
    }
    }


