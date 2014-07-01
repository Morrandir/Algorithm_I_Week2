/**
 * Created by Qubo Song on 7/1/2014.
 */
public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> stringQueue = new RandomizedQueue<String>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            //if (i == Integer.valueOf(args[1])) break;
            if (i < Integer.valueOf(args[0])) {
                stringQueue.enqueue(StdIn.readString());
            } else if (StdRandom.uniform(i + 1) < Integer.valueOf(args[0])) {
                stringQueue.dequeue();
                stringQueue.enqueue(StdIn.readString());
            } else {
                StdIn.readString();
            }

        }

        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            System.out.printf("%s%n", stringQueue.dequeue());
        }

    }
}
