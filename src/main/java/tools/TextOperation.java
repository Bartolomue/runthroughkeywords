package tools;

import tools.normalization.Normalize;
import tools.stopwords.StopWords;

/**
 * Created by Bartek on 5/13/2017.
 */
public interface TextOperation {
    void normalize(Normalize f);

    void removeStopWords(StopWords f);
}
