package lab7;

import java.io.IOException;
import java.util.Scanner;

class AMapEntry<K extends Comparable<K>,E> implements Comparable<K> {
    K key;
    E value;

    public AMapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        @SuppressWarnings("unchecked")
        AMapEntry<K,E> other = (AMapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}


class OBHT<K extends Comparable<K>,E> {

    private AMapEntry<K,E>[] buckets;

    static final int NONE = -1;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final AMapEntry former = new AMapEntry(null, null);

    private int occupancy = 0;

    @SuppressWarnings("unchecked")
    public OBHT (int m) {
        buckets = (AMapEntry<K,E>[]) new AMapEntry[m];
    }

    private int hash (K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public AMapEntry<K,E> getBucket(int i){
        return buckets[i];
    }


    public int search (K targetKey) {
        int b = hash(targetKey);
        for (;;) {
            AMapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return NONE;
            else if (targetKey.equals(oldEntry.key))
                return b;
            else
                b = (b + 1) % buckets.length;
        }
    }


    public void insert (K key, E val) {
        AMapEntry<K,E> newEntry = new AMapEntry<K,E>(key, val);
        int b = hash(key);
        for (;;) {
            AMapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null) {
                if (++occupancy == buckets.length) {
                    System.out.println("Hash tabelata e polna!!!");
                }
                buckets[b] = newEntry;
                return;
            } else if (oldEntry == former
                    || key.equals(oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            } else
                b = (b + 1) % buckets.length;
        }
    }


    @SuppressWarnings("unchecked")
    public void delete (K key) {
        int b = hash(key);
        for (;;) {
            AMapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return;
            else if (key.equals(oldEntry.key)) {
                buckets[b] = former;
                return;
            } else{
                b = (b + 1) % buckets.length;
            }
        }
    }


    public String toString () {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            if (buckets[i] == null)
                temp += "\n";
            else if (buckets[i] == former)
                temp += "former\n";
            else
                temp += buckets[i] + "\n";
        }
        return temp;
    }


    public OBHT<K,E> clone () {
        OBHT<K,E> copy = new OBHT<K,E>(buckets.length);
        for (int i = 0; i < buckets.length; i++) {
            AMapEntry<K,E> e = buckets[i];
            if (e != null&&e != former)
                copy.buckets[i] = new AMapEntry<K,E>(e.key, e.value);
            else
                copy.buckets[i] = e;
        }
        return copy;
    }
}



public class Preveduvac {
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        OBHT<String,String> hash = new OBHT<>(128);

        for (int i = 0; i < N; i++) {
            String [] parts = scanner.nextLine().split(" ");
            hash.insert(parts[1],parts[0]);
        }

        while (true){
            String input = scanner.nextLine();
            if (input.equals("KRAJ")) break;

            int loc = hash.search(input);
            if (loc != -1) {
                System.out.println(hash.getBucket(loc).value);
            } else {
                System.out.println("/");
            }
        }
    }
}
