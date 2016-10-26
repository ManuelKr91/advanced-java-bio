package FastaTool;


import java.util.ArrayList;

public class Nucleotide {

    public int count (char x, String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == x){
                count++;
            }
        }
        return count;
    }

    public String nucleotides(ArrayList<String> sequences){
        int A = 0;
        int C = 0;
        int G = 0;
        int U = 0;
        int dash = 0;


        for(int i = 0; i < sequences.size(); i++){
            A = A + count('A', sequences.get(i));
            C = C + count('C', sequences.get(i));
            G = G + count('G', sequences.get(i));
            U = U + count('U', sequences.get(i));
            dash = dash + count('-', sequences.get(i));

        }
        return "Counts: A: " + A + ", C: " + C + ", G: " + G + ", U: " + U + ", -: " + dash;
    }

}
