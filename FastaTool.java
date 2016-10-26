package FastaTool;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class FastaTool {

    public void run (String arg) throws IOException {

        Sequence s = new Sequence();
        Reader r = new FileReader(arg);
        Nucleotide n = new Nucleotide();


        s.read(r);
        s.computeValues();

        String format = "%-30s%s%n";

        for(int i = 0; i < s.size(); i++){
            System.out.printf(format, s.getHeader(i), s.getSequence(i));
        }

        System.out.println("\n" + "Number of sequences:    " + s.size());

        String format2 = "%-20s%s%n";

        System.out.printf(format2,"Shortest length: " + s.getShortest(), "(excluding '-'s:" + s.getShortD() + ")");
        System.out.printf(format2,"Average length:  " + s.getAverage(), "(excluding '-'s:" + s.getAvgD() + ")");
        System.out.printf(format2,"Longest length:  " + s.getLongest(), "(excluding '-'s:" + s.getLongD() + ")");
        System.out.println(n.nucleotides(s.getSequenceList()));
    }



}
