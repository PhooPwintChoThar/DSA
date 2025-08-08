package Stack;


public class StackTester {
    public static void main(String[] args){
        MyStack stack=new MyStack();
        stack.push(6);
        stack.push(5);
        stack.push(8);
        stack.push(4);
        System.out.println("Currently the stack is : " + stack.toString());
        System.out.print("After removing " + stack.top()+", the stack is : ");
        stack.pop();
        System.out.println(stack.toString());



    }
    
}
