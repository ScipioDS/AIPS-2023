package lab1;
import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;
    private int total;
    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        total=0;
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
        for (int i = 0; i < numOfSales; i++) {
            total+=revenues[i];
        }
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        String word = "";
        word = word + total;
        return word;
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public int total(){
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total+=quarters[i].getTotal();
        }
        return total;
    }

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    @Override
    public String toString() {
        String word = "";
        for (int i = 0; i < 4; i++) {
            word = word + "   " + quarters[i].toString();
        }
        return name + word + "   " + total();
    }

    public String getName() {
        return name;
    }
}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr,int n)
    {
        int j = 0;
        int total=0;
        for (int i = 0; i < n; i++) {
            if (arr[i].total()>total){
                j=i;
                total=arr[i].total();
            }
        }
        return arr[j];
    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for (SalesPerson x : arr){
            System.out.println(x.toString());
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++)
        {
            QuarterlySales[] quarterlySales = new QuarterlySales[4];
            String name = input.next();
            for (int j = 0; j < 4; j++) {
                int x = input.nextInt();
                int [] sales = new int [x];
                for (int k = 0; k < x; k++) {
                    sales[k] = input.nextInt();
                }
                quarterlySales[j] = new QuarterlySales(x,sales,j);
            }
            arr[i] = new SalesPerson(name,quarterlySales);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr,n).getName());

    }
}