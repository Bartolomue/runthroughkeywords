package tools.stemmers;

import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import tools.commonInterfaces.TextTransformStrategy;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MS on 22/05/2017.
 */
public class MorfologikStemmer extends TextTransformStrategy {
    public void PerformAndRead(String textArgument)
    {
        //LinkedList<String> stmmedPhrases = PerformOperation(textArgument);
        MyAnalizer textAnalyzer = new MyAnalizer();
        LinkedList<String> stemmedList = new LinkedList<String>();
        LinkedList<String> myTokens = new LinkedList<String>();
        try {
            myTokens = textAnalyzer.ReturnTokens(textArgument);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PolishStemmer s = new PolishStemmer();


        for(int i=0; i<myTokens.size(); i++)
        {
            List<WordData> list1 = s.lookup(myTokens.get(i));
            System.out.println("Word: " + myTokens.get(i));
            for (WordData w : list1)
            {
                System.out.println(w.getStem());
            }
            System.out.println();
        }


    }

    public LinkedList<String> PerformOperation(String textArgument)
    {
        // Passed argument - either loaded text or fname
        // Create a new file containing stemmed text
        MyAnalizer textAnalyzer = new MyAnalizer();
        LinkedList<String> stemmedList = new LinkedList<String>();
        try {
            LinkedList<String> myTokens = textAnalyzer.ReturnTokens(textArgument);
            for(String x:myTokens)
            {
                System.out.println(x);
            }
            PolishStemmer mainStemmer = new PolishStemmer();
            stemmedList = stem(myTokens);
            return stemmedList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stemmedList;
    }

    private LinkedList<String> stem(LinkedList<String> initialTokens)
    {
        LinkedList<String> stemmedList = new LinkedList<String>();
        PolishStemmer mainStemmer = new PolishStemmer();
        for(String x:initialTokens)
        {
            List<WordData> curTok = mainStemmer.lookup(x);
            // System.out.println(curTok.get(0).getStem().toString());
            stemmedList.add(curTok.get(0).getStem().toString());

        }
        return stemmedList;
    }

    private class MyAnalizer extends Analyzer
    {

        @Override
        protected TokenStreamComponents createComponents(String s) {
            return new TokenStreamComponents(new WhitespaceTokenizer());
        }

        public LinkedList<String> ReturnTokens(final String text) throws IOException
        {
            LinkedList<String> tokens = new LinkedList<String>();

            MyAnalizer analyzer = new MyAnalizer();
            TokenStream stream = analyzer.tokenStream("field", new StringReader(text));

            CharTermAttribute termAtt = stream.addAttribute(CharTermAttribute.class);

            try
            {
                stream.reset();

                // add all tokens untill stream exhausted
                while(stream.incrementToken())
                {
                    tokens.add(termAtt.toString());
                }
                stream.end();

            }finally {
                stream.close();
            }

            return tokens;
        }
    }
}
