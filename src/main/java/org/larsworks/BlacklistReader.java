package org.larsworks;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:25
 */
public class BlacklistReader implements ListReader<Domain> {

    @Override
    public Set<Domain> read(Set<String> lines) {
        Set<Domain> set = new TreeSet<>();
        Parser parser = new Parser();

        lines.forEach((String line) -> {
            String domain = parser.parse(line);
            if (domain.length() > 0) {
                set.add(new Domain(domain));
            }
        });
        return set;
    }
}
