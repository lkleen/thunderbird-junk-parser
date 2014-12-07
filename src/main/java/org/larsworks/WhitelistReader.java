package org.larsworks;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:27
 */
public class WhitelistReader implements ListReader {
    @Override
    public Set<String> read(Set<String> lines) {
        Set<String> set = new TreeSet<>();
        lines.forEach((String line) -> set.add(line.trim()));
        return set;
    }
}
