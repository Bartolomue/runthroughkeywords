package com.company.runthroughkeywords;

import tools.normalization.Normalize;
import tools.stemming.Stemming;
import tools.stopwords.StopWords;
import tools.TextOperation;

/**
 * Created by Bartek on 5/13/2017.
 */
public class Text implements TextOperation {

    public Text(String content) {
        this.content = content;
    }

    public String content;


    public void normalize(Normalize f) {
        content = f.operation(content);
    }

    public void doStemming(Stemming f) {
        content = f.operation(content);
    }

    public void removeStopWords(StopWords f) {
        content = f.operation(content);
    }

    public void print()
    {
        System.out.println(content);
    }
}
