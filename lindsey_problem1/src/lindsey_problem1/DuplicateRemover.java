package lindsey_problem1;

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Iterator;

import java.util.LinkedHashSet;

public class DuplicateRemover {

    private LinkedHashSet<String> uniqueWords;

    public DuplicateRemover()

    {

        uniqueWords = new LinkedHashSet<>();

    }

    public void remove(String dataFile) {

        File f1 = new File(dataFile);

        FileReader fr = null;

        BufferedReader br = null;

        try {

            fr = new FileReader(f1);

            String[] words = null;

            String s;

            br = new BufferedReader(fr);

            while ((s = br.readLine()) != null)

            {

                s = s.replaceAll("[.,?!)(]", " ");

                words = s.split("\\s+");

                for (String word : words) {

                    uniqueWords.add(word.toLowerCase());

                }

            }

        } catch (IOException ex) {

            System.err.println(ex.getMessage());

        } finally {

            //close everything that's opened

            try {

                if (fr != null) {

                    fr.close();

                }

                if (br != null) {

                    br.close();

                }

            } catch (IOException ex) {

            }

        }

    }

    public void write(String outputFile) {

        BufferedWriter out = null;

        Iterator it = uniqueWords.iterator();

        try {

            out = new BufferedWriter(new FileWriter(outputFile));

            while (it.hasNext()) {

                out.write(it.next().toString());

                out.newLine();

            }

        } catch (IOException ex) {

        } finally {

            try {

                if(out!=null)

                    out.close();

            } catch (IOException ex) {

            }

        }

    }

}