package lab2;

import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNodeCardGame<E> succ;

    public SLLNode(E elem, SLLNodeCardGame<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNodeCardGame<E> first;

    public SLL() {
        // Construct an empty lab2_1.SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNodeCardGame<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNodeCardGame<E> ins = new SLLNodeCardGame<E>(o, null);
        ins.succ = first;
        //lab2_1.SLLNode<E> ins = new lab2_1.SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNodeCardGame<E> node) {
        if (node != null) {
            SLLNodeCardGame<E> ins = new SLLNodeCardGame<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertBefore(E o, SLLNodeCardGame<E> before) {

        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNodeCardGame<E>(o, before);;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNodeCardGame<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNodeCardGame<E> node) {
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNodeCardGame<E> getFirst() {
        return first;
    }

    public SLLNodeCardGame<E> find(E o) {
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge (SLLCardGame<E> in){
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNodeCardGame<E> tmp = first;
            SLLNodeCardGame<E> newsucc = null;
            SLLNodeCardGame<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}

public class SpecialSLLDelete<E> {

    //TODO: implement method
    public void specialDelete(SLLCardGame<E> list, int m) {
       SLLNodeCardGame<E> tmp = list.getFirst();
       int count=0;
       while (tmp!=null){
           count++;
           if (count==m){
               count=0;
               list.delete(tmp);
           }
           tmp=tmp.succ;
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLLCardGame<Integer> list = new SLLCardGame<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }

}