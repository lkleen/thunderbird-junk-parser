package org.larsworks;

import java.util.*;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:28
 */
public class Main {

    static final String WHITELIST_FILE = "whitelist.txt";

    public static void main (String... args) {

        List<String> blacklistFiles = new ArrayList<>();
        blacklistFiles.add("junk1.txt");
        blacklistFiles.add("junk2.txt");
        blacklistFiles.add("junk3.txt");

        FileReader fileReader = new FileReader();
        BlacklistReader blacklistReader = new BlacklistReader();
        WhitelistReader whitelistReader = new WhitelistReader();

        DomainList blacklist = new DomainList();
        DomainList whiteList = whitelistReader.read(fileReader.readFile(WHITELIST_FILE));

        blacklistFiles.forEach((String filename) -> blacklist.addAll(blacklistReader.read(fileReader.readFile(filename))));
        blacklist.removeAllEndsWith(whiteList);

        Output output = new Output();

        SortedSet<Domain> domains = new TreeSet<>(blacklist);
        domains.forEach((Domain domain) -> output.write(domain.domain));
    }


}
