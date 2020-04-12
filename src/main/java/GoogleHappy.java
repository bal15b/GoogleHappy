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

  private String weighted;

  public double getMath(double n, int choice)
  {
    if (weighted == "t")
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
    double DampingFactor = 0.85; 
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
    public int pref[];
    public int id;
    public String name;

    User(String[] p)
    {
      name = p[0];
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
      for (User temp : people)
      {
        people[count] = temp;
        count ++;
      }
      current = count;
    }
  }

  




  //primary list of people
  public int count;
  public int teamsize;
  public PageRank p;
  public User[] c;

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
        c[count] = new User(temp2);
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
          c[count] = new User(temp2);
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
        if (weighted == "t")
        {
          p.path[i+1][t+1] = j+1;
        }

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
  
  public void primaryFunction(String w)
  {
    weighted = w;
    teamsize = 0;
    //defines map
    HashMap<String, Integer> mentioned_people = new HashMap<String, Integer>();
    p = new PageRank();

    //loads the users and their prefs
    prefs(mentioned_people);

    //returns an array of all the names and outputs them into teams of 3 
    getKeys(mentioned_people, 0);
    
    //runs page rank
    p.calc(count);

    //potential loop for multiple itterations???

    //run team optimization algorithm

    //output (with verbosity??)
  }

  public static void main (String[] args )  throws FileNotFoundException
  {
    //creates the main GoogleHappy object and runs primaryFunction
    new GoogleHappy().primaryFunction(args[0]);
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
