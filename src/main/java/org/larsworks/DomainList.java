package org.larsworks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 30.04.15
 *        Time: 09:59
 */
public class DomainList extends ArrayList<Domain> {

    public void add(String domain) {
        add(new Domain(domain));
    }

    public boolean contains(String domain) {
        return contains(new Domain(domain));
    }

    public void removeAllEndsWith(DomainList endings) {
        endings.forEach((Domain ending) -> removeEndWith(ending));
    }

    public void removeEndWith(Domain domain) {
        removeIf((Domain element) -> element.endsWith(domain));
    }

}
