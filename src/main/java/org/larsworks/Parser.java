package org.larsworks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 31.07.14
 *        Time: 20:07
 */
public class Parser {

    private static final String BOUNCE = "bounce.";

    String parse (String line) {
        if (line.startsWith("Return-Path:")) {
            int startIndex = line.indexOf("@") + 1;
            int endIndex = line.indexOf(">");
            try {
                String domain = line.substring(startIndex, endIndex);
                domain = removeBounce(domain);
                return domain;
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("COULD NOT PARSE: " + line);
                return line;
            }
        } else {
            return "";
        }
    }

    String removeBounce(String domain) {
        return domain.startsWith(BOUNCE) ? domain.replaceAll(BOUNCE, "") : domain;
    }

}
