package org.larsworks;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:09
 */
public class Output {

    void write (String str) {
        if (str.length() > 0)
            System.out.println(str);
    }

}
