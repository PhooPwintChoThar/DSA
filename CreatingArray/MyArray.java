package CreatingArray;

public class MyArray {
    int maxSize=5;
    int[] arr = new int[maxSize];
    int size=0;

    public MyArray(){

    }

    public boolean add( int data){

     if (isFull()){
        return false;

     }

     arr[size++]=data;
     return true;

    }

    public int getAt(int index){
        return arr[index];
    }


    public void setAt(int index, int data){
        arr[index]=data;
    }



    boolean isFull(){
        return size==maxSize;
    }
    
   public String toString(){

     StringBuffer s=new StringBuffer();
     s.append('[');
     for (int i =0; i < size-1 ; i++){
        s.append(arr[i]);
        s.append(',');
     }

     if (size!=0){
        s.append(arr[size-1]);
     }

     s.append(']');

     return s.toString();


   }
}
