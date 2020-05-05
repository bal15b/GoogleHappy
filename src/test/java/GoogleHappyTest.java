import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;	
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;
import java.util.*;
import java.io.*;




/******************************************************************************
 *  Author : bal15b Ben Lamont
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do Somehting test
 ******************************************************************************/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleHappyTest
{
	/*
	@Test
    public void atest1()  throws FileNotFoundException
    {
    	//Test 1 By Ben Lamont
		System.out.println("\n------TEST 1------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "A,B\nB,E\nC,A,B,D,E\nD,C,E\nE,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);
		/*
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

/*
    @Test
    public void btest2()  throws FileNotFoundException
    {
    	//Test 2 By Ben Lamont
		System.out.println("\n------TEST 2------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;

        g.primaryFunction(0);

		int t = (int)(g.p.pagerank[1] * 100);
        assertEquals(t,0);

        t = (int)(g.p.pagerank[2] * 100);
        assertEquals(t,30);

        t = (int)(g.p.pagerank[3] * 100);
        assertEquals(t,7);
    }

    //test 3 makes sure the matrix is alligned correctly
    @Test
    public void ctest3()  throws FileNotFoundException
    {
    	//Test 3 By Nic Fornicola
		System.out.println("\n------TEST 3------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
				g.teamsize = 3;

        g.primaryFunction(0);
		
		assertEquals(g.p.path[1][1],0);
		assertEquals(g.p.path[1][2],1);
		assertEquals(g.p.path[1][3],2);
		assertEquals(g.p.path[1][4],3);
		assertEquals(g.p.path[1][5],0);
		assertEquals(g.p.path[1][6],0);
		assertEquals(g.p.path[1][7],0);
		assertEquals(g.p.path[1][8],0);
		assertEquals(g.p.path[1][9],0);

    }
	
    //test 4 makes sure the matrix is alligned correctly
    @Test
    public void dtest4()  throws FileNotFoundException
    {
    	//Test 4 By Nic Fornicola
		System.out.println("\n------TEST 4------");
    	GoogleHappy g = new GoogleHappy();

	//different preferences
    	String prefs = "Calvin,Bubba,Suzie,Billy,Ivanka,Snoopie,Donald\nBubba,Snoopie,Suzie,Donald,Billy,\nBlinkendorfer,Billy,Ivanka\nSuzie,Donald,Blinkendorfer,Bubba\nDonald,Bubba,Ivanka,Mitch\nMitch,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer,Snoopie\nIvanka,Donald,Suzie";
		g.test = 1;
    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
        g.primaryFunction(0);
		

		assertEquals(g.p.path[3][1],0);
		assertEquals(g.p.path[3][2],0);
		assertEquals(g.p.path[3][3],0);
		assertEquals(g.p.path[3][4],0);
		assertEquals(g.p.path[3][5],0);
		assertEquals(g.p.path[3][6],0);
		assertEquals(g.p.path[3][7],0);
		assertEquals(g.p.path[3][8],1);
		assertEquals(g.p.path[3][9],2);
		
    }

	
    //makes sure matrix includes people who are only mentioned
    @Test
    public void etest5()  throws FileNotFoundException
    {
    	//Test 5 By Ben Lamont
		System.out.println("\n------TEST 5------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "A,B\nB,C,D,E\nE,D,A";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(0);

       	assertEquals(g.p.path[1][1],0);
       	assertEquals(g.p.path[2][2],0);
       	assertEquals(g.p.path[3][3],0);
       	assertEquals(g.p.path[4][4],0);
       	assertEquals(g.p.path[5][5],0);
    }


	@Test
    public void ftest6()  throws FileNotFoundException
    {
    	//Test 6 By Ben Lamont
		System.out.println("\n------TEST 6------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        //g.primaryFunction(1);

        //assertEquals(g.count,0);

    }

    //makes sure the weighted values are entered into the array correctly
     @Test
    public void gtest7()  throws FileNotFoundException
    {
    	//Test 7 By Ben Lamont
		System.out.println("\n------TEST 7------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "A,B,C\nB,C\nC,B,A,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(0);

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
    public void htest8()  throws FileNotFoundException
    {
		
    	//Test 8 By Ben Lamont
		System.out.println("\n------TEST 8------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;		
    	String prefs = "A,A,A,A\nB,B,B,B\nC,C,C,C\nD,D,D,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);
		
        for (int i = 1; i <= 4; i++)
        {
        	for (int j = 1; j <= 4; j++)
        	{
        		//assertEquals(g.p.path[i][j],0);
        	}
        }


    }


    //tests to make sure it doesn't break on an empty preference
    @Test
    public void itest9()  throws FileNotFoundException
    {
    	//Test 9 By Ben Lamont
		System.out.println("\n------TEST 9------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "A,B,C\nB,C\nC,B,,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);

        //assertEquals(g.p.path[3][4],1);
    }


    //tests to make sure weighted prefs are distributed properly
    @Test
    public void jtest10()  throws FileNotFoundException
    {
    	//Test 10 By Ben Lamont
		System.out.println("\n------TEST 10------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "1,2,3,4,5,6,7,8,9\n2,1,3,4,5,6,7,8,9\n3,1,2,4,5,6,7,8,9\n4,1,2,3,5,6,7,8,9\n5,1,2,3,4,6,7,8,9\n6,1,2,3,4,5,7,8,9\n7,1,2,3,4,5,6,8,9\n8,1,2,3,4,5,6,7,9\n9,1,2,3,4,5,6,7,8";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);


        for (int i = 1; i < 9; i++)
        {
        	//assertTrue(g.p.pagerank[i] > g.p.pagerank[i+1]);
        }

    }
	
	@Test
    public void ktest11()  throws FileNotFoundException
    {
		
	//Test 11 By Nic Fornicola
	System.out.println("\n------TEST 11------");
    	GoogleHappy g = new GoogleHappy();
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("AA",0);
		testHash.put("BB",1);
		testHash.put("CC",2);
		testHash.put("DD",3);
		testHash.put("EE",4);
		String allNames[] = new String [5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 1);
		
		assertEquals(allNames[0],"AA");
		assertEquals(allNames[1],"BB");
		assertEquals(allNames[2],"CC");
		assertEquals(allNames[3],"DD");
		assertEquals(allNames[4],"EE");
		

    }
	
	@Test
    public void ltest12()  throws FileNotFoundException
    {
		
	//Test 12 By Nic Fornicola
	System.out.println("\n------TEST 12------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("C",0);
		testHash.put("E",1);
		testHash.put("A",2);
		testHash.put("D",3);
		testHash.put("B",4);
		String allNames[] = new String[5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 0);
		
		assertEquals(allNames[0],"A");
		assertEquals(allNames[1],"B");
		assertEquals(allNames[2],"C");
		assertEquals(allNames[3],"D");
		assertEquals(allNames[4],"E");


    }
	
	@Test
    public void mtest13()  throws FileNotFoundException
    {
	
	//Test 13 By Nic Fornicola
	System.out.println("\n------TEST 13------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("1",0);
		testHash.put("2",0);
		testHash.put("3",0);
		testHash.put("4",0);
		testHash.put("5",0);
		String allNames[] = new String[5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 0);
		
		assertEquals(allNames[0],"1");
		assertEquals(allNames[1],"2");
		assertEquals(allNames[2],"3");
		assertEquals(allNames[3],"4");
		assertEquals(allNames[4],"5");
	

    }
	
	@Test
    public void ntest14()  throws FileNotFoundException
    {
		
	//Test 14 By Nic Fornicola
	System.out.println("\n------TEST 14------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("11",0);
		testHash.put("22",0);
		testHash.put("33",0);
		testHash.put("44",0);
		testHash.put("55",0);
		testHash.put("66",0);
		testHash.put("77",0);
		testHash.put("88",0);
		testHash.put("99",0);
		testHash.put("100",0);
		String allNames[] = new String[5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 0);
		
		assertEquals(allNames[0],"11");
		assertEquals(allNames[1],"22");
		assertEquals(allNames[2],"33");
		assertEquals(allNames[3],"44");
		assertEquals(allNames[4],"55");
		assertEquals(allNames[5],"66");
		assertEquals(allNames[6],"77");
		assertEquals(allNames[7],"88");
		assertEquals(allNames[8],"99");
		assertEquals(allNames[9],"100");	

    }
	
	@Test
    public void otest15()  throws FileNotFoundException
    {
		
	//Test 15 By Nic Fornicola
	System.out.println("\n------TEST 15------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("a",0);
		testHash.put("e",1);
		testHash.put("h",2);
		testHash.put("k",3);
		testHash.put("n",4);

		String allNames[] = new String[5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 0);
		
		assertEquals(allNames[0],"a");
		assertEquals(allNames[1],"e");
		assertEquals(allNames[2],"h");
		assertEquals(allNames[3],"k");
		assertEquals(allNames[4],"n");	

    }

	
	@Test
    public void ptest16()  throws FileNotFoundException
    {
		//test 16 by Ben Lamont
		System.out.println("\n------TEST 16------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
		String prefs = "A,A,A,A\nB,B,B,B\nC,C,C,C\nD,D,D,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
		g.primaryFunction(1);

		assertEquals(g.c[0].name,"A");
		assertEquals(g.c[1].name,"B");
		assertEquals(g.c[2].name,"C");
		assertEquals(g.c[3].name,"D");

	}
	
	@Test
    public void qest17()  throws FileNotFoundException
    {
		//test 16 by Ben Lamont
		System.out.println("\n------TEST 17------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
		String prefs = "A,A,A,A\nB,B,B,B\nC,C,C,D\nE,E,E,E";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);

		assertEquals(g.c[0].name,"A");
		assertEquals(g.c[1].name,"B");
		assertEquals(g.c[2].name,"C");
		assertEquals(g.c[3].name,"E");
		assertEquals(g.c[4].name,"D");
	}

	@Test
    public void rtest18()  throws FileNotFoundException
    {
		//test 16 by Ben Lamont
		System.out.println("\n------TEST 18------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
		String prefs = "A,A,A,A\nB,B,B,B\nC,C,,E\nD,D,D,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);

		assertEquals(g.c[0].name,"A");
		assertEquals(g.c[1].name,"B");
		assertEquals(g.c[2].name,"C");
		assertEquals(g.c[3].name,"D");
		assertEquals(g.c[4].name,"");
		assertEquals(g.c[5].name,"E");

	}

	@Test
    public void stest19()  throws FileNotFoundException
    {
		//test 16 by Ben Lamont
		System.out.println("\n------TEST 19------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
		String prefs = "B,A";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(0);

		assertEquals(g.c[0].name,"A");
	}

	@Test
    public void ttest20()  throws FileNotFoundException
    {
		//test 20 by Ben Lamont
		System.out.println("\n------TEST 20------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
		String prefs = "A,BC\nB,C\nC,A";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction(0);

		assertEquals(g.c[0].name,"BC");
		assertEquals(g.c[1].name,"B");
		assertEquals(g.c[2].name,"C");
		assertEquals(g.c[3].name,"BC");

	}
	
	@Test
	public void utest21()  throws FileNotFoundException
    {
		//test 21 by Nic
		System.out.println("\n------TEST 21------");
    	GoogleHappy g = new GoogleHappy();
		
		String prefs = "Nic,Eden,Jane,Xander\nAshley,Mya,Xander\nXander,Gerry,Nic,Mya\nMya,Xander,Josh,Eden\nEden,Nic,Ashley,Mya\nJosh,Carter,Jane\nCarter,Josh,Mya,Ashley\nJane,Ashley,Eden\nGerry,Nic,Mya,Carter";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
		g.primaryFunction(1);
			
		assertEquals(g.teams[0].name,"Jane");
		
		
	}
	
	@Test
	public void vtest22()  throws FileNotFoundException
    {
		//test 22 by Nic
		System.out.println("\n------TEST 22------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Gerry,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
				System.out.println("");
		
		
		g.teamsize = 3;
		//g.primaryFunction(1);
			
		//assertEquals(g.teams[0].name,"Eden");


	}
	
	
		
	
	@Test
	public void wtest23()  throws FileNotFoundException
    {
		//test 23 by Nic
		System.out.println("\n------TEST 23------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		/*
		g.teamsize = 3;
		g.primaryFunction(1);
		
		
		assertEquals(g.teams[0].name,"Mya");
		assertEquals(g.teams[1].name,"Eden");
		assertEquals(g.teams[2].name,"Ashley");
		assertEquals(g.teams[3].name,"Xander");
		assertEquals(g.teams[4].name,"Gerry");
		assertEquals(g.teams[5].name,"Josh");
		assertEquals(g.teams[6].name,"Nic");
		assertEquals(g.teams[7].name,"Carter");
		assertEquals(g.teams[8].name,"Jane");
		
	}
	
	@Test
	public void xtest24()  throws FileNotFoundException
    {
		//test 24 by Nic
		System.out.println("\n------TEST 24------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.primaryFunction(0);
		
		assertEquals(g.getUserInfo("Nic"),-1);
		assertEquals(g.getUserInfo("Eden"),5);
		assertEquals(g.getUserInfo("Ashley"),2);
		

	}
	
	@Test
	public void ytest25()  throws FileNotFoundException
    {
		//test 25 by Nic
		System.out.println("\n------TEST 25------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.primaryFunction(0);	
		
		assertEquals(g.getUserInfo("Xander"),3);
		assertEquals(g.getUserInfo("Gerry"),9);
		assertEquals(g.getUserInfo("Mya"),4);
		assertEquals(g.getUserInfo("Carter"),7);

	}
	
	@Test
    public void test26()  throws FileNotFoundException
    {
    	//Test 26 By Ben Lamont
		System.out.println("\n------TEST 26------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "Eden";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction(0);

        assertEquals(g.count,1);

    }
	
	//tests to make sure it doesn't break on an empty preference
    @Test
    public void zatest27()  throws FileNotFoundException
    {
    	//Test 27 By Ben Lamont
		System.out.println("\n------TEST 27------");
    	GoogleHappy g = new GoogleHappy();
		g.test = 1;
    	String prefs = "A,B,,C\nB,C\nC,B,,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
        g.primaryFunction(1);

        assertEquals(g.p.path[3][4],2);
    }
	
	@Test
	public void zbtest28()  throws FileNotFoundException
    {
		//test 28 by Nic
		System.out.println("\n------TEST 28------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.primaryFunction(0);	
		
		System.out.println(g.testUser.name);
		assertEquals(g.testUser.name, "testUser");
		assertEquals(g.testUser.id, -1);
		

	}
	
	@Test
	public void zctest29()  throws FileNotFoundException
    {
		//test 29 by Nic
		System.out.println("\n------TEST 29------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.primaryFunction(0);	
		
		System.out.println(g.testUser.happiness);
		assertEquals(g.testUser.happiness-0.0 < .001, g.testUser.happiness-0.0 < .001);		

	}
	
	@Test
	public void zctest30()  throws FileNotFoundException
    {
		//test 30 by Nic
		System.out.println("\n------TEST 30------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{""});
				
		//assertEquals(0.0-was < .001 , 0.0-was < .001);
	
		g.testUser.setHappiness(99.0);
		assertEquals(g.testUser.happiness-0.0 < .001, 99.0-0.0 < .001);

		

	}
	@Test
	public void nameEqualityAfterSort1()  throws FileNotFoundException
    {
		//test 31 by Nic
		System.out.println("\n------TEST 31------");
    	GoogleHappy g = new GoogleHappy();
		
		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

		g.teamsize = 3;
		g.primaryFunction(1);

		assertEquals(g.teams[0].name,"Eden");




		
	}
	
	@Test
	public void nameEqualityAfterSort2()  throws FileNotFoundException
    {
		//test 32 by Nic
		System.out.println("\n------TEST 32------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
		g.primaryFunction(1);

		System.out.println("");
		for(int i = 0; i < g.teams.length; i++)
		{System.out.println(g.teams[i].name);
		System.out.println(g.teams[i].rank);}
		
		assertEquals(g.teams[4].name,"Nic");

	}
	
	@Test
	public void pageRankEquality1()  throws FileNotFoundException
    {
		//test 33 by Nic
		System.out.println("\n------TEST 33------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
		g.primaryFunction(1);
	
		
		assertEquals(g.teams[0].rank-0.2182098765432099 < .00001, 0.2182098765432099-0.2182098765432099 < .00001);
		assertEquals(g.teams[1].rank-0.22083333333333335 < .00001, 0.22083333333333335-0.22083333333333335 < .00001);
		assertEquals(g.teams[2].rank-0.1814814814814815 < .00001, 0.1814814814814815-0.1814814814814815 < .00001);
	}
	
	@Test
	public void pageRankEquality2()  throws FileNotFoundException
    {
		//test 34 by Nic
		System.out.println("\n------TEST 34------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
		g.primaryFunction(1);
	
		assertEquals(g.teams[3].rank-0.20246913580246917 < .00001, 0.20246913580246917-0.20246913580246917 < .00001);
		assertEquals(g.teams[4].rank-0.2523148148148148 < .00001, 0.2523148148148148-0.2523148148148148 < .00001);
		assertEquals(g.teams[5].rank-0.2916666666666667 < .00001, 0.2916666666666667-0.2916666666666667 < .00001);
	}
	
	@Test
	public void pageRankEquality3()  throws FileNotFoundException
    {
		//test 35 by Nic
		System.out.println("\n------TEST 35------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.teamsize = 3;
		g.primaryFunction(1);	
		
		assertEquals(g.teams[6].rank-0.24444444444444446 < .00001, 0.24444444444444446-0.24444444444444446 < .00001);
		assertEquals(g.teams[7].rank-0.2811728395061729 < .00001, 0.2811728395061729-0.2811728395061729 < .00001);
		assertEquals(g.teams[8].rank-0.3074074074074074 < .00001, 0.3074074074074074-0.3074074074074074 < .00001);
	}

	@Test
	public void zdtest36()  throws FileNotFoundException
    {
		//test 36 by Ben
		System.out.println("\n------TEST 36------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{"-v","4"} );
				
		assertEquals(g.iterations[0].verbosity, 4);


		

	}

	@Test
	public void zetest37()  throws FileNotFoundException
    {
		//test 37 by Ben
		System.out.println("\n------TEST 37------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{"-p","0"} );
				
		assertEquals(g.iterations[0].proposal, 0);


		

	}
	
	@Test
	public void zftest38()  throws FileNotFoundException
    {
		//test 38 by Ben
		System.out.println("\n------TEST 38------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{""});
				
		assertEquals(g.iterations[0].proposal, 0);


		

	}
	@Test
	public void zgtest39()  throws FileNotFoundException
    {
		//test 39 by Ben
		System.out.println("\n------TEST 39------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{""});
				
		assertEquals(g.iterations[0].teamsize, 3);

		

	}
	@Test
	public void zhtest40()  throws FileNotFoundException
    {
		//test 40 by Nic
		System.out.println("\n------TEST 40------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{"-p","0", "-t", "3", "-v","1"} );
				
		assertEquals(g.iterations[0].teamsize, 3);
		assertEquals(g.iterations[0].proposal, 0);
		assertEquals(g.iterations[0].verbosity, 1);



		

	}
	
	@Test
	public void testTeamSizeOfThree1()  throws FileNotFoundException
    {
		//test 41 by Nic
		System.out.println("\n------TEST 40------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh";
		
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		g.main(new String[]{"-p","0", "-t", "3", "-v","1"} );
				
		assertEquals(g.iterations[0].teamsize, 3);
		assertEquals(g.iterations[0].proposal, 0);
		assertEquals(g.iterations[0].verbosity, 1);
	}

	
	@Test
	public void testTeamSizeOfFour1()  throws FileNotFoundException
    {
		//test 42 by Nic
		System.out.println("\n------testTeamSizeOfFour1------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley,Mya\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh\nAubrey,Madison,Caleb\nMadison,Jane,Carter\nCaleb,Josh,Aubrey";
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		String[] options = new String[] {"-p","0", "-t", "4", "-v","1"};
		
		g.main(options);
		assertEquals(g.iterations[0].proposal, 0);
		assertEquals(g.iterations[0].teamsize, 4);
		assertEquals(g.iterations[0].verbosity, 1);
	}
	
	@Test
	public void testTeamSizeOfFour2()   throws FileNotFoundException
    {
		//test 43 by Nic
		System.out.println("\n------testTeamSizeOfFour2------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Madison,Xander,Jane\nAshley,Eden,Aubrey,Xander\nXander,Gerry,Ashley,Mya\nMya,Caleb,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane,Eden\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh\nAubrey,Madison,Caleb\nMadison,Jane,Carter\nCaleb,Josh,Aubrey";
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		String[] options = new String[] {"-p","1", "-t", "4", "-v","1"};
		
		g.main(options);
		
		assertEquals(g.iterations[0].proposal, 1);
		assertEquals(g.iterations[0].teamsize, 4);
		assertEquals(g.iterations[0].verbosity, 1);
	}
	
	@Test
	public void testTeamSizeOfFive1()   throws FileNotFoundException
    {
		//test 44 by Nic
		System.out.println("\n------testTeamSizeOfFive1------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Carter,Xander\nAshley,Mya,Xander\nXander,Gerry,Ashley\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Carter,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Mya,Josh\nAubrey,Madison,Caleb\nMadison,Jane,Carter\nLiz,Aaron,Madison\nAaron,Will,Liz\nWill,Liz,Aubrey\nCaleb,Josh,Aubrey";
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		String[] options = new String[] {"-p","1", "-t", "5", "-v","1"};
		
		g.main(options);
		
		assertEquals(g.iterations[0].proposal, 1);
		assertEquals(g.iterations[0].teamsize, 5);
		assertEquals(g.iterations[0].verbosity, 1);
	}
	
	@Test
	public void testTeamSizeOfFive2()   throws FileNotFoundException
    {
		//test 45 by Nic
		System.out.println("\n------testTeamSizeOfFive2------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Eden,Xander\nAshley,Will,Xander\nXander,Gerry,Ashley\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Eden,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Will,Josh\nAubrey,Madison,Caleb\nMadison,Will,Carter\nLiz,Aaron,Madison\nAaron,Will,Liz\nWill,Liz,Aubrey\nCaleb,Josh,Aubrey";
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		String[] options = new String[] {"-p","1", "-t", "5", "-v","1"};
		
		g.main(options);
		
		assertEquals(g.iterations[0].proposal, 1);
		assertEquals(g.iterations[0].teamsize, 5);
		assertEquals(g.iterations[0].verbosity, 1);
	}
	
	@Test
	public void testNotEnoughPeople()   throws FileNotFoundException
    {
		//test 46 by Nic
		System.out.println("\n------testNotEnoughPeople------");
    	GoogleHappy g = new GoogleHappy();

		String prefs = "Nic,Eden,Xander\nAshley,Will,Xander\nXander,Gerry,Ashley\nMya,Eden,Josh,Nic\nEden,Ashley\nJosh,Eden,Jane\nCarter,Jane,Mya,Ashley\nJane,Nic\nGerry,Will,Josh\nAubrey,Madison\nMadison,Will,Carter\nLiz,Aaron,Madison\nAaron,Will,Liz\nWill,Liz,Aubrey";
		ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
		String[] options = new String[] {"-p","1", "-t", "5", "-v","1"};
		
		g.main(options);
		
		assertEquals(g.iterations[0].proposal, 1);
		assertEquals(g.iterations[0].teamsize, 5);
		assertEquals(g.iterations[0].verbosity, 1);
	}
}*/
@Test
	public void ytest25()  throws FileNotFoundException
    {
		//Test 47 By Ben Lamont
		System.out.println("\n------TEST 7------");

		for (int n = 6; n < 100; n++)
		{

			String[] temp = new String[n];
			String t = "";


			for(int k = 0; k < 10; k++)
			{
				Random rnd = new Random(k);
				Random rnd2 = new Random(k);
				int teamsize;
				for(int l = 0; l < n; l++)
				{
					teamsize = rnd2.nextInt((n/2)-2) + 2;
				

					System.out.println(n + " " + k + " " + l);

					for(int i = 0; i < n; i++)
					{
						temp[i] = Integer.toString(i);
						for(int j = 0; j < 6; j++)
						{
							if(rnd.nextInt(2) == 0)
							{
								temp[i] = temp[i] + "," + Integer.toString(rnd.nextInt(n));
							}
						}

					}

					t = "";

					for(int i = 0; i < n; i++)
					{
						t = t + temp[i] + "\n";
					}

					ByteArrayInputStream in = new ByteArrayInputStream(t.getBytes());
					System.setIn(in);

					GoogleHappy g = new GoogleHappy();

					g.main(new String[]{"-p","0", "-t", Integer.toString(teamsize), "-v","0"} );
				}
			}
		}

	}
}
