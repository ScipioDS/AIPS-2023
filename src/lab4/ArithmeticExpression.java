package lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        if(l==r) return toInteger(c[l]);

        int borders=0, location = -1;
        for (int i = l; i < r; i++) {
            if (c[i]=='('){
                borders++;
            } else if (c[i]==')') {
                borders--;
            } else if ((c[i]=='+' || c[i]=='-') && borders==0) {
                location=i;
            }
        }
        if (location==-1) return presmetaj(c,l+1,r-1);

        if (c[location]=='+'){
            return presmetaj(c,l,location-1) + presmetaj(c,location+1,r);
        } else {
            return presmetaj(c,l,location-1) - presmetaj(c,location+1,r);
        }
    }

    static int toInteger(char num){
        return Integer.parseInt(String.valueOf(num));
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
