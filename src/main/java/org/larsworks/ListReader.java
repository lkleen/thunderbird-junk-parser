package org.larsworks;

import java.util.Collection;
import java.util.Set;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 07.12.14
 *        Time: 15:22
 */
public interface ListReader<T> {

    public Collection<T> read(Set<String> lines);

}
