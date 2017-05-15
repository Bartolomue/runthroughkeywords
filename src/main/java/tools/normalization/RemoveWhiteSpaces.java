package tools.normalization;

import tools.stopwords.StopWords;

/**
 * Created by Bartek on 5/15/2017.
 */
public class RemoveWhiteSpaces extends Normalize {
    public String operation(String s) {
        return s.replaceAll("\\s+", " ").replaceAll("(\\\\n)+"," ")
                .replaceAll("\\\\u[0-9A-Ha-h]{4}", "");
    }
}
