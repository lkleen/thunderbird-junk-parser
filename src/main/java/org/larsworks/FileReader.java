package org.larsworks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:19
 */
public class FileReader {

    public Set<String> readFile(String filename) {
        Set<String> set = new TreeSet<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines().forEach((String line) -> set.add(line));
        return set;
    }

}
