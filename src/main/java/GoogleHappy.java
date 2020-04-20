import java.util.*;
import java.io.*;

/******************************************************************************
 *  Author : 
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do something for the project
 *  Date   : 5/6/2020
 *
 *
 *
 ******************************************************************************/
public class GoogleHappy 
{
  public double getMath(double n, int choice)
  {
    if (1==1)
    {
      int count = 0;

      for (int i = 0; i <= n; i++)
      {
        count += i;
      }
      return (n-choice+1)/count;
    }

    return 1/n;

  }


  public class PageRank {
   
      public int path[][] = new int[10000][10000];
      public double pagerank[] = new double[10000];
   
      public void calc(double totalNodes){
      
    double InitialPageRank;
    double OutgoingLinks=0; 
    double DampingFactor = 1; 
    double TempPageRank[] = new double[10000];

    int ExternalNodeNumber;
    int InternalNodeNumber; 
    int k=1; // For Traversing
    int ITERATION_STEP=1;

    InitialPageRank = 1/totalNodes;
    System.out.printf(" Total Number of Nodes :"+totalNodes+"\t Initial PageRank  of All Nodes :"+InitialPageRank+"\n");
   
    // 0th ITERATION  _ OR _ INITIALIZATION PHASE
    for(k=1;k<=totalNodes;k++)
        {
      this.pagerank[k]=InitialPageRank;
        }   
    
    System.out.printf("\n Initial PageRank Values , 0th Step \n");
    for(k=1;k<=totalNodes;k++)
        {
      System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n");
        }  
    
    while(ITERATION_STEP<=2) // Iterations
        {
      // Store the PageRank for All Nodes in Temporary Array 
      for(k=1;k<=totalNodes;k++)
          {  
        TempPageRank[k]=this.pagerank[k];
        this.pagerank[k]=0;
          }
      
      for(InternalNodeNumber=1;InternalNodeNumber<=totalNodes;InternalNodeNumber++)
          {
        for(ExternalNodeNumber=1;ExternalNodeNumber<=totalNodes;ExternalNodeNumber++)
            {
          if(this.path[ExternalNodeNumber][InternalNodeNumber] > 0)
              { 
            k=1;
            OutgoingLinks=0;  // Count the Number of Outgoing Links for each ExternalNodeNumber
            while(k<=totalNodes)
                {
              if(this.path[ExternalNodeNumber][k] > 0 )
                  {
                OutgoingLinks=OutgoingLinks+1; // Counter for Outgoing Links
                  }  
              k=k+1;  
                } 
            // Calculate PageRank     
            this.pagerank[InternalNodeNumber]+=TempPageRank[ExternalNodeNumber]*(getMath(OutgoingLinks,path[ExternalNodeNumber][InternalNodeNumber]));    
              }
            }  
          }    
       
      System.out.printf("\n After "+ITERATION_STEP+"th Step \n");
    
      for(k=1;k<=totalNodes;k++) 
          System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
    
      ITERATION_STEP = ITERATION_STEP+1;
        }

    // Add the Damping Factor to PageRank
    for(k=1;k<=totalNodes;k++)
        {
      this.pagerank[k]=(1-DampingFactor)+ DampingFactor*this.pagerank[k]; 
        } 
    
    // Display PageRank
    System.out.printf("\n Final Page Rank : \n"); 
    for(k=1;k<=totalNodes;k++)
        {
      System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
        }
    
      } 


  }






















  public class User
  {
    public int total_prefs;
    public int id;
    public double rank;
    public String name;
    public String pref[];

    User(String[] p, int i)
    {
      name = p[0];
      total_prefs = p.length - 1;
      id = i;
      pref = new String [10];
      for (int j = 1; j < p.length; j++)
      {
        pref[j-1] = p[j];
      }
    }
    User(String p, int i)
    {
      name = p;
      id = i;
      total_prefs = 0;
    }

  }


  public class Team
  {
    public int max;
    public int current;
    public User people[];

