package org.larsworks;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 30.04.15
 *        Time: 10:12
 */
public class DomainListTest {

    @Test
    public void test() {
        DomainList whitelist = new DomainList();
        DomainList blacklist = new DomainList();

        whitelist.add("larsworks.org");

        blacklist.add("hase.lqrsworks.org");
        blacklist.add("hase.larsworks.org");
        blacklist.add("peter.outlook.com");
        blacklist.add("peter.rznhg.com.to");

        blacklist.removeAllEndsWith(whitelist);

        assertTrue(blacklist.contains("hase.lqrsworks.org"));
        assertFalse(blacklist.contains("hase.larsworks.org"));
        assertTrue(blacklist.contains("peter.rznhg.com.to"));

    }

}
