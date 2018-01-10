package ru.job4j.ControlQuestion;


/**
 * Class for find word inside another word
 *
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */

public class WordInsideAnotherWord {
    /**
     * @param origin word is contains sub
     * @param sub    word is inside origin
     * @return result of origin/sub words
     */
    public boolean contains(String origin, String sub) {
        boolean containsWord = false;
        char[] arrayOrigin = origin.toCharArray();
        char[] arraySub = sub.toCharArray();

        for (int outside = 0; outside < arrayOrigin.length - arraySub.length + 1; outside++) {
            int check = 0;
            for (int inside = 0; inside < arraySub.length; inside++) {
                if (arrayOrigin[outside + inside] != arraySub[inside]) {
                    break;
                }
                check++;
            }
            if (check == arraySub.length) {
                containsWord = true;
                break;
            }
        }
        return containsWord;
    }
}
