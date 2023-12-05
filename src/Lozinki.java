import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class Lozinki {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Hashtable<String, String> hashtable = new Hashtable<>();

        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            hashtable.put(pom[0],pom[1]);
        }

        while (true){
            String next = br.readLine();
            if (next.equals("KRAJ")){
                break;
            }

            String [] parts = next.split(" ");

            if (hashtable.containsKey(parts[0]) && hashtable.get(parts[0]).equals(parts[1])){
                System.out.println("Najaven");
            } else {
                System.out.println("Nenajaven");
            }
        }


    }
}
