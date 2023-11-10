package aud4;

public class audMinValue {
    public static int minValue(int tax[],int cost[][]){
        int minValues[] = new int [tax.length];
        minValues[0] = tax[0];
        for (int i = 1; i < tax.length; i++) {
            minValues[i] = minValues[0] + cost[0][i] + tax[i];
            for (int j = 0; j < i; j++) {
                if (minValues[j] + cost[j][i] + tax[i] < minValues[i]){
                    minValues[i] = minValues[j] + cost[j][i] + tax[i];
                }
            }
        }
        return minValues[tax.length-1];
    }
    public static void main(String[] args) {
    }
}
