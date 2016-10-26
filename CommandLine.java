package FastaTool;


import java.io.IOException;


public class CommandLine {
    public static void main(String[] args) throws IOException {
        FastaTool fasta = new FastaTool();

        for(int i = 0; i < args.length; i++){
            fasta.run(args[i]);
        }

    }
}
