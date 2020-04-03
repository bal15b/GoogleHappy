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

        g.primaryFunction("f");

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

        g.primaryFunction("f");

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

    //test 3 makes sure the matrix is alligned correctly
    @Test
    public void test3()  throws FileNotFoundException
    {
    	//Test 3 By Nic Fornicola
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
        g.primaryFunction("f");
		
		assertEquals(g.p.path[1][1],0);
		assertEquals(g.p.path[1][2],1);
		assertEquals(g.p.path[1][3],1);
		assertEquals(g.p.path[1][4],1);
		assertEquals(g.p.path[1][5],0);
		assertEquals(g.p.path[1][6],0);
		assertEquals(g.p.path[1][7],0);
		assertEquals(g.p.path[1][8],0);
		assertEquals(g.p.path[1][9],0);

		assertEquals(g.p.path[2][1],0);
		assertEquals(g.p.path[2][2],0);
		assertEquals(g.p.path[2][3],0);
		assertEquals(g.p.path[2][4],0);
		assertEquals(g.p.path[2][5],1);
		assertEquals(g.p.path[2][6],0);
		assertEquals(g.p.path[2][7],1);
		assertEquals(g.p.path[2][8],0);
		assertEquals(g.p.path[2][9],0);

		assertEquals(g.p.path[3][1],0);
		assertEquals(g.p.path[3][2],1);
		assertEquals(g.p.path[3][3],0);
		assertEquals(g.p.path[3][4],0);
		assertEquals(g.p.path[3][5],0);
		assertEquals(g.p.path[3][6],0);
		assertEquals(g.p.path[3][7],0);
		assertEquals(g.p.path[3][8],1);
		assertEquals(g.p.path[3][9],1);

    }
	
    //test 4 makes sure the matrix is alligned correctly
    @Test
    public void test4()  throws FileNotFoundException
    {
    	//Test 4 By Nic Fornicola
    	GoogleHappy g = new GoogleHappy();

	//different preferences
    	String prefs = "Calvin,Bubba,Suzie,Billy,Ivanka,Snoopie,Donald\nBubba,Snoopie,Suzie,Donald,Billy,\nBlinkendorfer,Billy,Ivanka\nSuzie,Donald,Blinkendorfer,Bubba\nDonald,Bubba,Ivanka,Mitch\nMitch,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer,Snoopie\nIvanka,Donald,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
        g.primaryFunction("f");
		
		assertEquals(g.p.path[1][1],0);
		assertEquals(g.p.path[1][2],1);
		assertEquals(g.p.path[1][3],0);
		assertEquals(g.p.path[1][4],1);
		assertEquals(g.p.path[1][5],1);
		assertEquals(g.p.path[1][6],0);
		assertEquals(g.p.path[1][7],1);
		assertEquals(g.p.path[1][8],1);
		assertEquals(g.p.path[1][9],1);

		assertEquals(g.p.path[2][1],0);
		assertEquals(g.p.path[2][2],0);
		assertEquals(g.p.path[2][3],0);
		assertEquals(g.p.path[2][4],1);
		assertEquals(g.p.path[2][5],1);
		assertEquals(g.p.path[2][6],0);
		assertEquals(g.p.path[2][7],1);
		assertEquals(g.p.path[2][8],1);
		assertEquals(g.p.path[2][9],0);

		assertEquals(g.p.path[3][1],0);
		assertEquals(g.p.path[3][2],0);
		assertEquals(g.p.path[3][3],0);
		assertEquals(g.p.path[3][4],0);
		assertEquals(g.p.path[3][5],0);
		assertEquals(g.p.path[3][6],0);
		assertEquals(g.p.path[3][7],0);
		assertEquals(g.p.path[3][8],1);
		assertEquals(g.p.path[3][9],1);
		
    }

    //makes sure matrix includes people who are only mentioned
    @Test
    public void test5()  throws FileNotFoundException
    {
    	//Test 5 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B\nB,C,D,E\nE,D,A";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

       	assertEquals(g.p.path[1][1],0);
       	assertEquals(g.p.path[2][2],0);
       	assertEquals(g.p.path[3][3],0);
       	assertEquals(g.p.path[4][4],0);
       	assertEquals(g.p.path[5][5],0);

       	assertEquals(g.p.path[1][2],1);
       	assertEquals(g.p.path[2][3],1);
       	assertEquals(g.p.path[2][4],1);
       	assertEquals(g.p.path[2][5],1);
       	assertEquals(g.p.path[3][1],1);
       	assertEquals(g.p.path[3][5],1);
    }


    //test to see if it breaks with no people
    @Test
    public void test6()  throws FileNotFoundException
    {
    	//Test 6 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        assertEquals(g.count,0);

    }

    //makes sure the weighted values are entered into the array correctly
    @Test
    public void test7()  throws FileNotFoundException
    {
    	//Test 7 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B,C\nB,C\nC,B,A,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("t");

        assertEquals(g.p.path[1][1],0);
        assertEquals(g.p.path[2][2],0);
        assertEquals(g.p.path[3][3],0);
        assertEquals(g.p.path[4][4],0);

        assertEquals(g.p.path[1][2],1);
        assertEquals(g.p.path[1][3],2);

        assertEquals(g.p.path[2][3],1);

        assertEquals(g.p.path[3][2],1);
        assertEquals(g.p.path[3][1],2);
        assertEquals(g.p.path[3][4],3);

    }


    //tests to make sure you can't vote for yourself
    @Test
    public void test8()  throws FileNotFoundException
    {
    	//Test 8 By Ben Lamont
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,A,A,A\nB,B,B,B\nC,C,C,C\nD,D,D,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        for (int i = 1; i <= 4; i++)
        {
        	for (int j = 1; j <= 4; j++)
        	{
        		assertEquals(g.p.path[i][j],0);
        	}
        }


    }

}
