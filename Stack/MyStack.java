package Stack;

public class MyStack {

    int MAX_SIZE=10;
    int[] stack=new int [MAX_SIZE];
    int top=0;
    
    public void push(int d){
        stack[top++]=d;


    }

    public int pop(){
        return stack[--top];

    }

    public int top(){
        return stack[top-1];


    }

    public boolean isFull(){
        return top==MAX_SIZE;

    }

    public boolean isEmpty(){
        return top==0;

    }

    public String toString(){
        StringBuffer text=new StringBuffer();
        text.append('[');
        for (int i =0 ; i<top-1; i++){
            text.append(stack[i]);
            text.append(',');

        }
        text.append(stack[top-1]);
        text.append((']'));

        return text.toString();

    }
}
