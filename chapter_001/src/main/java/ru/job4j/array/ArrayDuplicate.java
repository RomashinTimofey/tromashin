package ru.job4j.array;

import java.util.ArrayList;

/**
 * Class for delete duplicate in array
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    /**
     *
     * @param array for clean duplicate
     * @return cleaned array
     */
    public String[] remove(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(String item:array) {
            if( !(arrayList.contains(item)) ) {
                    arrayList.add(item);
                }
        }
        return arrayList.toArray(new String[0]);
    }
}
