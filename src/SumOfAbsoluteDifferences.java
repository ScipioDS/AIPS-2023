import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {
        int [][] matrix = new int[N][K];
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++) {
                for (int k = i; k < N; k++) {
                    matrix[i][j] = Math.max(matrix[k][j-1] + Math.abs(numbers[i]-numbers[k]),matrix[i][j]);
                }
                result=Math.max(matrix[i][j],result);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}