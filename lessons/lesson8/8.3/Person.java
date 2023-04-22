public class Person {
    private int _age;

    public Person(int age) {
        _age = age;
    }

    public boolean equals(Person p) { // 1
        System.out.println("1");
        return _age == p._age;
    }

    public boolean equals(Object obj) { //2
        System.out.println("2");
        return obj instanceof Person && _age == ((Person)obj)._age;
    }
}