    Team(int n, User[] people)
    {
      max = n;
      int count = 0;
      people = new User[max];
      for (User temp : people)
      {
        people[count] = temp;
        count ++;
      }
      current = count;
    }
    Team(int n)
    {
      max = n;
      current = 0;
    }

    public void addUsers(User[] u, int n)
    {
      for (int i = 0; i < n; i++)
      {
        current++;
        people[current] = u[i];
      }
    }
  }

  

























  //primary list of people
  public int count;
  public int teamsize;
  public PageRank p;
  public User[] c;
  public User[] ordered;
  public HashMap<String, Integer> mentioned_people = new HashMap<String, Integer>();
  public Team[] officialTeams;


  //reads from file and puts users into the people array
  private void prefs(HashMap<String, Integer> mentioned_people)
  {
    count = 0;
    c = new User[10000];
    Scanner scanner = new Scanner(System.in);

    String[] temp = new String[10000];

    //reads lines into temp array
    while(scanner.hasNextLine())
    {
      temp[count] = scanner.nextLine();
      //processes line and add name to set
      String[] temp2 = temp[count].split(",");

      String[] temp3 = Arrays.copyOfRange(temp2, 1, temp2.length);

      if(!mentioned_people.containsKey(temp2[0]))
      {
        c[count] = new User(temp2, count + 1);
        mentioned_people.put(temp2[0],count); 

      }
      count ++;

    }

    int temp_n = count;
    //creates users now that the total number of them is known
    for (int i = 0; i < count; i++)
    {

      String[] temp2 = temp[i].split(",");

      String[] temp3 = Arrays.copyOfRange(temp2, 1, temp2.length);
      int len = temp3.length;

      for (int j = 0; j < len; j++)
      {
        //goes through choices and if it is not in the map adds it
        if (!mentioned_people.containsKey(temp3[j]))
        {
          temp[count] = temp3[j];
          c[count] = new User(temp3[j], count + 1);
          mentioned_people.put(temp3[j],count); 
          count ++;

        }


      }

    }

    for (int i = 0; i < count; i++)
    {
      String[] temp2 = temp[i].split(",");
      String[] temp3 = Arrays.copyOfRange(temp2, 1, temp2.length);

      //sets all paths to 0
      for (int j = 0; j < count; j++)
      {
        p.path[i+1][j+1] = 0;
      }

      //chages paths based on existing prefs
      for (int j = 0; j < temp3.length; j++)
      {
        int t = mentioned_people.get(temp3[j]);
        p.path[i+1][t+1] = 1;
        p.path[i+1][t+1] = j+1;

      }
    }

    for (int i = 1; i <= count; i++)
    {
      for (int j = 1; j <= count; j++)
      {
                //sets to zero if point at self
        if(j==i)
        {
          p.path[i][j]=0;
        }
      }

    }
    System.out.println("\n\n");

    for (int i = 1; i <= count; i++)
    {
      String line = "";
      for (int j = 1 ; j <= count; j++)
      {
        line = line + p.path[i][j];
      }
      System.out.println(line);
    }

    scanner.close();
  }

  private int getHappiness(User[] u, int n)
  {
    double hap = 0;

    int[] den = {1,1,3,6,10,15,21};

    for(int i = 0; i < n; i++)
    {
      for(int j = 0; j < n; j++)
      {
        if (p.path[i+1][j+1] != 0)
        {
          hap += ((u[i].total_prefs - p.path[i+1][j+1] + 1.0)/den[u[i].total_prefs]) * 100;
        }
      }
    }
    return (int)hap;
  }

  public int checkTeam(Team t, User[] u)
  {
    int aLen = t.people.length;
    int bLen = u.length;
    User[] result = new User[aLen + bLen];

    System.arraycopy(t.people, 0, result, 0, aLen);
    System.arraycopy(u, 0, result, aLen, bLen);

    return getHappiness(result, aLen + bLen);
  }

