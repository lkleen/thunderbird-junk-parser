package org.larsworks;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:25
 */
public class BlacklistReader implements ListReader {

    @Override
    public Set<String> read(Set<String> lines) {
        Set<String> set = new TreeSet<>();
        Parser parser = new Parser();
        lines.forEach((String line) -> set.add(parser.parse(line)));
        return set;
    }
}
