package com.company.runthroughkeywords;

import tools.normalization.RemoveSpecialChar;
import tools.normalization.RemoveWhiteSpaces;

/**
 * Hello world!
 *
 */


public class App 
{

    public static void main( String[] args )
    {

        String s = "lorem  ipsum   dolor \n sit. \"OR\\n\\nThe Central Site Engineering\\u2019s \\u201cfrontend\\u201d, where developers turn tosome string with 'the data i want' inside ";
        Text t = new Text(s);

        //tests
        t.print();
        t.normalize(new RemoveWhiteSpaces());
        t.print();

    }
}