  public void userSort()
  {
    for (int i = 1; i < count; i++)
    {
      double v = (ordered[i].total_prefs*10) + ordered[i].rank;

      if (ordered[i].total_prefs == 0)
      {
        v = 100;
      }
      User current = ordered[i];
      int j;
      for (j = i; j > 0 &&(ordered[j-1].total_prefs*10) + ordered[j-1].rank > v; j--)
      {
        ordered[j] = ordered[j-1];
      }
      ordered[j] = current;
    }
  }

  public User getPair(User o)
  {
    if(o.total_prefs == 0)
    {
      return o;
    }

    int place = 0;

    User potential = c[mentioned_people.get(o.pref[place])];
    User potential2;
  
    User[] arr = new User[2];
    arr[0] = o;
    arr[1] = potential;

    int currentHap = getHappiness(arr,2);

    for (int i=1; i < o.total_prefs; i++)
    {
      potential2 = c[mentioned_people.get(o.pref[i])];

      arr[1] = potential2;
      
      if (getHappiness(arr,2)-i > currentHap)
      {
        place = i;
        currentHap = getHappiness(arr,2)-i;
      }
      
    }
    return c[place];
  }

  public boolean onTeams (User u)
  {
    int numberOfTeams = count/teamsize;

    if (count%teamsize != 0)
    {
      numberOfTeams++;
    }
    System.out.println(numberOfTeams);

    for (int i = 0; i < numberOfTeams; i++)
    {
      for(int j = 0; j < officialTeams[i].current; j++)
      {
        if(u == officialTeams[i].people[j])
        {
          return true;
        }
      }
    }

    return false;
  }

