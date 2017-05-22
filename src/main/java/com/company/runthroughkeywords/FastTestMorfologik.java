package com.company.runthroughkeywords;

import tools.stemmers.MorfologikStemmer;

/**
 * Created by MS on 22/05/2017.
 */
public class FastTestMorfologik {
    public static void main(String[] args) {
        /*PolishStemmer s = new PolishStemmer();
        List<WordData> x = s.lookup("żywotopisarstwie");
        List<WordData> x1 = s.lookup("bieganie");
        List<WordData> x2 = s.lookup("biegałem");

        List<WordData> x3 = s.lookup("urodzony");

        List<WordData> x4 = s.lookup("i");
        System.out.println(x1.get(0).getStem().toString());
        // watch out for unresolved multiple stems, they ar epreserved in the list
        // -> getstem and save it, don't rely on final retrieval

        for(WordData w:x3)
        {
            System.out.println(w.getStem());
        }
        //System.out.println(x3.get(0).getStem().toString());
        */
        /*MorfologikStemmer test1 = new MorfologikStemmer();
        PolishStemmer s = new PolishStemmer();
        //List<WordData> x4 = s.lookup("koty");
        //System.out.println(x4.get(0).getStem().toString());
        LinkedList<String> wordTest1 = new LinkedList<String>();
        wordTest1.add("koty");
        wordTest1.add("kota");
        wordTest1.add("pierogi");
        wordTest1.add("pojemnościowe");
        wordTest1.add("mierzalne");
        wordTest1.add("Alicji");
        for(int i=0; i<wordTest1.size(); i++)
        {
            List<WordData> list1 = s.lookup(wordTest1.get(i));
            System.out.println("Word: " + wordTest1.get(i));
            for (WordData w : list1)
            {
                System.out.println(w.getStem());
            }
            System.out.println();
        }



        LinkedList<String> wordList = test1.PerformOperation("Ala ma kota a kot ma ale");
        for(String x:wordList)
        {
            System.out.println();
        }
        */

        //MorfologikStemmer test1 = new MorfologikStemmer();
        String textTest1 = "te długie operacje i błąche słowa powinny zostać uproszczone do form bazowych";
        //test1.PerformAndRead("te długie operacje i błąche słowa powinny zostać uproszczone do form bazowych ");

        Document doc1 = new Document(textTest1);
        doc1.LoadStrategy(new MorfologikStemmer());
        doc1.ShowStemmedForm();

    }
}
