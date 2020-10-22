import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

    static class MyInteger {
        int value;
        MyInteger(int i){
            value = i;
        }

        @Override
        public String toString() {
            return "MyInteger{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyInteger myInteger = (MyInteger) o;

            return (value == myInteger.value);
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    public static void print(Collection<MyInteger> collection){
        for (MyInteger object : collection) {
            System.out.println(object);
        }
    }
    public static void addAll(Collection<MyInteger> collection){
        for(int i = 0; i<10;i++){
            collection.add(new MyInteger(i));
            collection.add(new MyInteger(i));
        }
    }

    public static void main(String[] args) {
        Collection<MyInteger> set = new HashSet<>();
        addAll(set);

        System.out.println("Hashset:");
        print(set);
    }
}
