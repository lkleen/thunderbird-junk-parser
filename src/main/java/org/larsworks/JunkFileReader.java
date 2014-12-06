package org.larsworks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:07
 */
public class JunkFileReader {

    private static final List<String> files = new ArrayList<>();

    static {
        files.add("junk1.txt");
        files.add("junk2.txt");
    }

    public SortedSet<String> whitelist() {
        SortedSet<String> whitelist = new TreeSet<>();
        whitelist.add("thomann.de");
        whitelist.add("steinberg.de");
        whitelist.add("slidesharemail.com");
        whitelist.add("slidesharenewsletter.com");
        whitelist.add("netbuild.net");
        whitelist.add("more-thing.com");
        whitelist.add("heroku.com");
        whitelist.add("redhat.com");
        whitelist.add("games.gamigo.com");
        whitelist.add("fernsehlotterie.de");
        whitelist.add("facebookmail.com");
        whitelist.add("easyJet.com");
        whitelist.add("cosmos-yachting.de");
        whitelist.add("cool-stream.to");
        whitelist.add("cosmos-yachting.de");
        whitelist.add("amazon.com");
        whitelist.add("linkedin.com");
        whitelist.add("immobilienscout24.de");
        whitelist.add("battle.net");
        whitelist.add("google.com");
        whitelist.add("xtrend-home.de");

        whitelist.add("studium.uni-hamburg.de");
        whitelist.add("service.eventim.de");
        whitelist.add("response.sourceforge.com");
        whitelist.add("newslecker.lieferheld.de");
        whitelist.add("bigpoint.com");
        whitelist.add("lvl-hessen.de");
        whitelist.add("apple.com");
        whitelist.add("immonet.de");
        whitelist.add("gmail.com");
        whitelist.add("fusion-festival.de");
        whitelist.add("fluege-service.de");
        whitelist.add("gmx.com");
        whitelist.add("gmx.de");
        whitelist.add("fedex.com");
        whitelist.add("easyjet.com");
        whitelist.add("gmail.com");
        whitelist.add("buhl-vertragskunden.de");
        whitelist.add("buhl-newsletter.de");
        whitelist.add("fanatec-shop.com");
        whitelist.add("xing.com");
        whitelist.add("aol.com");
        whitelist.add("aol.com");
        whitelist.add("aol.com");
        whitelist.add("aol.com");




        return whitelist;
    }

    public void readAndOutput () {
        Parser parser = new Parser();
        Output output = new Output();

        Set<String> spamDomains = new TreeSet<String>();

        files.forEach((String filename) -> {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.lines().forEach((String line) -> spamDomains.add(parser.parse(line)));
        });

        spamDomains.removeAll(whitelist());
        spamDomains.forEach((String line) -> output.write(line));

    }

}


