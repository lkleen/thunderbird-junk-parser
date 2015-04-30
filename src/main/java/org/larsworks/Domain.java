package org.larsworks;


/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 21.04.15
 *        Time: 19:21
 */
public class Domain implements Comparable<Domain> {

    final String domain;

    public Domain(String domain) {
        if (domain == null || domain.length() == 0) {
            throw new RuntimeException("domain cannot be null");
        }
        this.domain = domain;
    }

    public boolean endsWith(Domain ending) {
        return domain.endsWith(ending.domain);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domain)) return false;

        Domain domain1 = (Domain) o;

        if (domain != null ? !domain.equals(domain1.domain) : domain1.domain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return domain != null ? domain.hashCode() : 0;
    }

    @Override
    public String toString() {
        return domain;
    }

    @Override
    public int compareTo(Domain o) {
        return domain.compareTo(o.domain);
    }
}
