package FastaTool;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Sequence {

    private final ArrayList<String> headers = new ArrayList<String>();
    private final ArrayList<String> sequences = new ArrayList<String>();

    private int shortest = MAX_VALUE;
    private int longest = MIN_VALUE;
    private int average = 0;

    private int shortD;
    private int longD;
    private int avgD;

    /**
     * read sequences from file in fastA format
     *
     * @param r
     */
    public void read(Reader r) throws IOException {

        BufferedReader br = new BufferedReader(r);
        String sequence = "";
        String line;

        // Schleife durch File bis Ende erreicht wurde
        // wenn Anfang Header erreicht wurde, speichert in headers
        // Sequence: einzelnen Zeilen aufaddieren
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '>') {
                headers.add(line);
                sequences.add(sequence); // wenn > erreicht wird, wird vorherige Sequence gespeichert und neue erzeugt
                sequence = "";
                // wenn erste Position nicht ">" --> Seqeunce erreicht
            } else {
                sequence += line;
            }
        }
        sequences.add(sequence); // letzte Sequence erstellt
        sequences.remove(0);
        br.close();
    }

    /**
     * get number of sequences
     *
     * @return size
     */
    public int size() {

        return headers.size();
    }

    /**
     * get the i-th header
     *
     * @param i
     * @return i-th header
     */
    public String getHeader(int i) {
        return headers.get(i); //faengt bei 0 an zu zaehelen
    }

    /**
     * get the i-th sequences
     *
     * @param i
     * @return i-th sequence
     */
    public String getSequence(int i) {

        return sequences.get(i);
    }

    public void computeValues(){

        Nucleotide n = new Nucleotide();

        int[] dashes = new int[sequences.size()];

        for(int j = 0; j < sequences.size(); j++){
            dashes[j] = n.count('-',getSequence(j));
        }

        for(int i = 0; i < sequences.size(); i++){

            if(getSequence(i).length() - dashes[i] < shortest){
                shortest = getSequence(i).length() - dashes[i];
                shortD = dashes[i];
            }

            if(getSequence(i).length()- dashes[i] > longest){
                longest = getSequence(i).length() - dashes[i];
                longD = dashes[i];
            }

            average = (average + (getSequence(i).length()- dashes[i]));
            avgD = (avgD + dashes[i]);
        }

        average = average / sequences.size();
        avgD = avgD / sequences.size();

    }


    public int getShortest() {
        return shortest;
       }

    public int getLongest() {
        return longest;
        }

    public int getAverage() {
        return average;
        }

    public int getShortD() {
        return shortD;
    }

    public int getLongD() {
        return longD;
    }

    public int getAvgD() {
        return avgD;
    }


    public ArrayList<String> getSequenceList() {
        return sequences;
    }
}



