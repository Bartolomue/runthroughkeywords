package lucenereview;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;

/**
 * Created by Bartek on 5/22/2017.
 */
public class RemoveShortWords extends Analyzer {
    protected TokenStreamComponents createComponents(String s) {
        final Tokenizer source = new WhitespaceTokenizer();
        //word shorter than five will not be displayed
        TokenStream result = new LengthFilter(source, 2, Integer.MAX_VALUE);
        return new TokenStreamComponents(source, result);
    }
}
