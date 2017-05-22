package com.company.runthroughkeywords;

import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

import java.util.List;

/**
 * Created by MS on 22/05/2017.
 */
public class FastTestMorfologik {
    public static void main(String[] args) {
        PolishStemmer s = new PolishStemmer();
        List<WordData> x = s.lookup("żywotopisarstwie");
        List<WordData> x1 = s.lookup("bieganie");
        List<WordData> x2 = s.lookup("biegałem");

        List<WordData> x3 = s.lookup("urodzony");

        List<WordData> x4 = s.lookup("i");
        System.out.println(x1.get(0).getStem().toString());
        // watch out for unresolved multiple stems, they ar epreserved in the list
        // -> getstem and save it, don't rely on final retrieval

        /*for(WordData w:x3)
        {
            System.out.println(w.getStem());
        }*/
        //System.out.println(x3.get(0).getStem().toString());
    }
}
