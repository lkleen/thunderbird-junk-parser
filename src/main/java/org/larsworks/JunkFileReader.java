package org.larsworks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:07
 */
public class JunkFileReader {

    private static final String FILENAME = "junk.txt";

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
        whitelist.add("email.easyJet.com");
        whitelist.add("cosmos-yachting.de");
        whitelist.add("cool-stream.to");
        whitelist.add("cosmos-yachting.de");
        whitelist.add("bounces.amazon.com");
        whitelist.add("bounce.linkedin.com");
        whitelist.add("bounce.immobilienscout24.de");
        whitelist.add("battle.net");
        whitelist.add("youtube-subscriptions.bounces.google.com");
        whitelist.add("xtrend-home.de");

        whitelist.add("studium.uni-hamburg.de");
        whitelist.add("service.eventim.de");
        whitelist.add("returnpath.immobilienscout24.de");
        whitelist.add("response.sourceforge.com");
        whitelist.add("newslecker.lieferheld.de");
        whitelist.add("news.bigpoint.com");
        whitelist.add("lvl-hessen.de");
        whitelist.add("insideapple.apple.com");
        whitelist.add("immonet.de");
        whitelist.add("gmail.com");
        whitelist.add("fusion-festival.de");
        whitelist.add("fluege-service.de");
        whitelist.add("gmail.com");
        whitelist.add("fedex.com");
        whitelist.add("easyjet.com");
        whitelist.add("gmail.com");
        whitelist.add("buhl-vertragskunden.de");
        whitelist.add("buhl-newsletter.de");
        whitelist.add("aol.com");

        return whitelist;
    }

    public void readAndOutput () {
        Parser parser = new Parser();
        Output output = new Output();

        Set<String> spamDomains = new TreeSet<String>();

        InputStream is = getClass().getClassLoader().getResourceAsStream(FILENAME);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines().forEach((String line) -> spamDomains.add(parser.parse(line)));

        spamDomains.removeAll(whitelist());
        spamDomains.forEach((String line) -> output.write(line));

    }

}
