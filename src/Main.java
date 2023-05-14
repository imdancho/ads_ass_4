import java.util.Random;

class MyTestingClass  {
    private int V;
    public MyTestingClass(int V) {
        this.V = V;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(V);
    }
}

public class Main {
    public static void main(String[] args) {

        MyHashTable myHashTable = new MyHashTable<MyTestingClass, String>();
        Random random = new Random();

        for (int i = 10000; i > 0; i++) {

            int V = random.nextInt(0, 10000);
            myHashTable.put(new MyTestingClass(V), "Student" + V);
        }
    }
}