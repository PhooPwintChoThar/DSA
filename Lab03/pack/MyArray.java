package Lab03.pack;

public class MyArray extends MyArrayBasic{
    public MyArray(int...a){
        if (a== null) return;
        MAX_SIZE=a.length;
        data=a;
        size=a.length;
    }

    public MyArray(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
        
    }
    

    public MyArray(){
        MAX_SIZE=100000;
        data=new int[MAX_SIZE];
    }

    boolean isFull(){
        return size==MAX_SIZE;
    }

   
    public void insert_unordered(int index, int value){
        if(!isFull()){
            data[size++]=data[index];
            data[index]=value;
        }
    }

    boolean isEmpty(){
        return size==0;
    }



    public void delete (int index){
        if(!isEmpty()){
            for(int i=index ; i<size-1; i++){
            data[i]=data[i+1];
        }

        --size;
    }
        }

    int[] expandByK(int k){
        MAX_SIZE = k * MAX_SIZE;
        int newData[] = new int [MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        return data;

    }


    int[] expand(){
         return expandByK(2);
        
    } 

    
    public void add (int d){
        if (isFull()){
            data=expand();
        }
        data[size++]=d;

    }


    public int binarySearch(int target){
        int start=0;
        int end=size-1;
       
        while( start<=end){
            int middle=(start+end)/2;

            if (data[middle]==target) return middle;

            if (data[middle]>target){
                end=middle-1;
            }else{
                start=middle+1;

            }

            

        }

        return -1;

    }

    

}
