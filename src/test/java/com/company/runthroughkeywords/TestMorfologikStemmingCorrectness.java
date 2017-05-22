package com.company.runthroughkeywords;

import junit.framework.TestCase;
import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

import java.io.IOException;
import java.util.List;

/**
 * Created by MS on 22/05/2017.
 */
public class TestMorfologikStemmingCorrectness extends TestCase
{
    public void testLexemes() throws IOException {

        PolishStemmer s = new PolishStemmer();
        List<WordData> x = s.lookup("żywotopisarstwo");
        System.out.println(x.get(0).toString());




    }


}
