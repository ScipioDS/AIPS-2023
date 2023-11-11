package lab2;

import java.util.Scanner;

class Card {
    private int type;
    private int health;
    private int magicPower;

    public Card(int type, int health, int magicPower) {
        this.type = type;
        this.health = health;
        this.magicPower = magicPower;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int significance() {
        return health * magicPower;
    }


    @Override
    public String toString() {
        return String.valueOf(type);
    }
}

class SLLNodeCardGame<E> {
    protected E element;
    protected SLLNodeCardGame<E> succ;

    public SLLNodeCardGame(E elem, SLLNodeCardGame<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLLCardGame<E> {
    private SLLNodeCardGame<E> first;

    public SLLCardGame() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int ret;
        if (first != null) {
            SLLNodeCardGame<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

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
        SLLNodeCardGame<E> ins = new SLLNodeCardGame<E>(o, first);
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
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNodeCardGame<E> ins = new SLLNodeCardGame<E>(o, before);
                tmp.succ = ins;
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
            SLLNodeCardGame<E> ins = new SLLNodeCardGame<E>(o, null);
            tmp.succ = ins;
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
            if (first == node) {
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
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }
}

public class MysticalCardGame {

    //TODO: implement function
    public static void startDuel(SLLCardGame<Card> firstSorcererCards, SLLCardGame<Card> secondSorcererCards) {
        int sig=0;
        SLLNodeCardGame<Card> theCard = firstSorcererCards.getFirst();
        SLLNodeCardGame<Card> tmp = firstSorcererCards.getFirst();
        while (tmp!=null){
            if (tmp.element.significance()>sig){
                theCard = tmp;
                sig = tmp.element.significance();
            }
            tmp = tmp.succ;
        }
        tmp = secondSorcererCards.getFirst();
        for (int i = 0; i < secondSorcererCards.size() / 2; i++) {
            tmp = tmp.succ;
        }
        Card one = new Card(theCard.element.getType(),theCard.element.getHealth(),theCard.element.getMagicPower());
        firstSorcererCards.delete(theCard);
        secondSorcererCards.insertBefore(one,tmp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLLCardGame<Card> firstSorcererCards = new SLLCardGame<Card>();
        SLLCardGame<Card> secondSorcererCards = new SLLCardGame<Card>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startDuel(firstSorcererCards, secondSorcererCards);
        System.out.println(firstSorcererCards);
        System.out.println(secondSorcererCards);
    }
}