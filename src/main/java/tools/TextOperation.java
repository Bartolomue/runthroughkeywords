package tools;

import tools.stemming.Stemming;
import tools.normalization.Normalize;
import tools.stopwords.StopWords;

/**
 * Created by Bartek on 5/13/2017.
 */
public interface TextOperation {
    void normalize(Normalize f);
    void doStemming(Stemming f);
    void removeStopWords(StopWords f);
}
