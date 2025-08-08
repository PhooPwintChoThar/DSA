package Lab05;
import Lab05.pack.MyStack671755;
public class Solution_671755 {

    String processString(String a){
        MyStack671755<Character> stack=new MyStack671755<>();

        for(int i=0 ; i<a.length() ; i++){
            if (a.charAt(i)=='#'){
                if (!stack.isEmpty())
                 stack.pop();
                
                 continue;
            }

            stack.push(a.charAt(i));

        }



        StringBuffer result=new StringBuffer();

        while(!stack.isEmpty()){
            result.append(String.valueOf(stack.pop()));
        }

        return result.toString();

    }

    public boolean bacakspaceCompare(String s , String t){
        
        return processString(s).equals(processString(t));


    }


    public   void main(String[] args){
        System.out.println("Input s: \"ab#c\" , t:\"ad#c\"");
        System.out.println(bacakspaceCompare("ab#c" , "ad#c"));
        System.out.println("----------------------------------");

        System.out.println("Input s: \"ab##\" , t:\"c#d#\"");
        System.out.println(bacakspaceCompare("ab##" , "c#d#"));
        System.out.println("----------------------------------");

        System.out.println("Input s: \"a#c\" , t:\"b\"");
        System.out.println(bacakspaceCompare("a#c" , "b"));
        System.out.println("----------------------------------");
        
    }
    
}
