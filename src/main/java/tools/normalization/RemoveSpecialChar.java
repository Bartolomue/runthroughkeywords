package tools.normalization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bartek on 5/15/2017.
 */
public class RemoveSpecialChar extends Normalize{
    public String operation(String s) {
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find())
        {
            return matcher.group(1);
        }

        return s;
    }
}