  public void placeTemp (Team tempTeam)
  {
    int numberOfTeams = count/teamsize;

    if (count%teamsize != 0)
    {
      numberOfTeams++;
    }

    System.out.println(onTeams(tempTeam.people[0]));

    if (onTeams(tempTeam.people[0]) && onTeams(tempTeam.people[1]))
    {
          System.out.println("here1");

      //both are on a team
      return;
    }
    else if (!onTeams(tempTeam.people[0]) && onTeams(tempTeam.people[1]))
    {
      //first person is on a team
          System.out.println("here2");

       for (int i = 0; i < numberOfTeams; i++)
      {
        for (int j = 0; j < officialTeams[i].current; j++)
        {
          if (officialTeams[i].current < officialTeams[i].max && officialTeams[i].people[j] == tempTeam.people[0])
          {
            officialTeams[i].addUsers(Arrays.copyOfRange(tempTeam.people, 1, 1),1);
            return;
          }
        }
      }

      int bestB = 0;
      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 0)) > bestB && officialTeams[i].current != officialTeams[i].max)
        {
          bestB = i;
        }
      }
      officialTeams[bestB].addUsers(Arrays.copyOfRange(tempTeam.people, 1, 1), 1);
    }
    else if (onTeams(tempTeam.people[0]) && !onTeams(tempTeam.people[1]))
    {
      //second person is on a team
          System.out.println("here3");

      for (int i = 0; i < numberOfTeams; i++)
      {
        for (int j = 0; j < officialTeams[i].current; j++)
        {
          if (officialTeams[i].current < officialTeams[i].max && officialTeams[i].people[j] == tempTeam.people[1])
          {
            officialTeams[i].addUsers(Arrays.copyOfRange(tempTeam.people, 0, 0),1);
            return;
          }
        }
      }

      int bestA = 0;
      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 0)) > bestA && officialTeams[i].current != officialTeams[i].max)
        {
          bestA = i;
        }
      }
      officialTeams[bestA].addUsers(Arrays.copyOfRange(tempTeam.people, 0, 0), 1);
    }
    else
    {
      //neither are on a team 
          System.out.println("here4");

      //places on an empty team if there is one
      for (int i = 0; i < numberOfTeams; i++)
      {
        if (officialTeams[i].current == 0)
        {
          officialTeams[i].addUsers(tempTeam.people,2);
          return;
        }
      }

      //finds best team with 2 slots
      boolean found = false;
      Team bestTeam = officialTeams[0];
      int index = 0;
      
      for (int i = 1; i < numberOfTeams; i++)
      {
        if(checkTeam(bestTeam, tempTeam.people) < checkTeam(officialTeams[i], tempTeam.people))
        {
          bestTeam = officialTeams[i];
          found = true;
          index = i;
        }
      }

      if (found)
      {
        officialTeams[index].addUsers(tempTeam.people,2);
        return;
      }

      int bestA = 0;
      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 0)) > bestA && officialTeams[i].current != officialTeams[i].max)
        {
          bestA = i;
        }
      }
      officialTeams[bestA].addUsers(Arrays.copyOfRange(tempTeam.people, 0, 0), 1);
      int bestB = 0;

      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 1, 1)) > bestB && officialTeams[i].current != officialTeams[i].max)
        {
          bestB = i;
        }
      }
      officialTeams[bestB].addUsers(Arrays.copyOfRange(tempTeam.people, 1, 1), 1);

    }
  }
  

  public void primaryFunction(String verbosity)
  {
    //defines map
    p = new PageRank();
    teamsize = 3;

    //loads the users and their prefs
    prefs(mentioned_people);
    //returns an array of all the names and outputs them into teams of 3 
    getKeys(mentioned_people, 0);
    
    //runs page rank
    p.calc(count);

    //orders users
    ordered = new User[count];
    for (int i=0; i < count; i++)
    {
      c[i].rank = p.pagerank[i+1];
      ordered[i] = c[i];
    }
    System.out.println("here");
    userSort();
    User[] temporaryTeam = new User[2];
    Team[] tempTeams = new Team[count];
    //finds each person's best pairing
    for (int i = 0; i < count; i++)
    {
      temporaryTeam[0] = ordered[i];
      temporaryTeam[1] = getPair(ordered[(i)]);
      tempTeams[i] = new Team(teamsize,Arrays.copyOfRange(temporaryTeam, 0, 1));
    }
    //creates main teams
    int numberOfTeams = count/teamsize;
    System.out.println("here");

    if (count%teamsize != 0)
    {
      numberOfTeams++;
    }
    System.out.println("here");

    officialTeams = new Team[numberOfTeams];
    for (int i = 0; i < numberOfTeams; i++)
    {
      officialTeams[i] = new Team(teamsize);
    }
    System.out.println("here");

    //puts people on teams
    for (int i = 0; i < count; i++)
    {
      placeTemp(tempTeams[i]);
    }
    System.out.println("here");


  }

  public static void main (String[] args )  throws FileNotFoundException
  {
    int verbose = 0;
    //if (teamsize == 0)
    {
      //System.out.println("You cannot have a teamsize of zero");
      //return;
    }
    //parsing input
    /*
    for (int i = 0; i <= args.length; i++)
    {
      if (args[i] == "-v")
      {
        verbose = args[i+1];
      }
      else if (args[i] == "-t")
      {
        teamsize = args[i+1];
      }
    }
    */


    //creates the main GoogleHappy object and runs primaryFunction
    new GoogleHappy().primaryFunction("0");
  }
  
  //send in the hashmap,0 to just set an array send in hashmap,1 to output a set of teams
  public static String[] getKeys(HashMap<String, Integer> hash, int onOff)
  {
	  
	//Makes an array of just the names of people
	String allNames[] = new String [hash.size()];
	int i = 0;
	for (String key : hash.keySet()) 
	{
		allNames[i] = key;
		i++;
	}

	if(onOff == 1)
	{
		//print out the names and divide them into groups of 3
		System.out.println("\nTEAMS\n-------");
		i = 1;
		for( int n = 0; n < allNames.length; n++)
		{
			if(n%3==0)
			{
				if(n!=0&&n!=1)
					System.out.print("\n");
				System.out.println("Team " + (i));
				i++;
			}
			
			System.out.println(allNames[n]);
		} 
	}
	 
	//returns an array of names
	return allNames;
  }
  
}
