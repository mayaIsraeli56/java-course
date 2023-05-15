package Q2;
public class ClassA {

    public ClassA(){ 
        f();
    } 

    public void f(){
        System.out.println("Class a");
    }

    public static void main(String[] args) { 
        new ClassB();
    }

}

