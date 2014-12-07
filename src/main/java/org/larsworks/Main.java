package org.larsworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:28
 */
public class Main {

    public static void main (String... args) {

        List<String> blacklistFiles = new ArrayList<>();
        blacklistFiles.add("junk1.txt");
        blacklistFiles.add("junk2.txt");

        FileReader fileReader = new FileReader();
        BlacklistReader blacklistReader = new BlacklistReader();
        WhitelistReader whitelistReader = new WhitelistReader();

        Set<String> blacklist = new TreeSet<>();

        blacklistFiles.forEach((String filename) -> blacklist.addAll(blacklistReader.read(fileReader.readFile(filename))));
        blacklist.removeAll(whitelistReader.read(fileReader.readFile("whitelist.txt")));

        Output output = new Output();

        blacklist.forEach((String line) -> output.write(line));
    }


}
