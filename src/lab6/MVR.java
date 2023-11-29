package lab6;

import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E> {

    // Elementi na redicata se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size ();
    // Ja vrakja dolzinata na redicata.

    public E peek ();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear ();
    // Ja prazni redicata.

    public void enqueue (E x);
    // Go dodava x na kraj od redicata.

    public E dequeue ();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class ArrayQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
class Gragjanin{
    String imePrezime;
    int lKarta;
    int pasos;
    int vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
}
public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        Queue<Gragjanin> lKartaQueue = new ArrayQueue<>(20);
        Queue<Gragjanin> pasosQueue = new ArrayQueue<>(20);
        Queue<Gragjanin> vozackaQueue = new ArrayQueue<>(20);

        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);

            if (lKarta == 1){
                lKartaQueue.enqueue(covek);
            } else if (pasos == 1) {
                pasosQueue.enqueue(covek);
            } else if (vozacka == 1) {
                vozackaQueue.enqueue(covek);
            }
        }

        while (!lKartaQueue.isEmpty()){
            Gragjanin curr = lKartaQueue.peek();
            if (curr.getPasos()==1){
              pasosQueue.enqueue(lKartaQueue.dequeue());
            } else if (curr.getVozacka()==1){
                vozackaQueue.enqueue(lKartaQueue.dequeue());
            } else {
                System.out.println(lKartaQueue.dequeue());
            }
        }
        while (!pasosQueue.isEmpty()){
            Gragjanin curr = pasosQueue.peek();
            if (curr.getVozacka()==1){
                vozackaQueue.enqueue(pasosQueue.dequeue());
            } else {
                System.out.println(pasosQueue.dequeue());
            }
        }
        while (!vozackaQueue.isEmpty()){
            System.out.println(vozackaQueue.dequeue());
        }
    }
}