package lucenereview;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Bartek on 5/22/2017.
 */
public class ReadingString {

    public static void main(String[] args) throws IOException {

        Analyzer analyzer = new StandardAnalyzer(); // or any other analyzer
        TokenStream ts = analyzer.tokenStream("content", new FileReader(Constants.PATH));
        // The Analyzer class will construct the Tokenizer, TokenFilter(s), and CharFilter(s),
        //   and pass the resulting Reader to the Tokenizer.
        OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);

        CharTermAttribute termAttr = ts.getAttribute(CharTermAttribute.class);

        try {
            ts.reset(); // Resets this stream to the beginning. (Required)
            while (ts.incrementToken()) {
                // Use AttributeSource.reflectAsString(boolean)
                // for token stream debugging.
                System.out.println("token: " + ts.reflectAsString(true));
                System.out.println("token string: " + termAttr.toString());
                System.out.println("token start offset: " + offsetAtt.startOffset());
                System.out.println("token end offset: " + offsetAtt.endOffset());
            }
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ts.close();
        }
    }
}
