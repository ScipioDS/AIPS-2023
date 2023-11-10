package aud4;

public class audMaxValue {
    public static int maxValue(int m[][]){
        int maxValues[][] = new int[m.length][m[0].length];
        maxValues[0][0] = m[0][0];

        for (int i = 1; i < m[0].length; i++) {
            maxValues[0][i] = maxValues[0][i-1]+m[0][i];
        }
        for (int i = 1; i < m.length; i++) {
            maxValues[i][0] = maxValues[i-1][0]+m[i][0];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                maxValues[i][j] = Math.max(maxValues[i][j-1],maxValues[i-1][j]) + m[i][j];
            }
        }
        return maxValues[m.length-1][m[0].length-1];
    }

    public static void main(String[] args) {
        int m[][] = {{1,8},{27,1},{69,10}};
        System.out.println(maxValue(m));
    }
}
