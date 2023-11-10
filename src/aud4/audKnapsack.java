package aud4;

public class audKnapsack {
    public static int maxProfit(int c,int p[],int w[]){
        int maxProfits[][] = new int[p.length][c+1];

        for (int i = 0; i < p.length; i++) {
            maxProfits[i][0] = 0;
        }
        for (int i = 0; i <= c; i++) {
            maxProfits[0][i] = 0;
        }
        for (int i = 1; i <= p.length; i++) {
            for (int j = 1; j <= c; j++) {
                if(j >= w[i-1]) {
                    maxProfits[i][j] = Math.max(p[i-1] + maxProfits[i-1][j-w[i-1]],maxProfits[i-1][j]);
                } else {
                    maxProfits[i][j] = maxProfits[i-1][j];
                }
            }
        }
        return maxProfits[p.length][c];
    }

    public static void main(String[] args) {
        int p[] = {120,160,60};
        int w[] = {30,20,10};

        System.out.println(maxProfit(50,p,w));
    }
}
