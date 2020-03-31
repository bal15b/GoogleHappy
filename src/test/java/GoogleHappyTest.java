import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import java.util.*;
import java.io.*;



/******************************************************************************
 *  Author : bal15b Ben Lamont
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do Somehting test
 ******************************************************************************/

public class GoogleHappyTest
{
    @Test
    public void test1()  throws FileNotFoundException
    {
    	//Test 1 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B\nB,E\nC,A,B,D,E\nD,C,E\nE,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction();

        int t = (int)(g.p.pagerank[1] * 100);
        assertEquals(t,17);

        t = (int)(g.p.pagerank[2] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[3] * 100);
        assertEquals(t,25);

        t = (int)(g.p.pagerank[4] * 100);
        assertEquals(t,46);

        t = (int)(g.p.pagerank[5] * 100);
        assertEquals(t,49);
    }

    @Test
    public void test2()  throws FileNotFoundException
    {
    	//Test 2 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction();

		int t = (int)(g.p.pagerank[1] * 100);
        assertEquals(t,15);

        t = (int)(g.p.pagerank[2] * 100);
        assertEquals(t,31);

        t = (int)(g.p.pagerank[3] * 100);
        assertEquals(t,18);

        t = (int)(g.p.pagerank[4] * 100);
        assertEquals(t,19);

        t = (int)(g.p.pagerank[5] * 100);
        assertEquals(t,37);

        t = (int)(g.p.pagerank[6] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[7] * 100);
        assertEquals(t,26);

        t = (int)(g.p.pagerank[8] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[9] * 100);
        assertEquals(t,28);
    }

}
