package org.larsworks;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:27
 */
public class WhitelistReader implements ListReader<Domain> {
    @Override
    public DomainList read(Set<String> lines) {
        DomainList list = new DomainList();
        lines.forEach((String line) -> list.add(new Domain(line.trim())));
        return list;
    }
}
