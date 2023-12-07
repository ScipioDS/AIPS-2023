package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    K key;
    E value;
    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }


    @Override
    public String toString() {
        return element.toString();
    }
}


class CBHT<K extends Comparable<K>, E> {
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }



    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }
}


@SuppressWarnings("unchecked")
public class RoutingHashJava {
    public static void main (String[] args)  {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        CBHT<String, List> hash = new CBHT<>(N);

        for (int i = 0; i < N; i++) {
            String key = sc.nextLine();
            String [] dst = sc.nextLine().split(",");
            List<String> list = new ArrayList<>();
            for (int j = 0; j < dst.length; j++) {
                list.add(dst[j]);
            }
            hash.insert(key,list);
        }

        int K = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < K; i++) {
            String start = sc.nextLine();
            String end = sc.nextLine();

            SLLNode<MapEntry<String, List>> r = hash.search(start);
            if (r == null){
                System.out.println("ne postoi");
                continue;
            }

            List<String> results = hash.search(start).element.value;
            boolean flag = false;

            for (int j = 0; j < results.size(); j++) {
//                String [] result = results.get(j).split("\\.");
//                if (end[0].equals(result[0]) && end[1].equals(result[1]) && end[2].equals(result[2])){
//                    flag = true;
//                    break;
//                }
                String rez = results.get(j);
                if (end.substring(0,end.lastIndexOf(".")).equals(rez.substring(0,rez.lastIndexOf(".")))){
                    flag = true;
                    break;
                }
            }

            if (flag){
                System.out.println("postoi");
            } else {
                System.out.println("ne postoi");
            }
        }
    }
}