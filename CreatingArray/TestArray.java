package CreatingArray;

public class TestArray {

    public static void main(String[] args){
        MyArray a=new MyArray();

        a.add(6);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        System.out.println("Current array is :"+ a.toString());
        System.out.println("At index 4 is : "+ a.getAt(4));
        a.setAt(3, 9);
        System.out.println("Set 9 at index 3 .");
        System.out.println("Current array is :"+ a.toString());
    }
    
}
