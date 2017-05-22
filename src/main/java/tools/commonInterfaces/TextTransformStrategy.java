package tools.commonInterfaces;

import java.util.LinkedList;

/**
 * Created by MS on 22/05/2017.
 */
public abstract class TextTransformStrategy {
    abstract public LinkedList<String> PerformOperation(String text);
    abstract public void PerformAndRead(String text);

}
