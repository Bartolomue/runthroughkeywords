package com.company.runthroughkeywords;

import tools.commonInterfaces.TextTransformStrategy;

/**
 * Created by MS on 22/05/2017.
 */
public class Document {
    String text;
    TextTransformStrategy currentStartegy;
    public Document(String iText)
    {
        this.text = iText;
    }

    public void LoadStrategy(TextTransformStrategy x)
    {
        currentStartegy = x;
    }

    public void ShowStemmedForm()
    {
        if(null != currentStartegy && text != null)
        {
            currentStartegy.PerformAndRead(text);
        }
    }
}
