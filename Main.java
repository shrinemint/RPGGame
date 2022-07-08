import java.util.ArrayList;

/* This is just a tester to make sure github works
 * do whatever you want with this
 */
public class Main {
    public Main() {
        System.out.println("Hello World");
        System.out.println("cum");
        ArrayList<Pair> keys = new ArrayList<Pair>();
        keys.add(new Pair(7, "Fizz"));
        keys.add(new Pair(11, "Buzz"));

        for (int i = 1; i <= 100; i++) {
            String output = "";
            int j = 0;
            while (j < keys.size()) {
                if (i % keys.get(j).getKey() == 0) {
                    output += keys.get(j).getPhrase();
                }
                j++;
            }
            if (output.equals("")) {
                System.out.println(i);
            }
            else {
                System.out.println(output);
            }
            
        }
    }

    class Pair {
        private int key;
        private String phrase;

        public Pair(int key, String phrase) {
            this.key = key;
            this.phrase = phrase;
        }

        public int getKey() {
            return key;
        }

        public String getPhrase() {
            return phrase;
        }
    }

    public static void main (String args[]) {
       new Main();
    }
}