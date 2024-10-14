package org.example.examples.Generics;

class Container<T>
{
    T value;

    public void show()
    {
        System.out.println(value.getClass().getName());
    }
}



public class GenericsDemo {

    public static void main(String[] args) {
        Container<Integer> demoVar = new Container<>();
        demoVar.value = 1;
        demoVar.show(); //java.lang.Integer



        Container<String> demoVAr1 = new Container<>();
        demoVAr1.value = "blabla";
        demoVAr1.show(); //java.lang.String


    }



}
