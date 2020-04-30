import java.util.*;
import java.io.*;

/*****************************************************************************
 *  Author : 
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do something for the project
 *  Date   : 5/6/2020
 *
 *****************************************************************************/
public class GoogleHappy 
{
  /*Pagerank Section*/

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
    //System.out.printf(" Total Number of Nodes :"+totalNodes+"\t Initial PageRank  of All Nodes :"+InitialPageRank+"\n");
   
    // 0th ITERATION  _ OR _ INITIALIZATION PHASE
    for(k=1;k<=totalNodes;k++)
        {
      this.pagerank[k]=InitialPageRank;
        }   
    
    //System.out.printf("\n Initial PageRank Values , 0th Step \n");
    for(k=1;k<=totalNodes;k++)
        {
      //System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n");
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
       
      //System.out.printf("\n After "+ITERATION_STEP+"th Step \n");
    
      for(k=1;k<=totalNodes;k++) 
          //System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
    
      ITERATION_STEP = ITERATION_STEP+1;
        }

    // Add the Damping Factor to PageRank
    for(k=1;k<=totalNodes;k++)
        {
      this.pagerank[k]=(1-DampingFactor)+ DampingFactor*this.pagerank[k]; 
        } 
    
    // Display PageRank
    //System.out.printf("\n Final Page Rank : \n"); 
    for(k=1;k<=totalNodes;k++)
        {
      //System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
        }
    
      } 


  }



	public int a;



  /*Other Classes*/

  public class User
  {
    public int total_prefs;
    public int id;
    public double rank;
    public double happiness;
    public String name;
    public String pref[];

    User(String[] p, int i)
    {
      name = p[0];
      total_prefs = p.length - 1;
      id = i;
      pref = new String [p.length];
	  happiness = 0;
	  
      for (int j = 1; j < p.length; j++)
      {
		  if (a == 0)
		  {
        	pref[j-1] = p[j];
		  }
		  else
		  {
			pref[j] = p[j];
		  }
      }
    }
    User(String p, int i)
    {
      name = p;
      id = i;
      total_prefs = 0;
	  happiness = 0;

    }
    User(User u)
    {
      total_prefs = u.total_prefs;
      id = u.id;
      rank = u.rank;
      name = u.name;
      for(int i = 0; i < u.pref.length; i++)
      {
        pref[i] = u.pref[i];
      }
    }

    //print users info
		public int printUserInfo()
		{
			System.out.println("\nName: " + name);
			System.out.println("ID: " + id);
			System.out.println("TotalPrefs: " + total_prefs);
			System.out.printf("Prefs: ");

			

			if(pref.length > 1)
				for(int j = 1; j < pref.length; j++) 
					System.out.printf(pref[j] + " ");
					
			System.out.println("");
			for(int i = 0; i < count; i++)
			{
				if (i % 3 == 0)
				{
					System.out.println("Team " + i + "'s Happiness: " + getHappiness(Arrays.copyOfRange(c, i, i + 3),3));
				}
			}
			System.out.println("------");
			return id;
		}	

 
		public void setHappiness(double n)
		{
			happiness = n;
		}

  }



  public class Team
  {
    public int max;
    public int current;
    public User people[];

    Team(int n, User[] persons)
    {
      max = n;
      int count = 0;
      people = new User[max];
      for (User temp : persons)
      {
        people[count] = temp;
        count ++;
      }
      current = count;
    }
    Team(int n)
    {
      max = n;
      people = new User[max];
      current = 0;
    }

    public void addUsers(User[] u, int n)
    {
      for (int i = 0; i < n; i++)
      {
        people[current] = u[i];
        current++;
      }
    }

    public void addUsers2(User u, int n)
    {
      people[current] = u;
      current++;
    }
  }

  

  /*Global Variables*/
  public int count;
  public int teamsize;
  public int verbosity;
  public int proposal;
  public int test = 0;
  public PageRank p;
  public User testUser = new User("testUser", -1);
  public User[] c;
  public User[] ordered;
  public User[] teams;
  public HashMap<String, Integer> mentioned_people = new HashMap<String, Integer>();
  public Team[] officialTeams;
  


 /*Functions*/
  //testing
	public int getUserInfo(String userName)
	{
		for(int i = 0; i < count; i++)
		{
			if(c[i].name.equals(userName))
				return c[i].printUserInfo();
		}
		return -1;
		
	}

	private User getThisUser(User[] list, String user)
	{
		for(int i = 0; i < count; i++)
		{
			//System.out.println(list[i].name + " " + user);
			if(list[i].name.equals(user))
				return list[i];
		}
		
		User fnUser = new User("getThisUserBroken", -1);
		return fnUser;
	}
	
	//if there is not enough people to fill all the teams then add placeholders
	public User[] findPlaceHolders(User[] users)
	{
		int placeHolder = 0;
		int remainder = count % teamsize;
		if( teamsize-remainder != teamsize)
			placeHolder = teamsize-remainder;
	
		User userPlace = new User("PlaceHolder", -1);
		
		for(int i = 0; i < count+placeHolder; i++)
		{
			if(i >= count)
			{	
				users[i] = userPlace;				
			}
		}
		
		count = count+placeHolder;
		
		return users;
	}
	
	//////////////////////////////////////
	public User[] fillTeams(User[] users)
	{
		User fnUser1 = new User("NothingHere", -1);
		teams = new User[count];
		//fill the first spots of the teams	
		for(int i = 0; i < count/teamsize; i++)
			teams[i*teamsize] = users[i];
		
		findPlaceHolders(users);
		
		boolean found = false;
		//give the first people their preferences and then the seconds picks theirs so on...
		for(int n = 0; n < teamsize-1; n++)
		{	
			for(int i = 0, choice = 1; i < count/teamsize; i++)
			{	
				while(found == false)
				{	
					
					if(teams[i*teamsize+n] == null)
					{
						found = true;
					}
					else if(choice < teams[i*teamsize+n].pref.length && (!(Arrays.asList(teams).contains(getThisUser(users, teams[i*teamsize+n].pref[choice])))))
					{	
						teams[i*teamsize+n+1] = getThisUser(users, teams[i*teamsize+n].pref[choice]);
						found = true;
						//System.out.println("1st");
					}
					else if(choice + 1 < teams[i*teamsize+n].pref.length && (!(Arrays.asList(teams).contains(getThisUser(users, teams[i*teamsize+n].pref[choice+1])))))
					{	
						teams[i*teamsize+n+1] = getThisUser(users, teams[i*teamsize+n].pref[choice+1]);
						found = true;
						//System.out.println("2nd");

					}
					else if(choice + 1 < teams[i*teamsize+n].pref.length)
					{
						choice++;
						//System.out.println("3rd");
					}
					else
					{
						found = true;
						//System.out.println("4th");
					}
				}	
				
				found = false;
				choice = 1;
			}
		}
		
		User[] temp = new User[count];
		//find those who didnt get places
		int n = 0;
		for(int i = 0; i < teams.length; i++)
			if(!(Arrays.asList(teams).contains(getThisUser(users, users[i].name))))
			{	
				temp[n] = users[i];
				n++;
			}	
		
		User[] cut = new User[n];
		
		for(int i = 0; i < cut.length; i++)
		{	
			cut[i] = temp[i];
		}
		
		//fill the empty spots with NothingHere
		for(int i = 0; i < teams.length; i++)
		{	if(teams[i] == null)
				teams[i] = fnUser1;
				
		}
		
		//smallTeams are teams of teamSize and are just 1 team at a time instead of one big array
		User[] smallTeams = new User[teamsize];
		System.arraycopy(teams, 0, smallTeams, 0, teamsize);
		
			 
		//go through all prefs on all small teams and on all cut if any cut.pref matches a person in a team put them on that team
		prefLoop:
		for(int t = 0; t < count/teamsize; t++)
		{	
			System.arraycopy(teams, t*teamsize, smallTeams, 0, teamsize);

			//if there are any open spots// the fnUser1 name is "NothingHere"
			if(Arrays.asList(smallTeams).contains(fnUser1))
			{	
				for(int i = 0; i < cut.length; i++)
				{	
					
					
					for(int a = 1; a < cut[i].pref.length; a++)
					{	
						
						for(int p = 0; p < smallTeams.length; p++)
						{	
							
							if(cut[i].pref[a].equals(smallTeams[p].name))
							{	
								for(int x = 0; x < smallTeams.length; x++)
								{	
									
									if(smallTeams[x].name.equals("NothingHere"))
									{	
										smallTeams[x] = cut[i];

										User[] tempCut = new User[cut.length];
										int l = 0;
										for(int h = 0; h < cut.length; h++)
											if(!(Arrays.asList(smallTeams).contains(getThisUser(users, cut[h].name))))
											{	
												tempCut[l] = getThisUser(users, cut[h].name);
												l++;
											}
						
										cut = new User[cut.length-1];
										for(int h = 0; h < tempCut.length; h++)
										{	
											if(tempCut[h] != null)
													cut[h] = tempCut[h];
											
											

										}
											
										System.arraycopy(smallTeams, 0, teams, t*teamsize, teamsize);

										break prefLoop;
									}
								}
							}
						}
					}
				}
			}
		}
		
		//puts the reaming people that didnt get a spot on to an empty team
		for(int i = 0, p = 0; i < teams.length; i++)
			if(teams[i].name.equals("NothingHere"))
			{	
				teams[i] = cut[p];
				p++;
			}
			

		printTeams(teams);

		return teams;
		
	}
  

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
    //System.out.println("\n\n");

    for (int i = 1; i <= count; i++)
    {
      String line = "";
      for (int j = 1 ; j <= count; j++)
      {
        line = line + p.path[i][j];
      }
      //System.out.println(line);
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
        if (p.path[u[j].id][u[i].id] != 0)
        {
          hap += ((u[j].total_prefs - p.path[u[j].id][u[i].id] + 1.0)/den[u[j].total_prefs]) * 100;

        }
      }
    }
    return (int)hap;
  }

  public int checkTeam(Team t, User[] u)
  {
    int aLen = t.current;

    int bLen = u.length;
    User[] result = new User[aLen + bLen];
    System.arraycopy(t.people, 0, result, 0, aLen);
    System.arraycopy(u, 0, result, aLen, bLen);

    int back = getHappiness(result, (aLen + bLen));

    return back;
  }

  public User[] orderByPR(User[] order)
  {
	if (proposal == 1)
	{
		for (int i = 0; i <  count; i++)
		{
			p.pagerank[i] = 1-p.pagerank[i];
		}
	}

    for (int i=0; i < count; i++)
    {
      c[i].rank = p.pagerank[i+1];
      order[i] = c[i];
    }
    for (int i = 1; i < count; i++)
    {
      double v = (order[i].total_prefs*10) + order[i].rank;

      if (order[i].total_prefs == 0)
      {
        v = 100;
      }
      User current = order[i];
      int j;
      for (j = i; j > 0 &&(order[j-1].total_prefs*10) + order[j-1].rank > v; j--)
      {
        order[j] = order[j-1];
      }
      order[j] = current;
    }

    return order;
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
    return c[mentioned_people.get(o.pref[place])];
  }

  public boolean onTeams (User u)
  {

    int numberOfTeams = count/teamsize;

    if (count%teamsize != 0)
    {
      numberOfTeams++;
    }

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


    if (onTeams(tempTeam.people[0]) && onTeams(tempTeam.people[1]))
    {

      //both are on a team
      return;
    }
    else if (onTeams(tempTeam.people[0]) && !onTeams(tempTeam.people[1]))
    {
      //first person is on a team

       for (int i = 0; i < numberOfTeams; i++)
      {
        for (int j = 0; j < officialTeams[i].current; j++)
        {
          if (officialTeams[i].current < officialTeams[i].max && officialTeams[i].people[j] == tempTeam.people[0])
          {
            officialTeams[i].addUsers2(tempTeam.people[1],1);
            return;
          }
        }
      }

      int bestB = 0;
      boolean found = false;
      for (int i = 0; i < numberOfTeams; i++)
      {

        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 1)) > bestB && officialTeams[i].current < officialTeams[i].max)
        {
          bestB = i;
          found = true;
        }
      }
      if (found)
      {
        officialTeams[bestB].addUsers2(tempTeam.people[1],1);
      }
    }
    else if (!onTeams(tempTeam.people[0]) && onTeams(tempTeam.people[1]))
    {
      //second person is on a team

      for (int i = 0; i < numberOfTeams; i++)
      {
        for (int j = 0; j < officialTeams[i].current; j++)
        {
          if (officialTeams[i].current < officialTeams[i].max && officialTeams[i].people[j] == tempTeam.people[1])
          {
            officialTeams[i].addUsers2(tempTeam.people[0],1);
            return;
          }
        }
      }

      int bestA = 0;
      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 1)) > bestA && officialTeams[i].current != officialTeams[i].max)
        {
          bestA = i;
        }
      }

      officialTeams[bestA].addUsers2(tempTeam.people[0],1);
    }
    else
    {
      //neither are on a team 

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

	  if (bestTeam.current+1 < bestTeam.max)
	  {
		  found = true;
	  }
      
      for (int i = 1; i < numberOfTeams; i++)
      {
        if(checkTeam(bestTeam, tempTeam.people) < checkTeam(officialTeams[i], tempTeam.people))
        {
		  if(officialTeams[i].current+1 < officialTeams[i].max)
		  {
			bestTeam = officialTeams[i];
          	found = true;
          	index = i;
		  }
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
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 0, 1)) > bestA && officialTeams[i].current != officialTeams[i].max)
        {
          bestA = i;
        }
      }
      officialTeams[bestA].addUsers(Arrays.copyOfRange(tempTeam.people, 0, 1), 1);
      int bestB = 0;

      for (int i = 0; i < numberOfTeams; i++)
      {
        if(checkTeam(officialTeams[i], Arrays.copyOfRange(tempTeam.people, 1, 2)) > bestB && officialTeams[i].current != officialTeams[i].max)
        {
          bestB = i;
        }
      }
      officialTeams[bestB].addUsers(Arrays.copyOfRange(tempTeam.people, 1, 2), 1);

    }
  }
  

  public void primaryFunction(int it)
  {
	a = it;
	if (it == 0)
	{
		//defines map
		p = new PageRank();

		//loads the users and their prefs
		prefs(mentioned_people);
		//returns an array of all the names and outputs them into teams of 3 
		getKeys(mentioned_people, 0);
		
		//runs page rank
		p.calc(count);

		//orders users
		ordered = new User[count];
		
		ordered = orderByPR(ordered);
		User[] temporaryTeam = new User[2];
		Team[] tempTeams = new Team[count];
		//finds each person's best pairing
		for (int i = 0; i < count; i++)
		{
		temporaryTeam[0] = ordered[i];
		temporaryTeam[1] = getPair(ordered[(i)]);
		tempTeams[i] = new Team(2,temporaryTeam);
		}
		//creates main teams
		int numberOfTeams = count/teamsize;

		if (count%teamsize != 0)
		{
		numberOfTeams++;
		}

		officialTeams = new Team[numberOfTeams];
		for (int i = 0; i < numberOfTeams; i++)
		{
		officialTeams[i] = new Team(teamsize);
		}

		

		//puts people on teams
		for (int k = 0; k < count; k++)
		{
			placeTemp(tempTeams[k]);
		}
		int place = 0;
		for (int i = 0; i < numberOfTeams; i++)
		{

			for (int j = 0; j < officialTeams[i].current; j++)
			{
				c[place] = officialTeams[i].people[j];
			}
		}

		
		//printTeams(c);

	}
	else if (it == 1)
	{
		HashMap<String, Integer> mentioned_people = new HashMap<String, Integer>();
		p = new PageRank();

		//loads the users and their prefs into the c array
		prefs(mentioned_people);
		
		//runs page rank
		p.calc(count);
		
		getKeys(mentioned_people, 0);
		
		orderByPR(c);
		if(test == 0)
			fillTeams(c);

	}
	

  }
  public GoogleHappy[] iterations = new GoogleHappy[3];
	public void main (String[] args )  throws FileNotFoundException
	{
		//creates the main GoogleHappy object and runs primaryFunction
		iterations[0] = new GoogleHappy();
		iterations[1] = new GoogleHappy();
		iterations[2] = new GoogleHappy();

		int v = 0;
		int p = 0;
		int t = 3;
		
		Scanner scanner = new Scanner(System.in);

		String temp = "";

		while(scanner.hasNextLine())
		{
			temp = temp + scanner.nextLine();
			if(scanner.hasNextLine())
			{
				temp = temp + "\n";
			}
		}


		for (int i = 0; i < args.length; i++)
		{
			if (args[i] == "-v")
			{
				v = Integer.parseInt(args[i+1]);
			}
			else if (args[i] == "-t")
			{
				t = Integer.parseInt(args[i+1]);
			}
			else if (args[i] == "-p")
			{
				p = Integer.parseInt(args[i+1]);
			}
		}

		iterations[0].verbosity = v;
		iterations[1].verbosity = v;
		iterations[2].verbosity = v;

		iterations[0].teamsize = t;
		iterations[1].teamsize = t;
		iterations[2].teamsize = t;

		iterations[0].proposal = p;
		iterations[1].proposal = p;
		iterations[2].proposal = p;

		ByteArrayInputStream in = new ByteArrayInputStream(temp.getBytes());
        System.setIn(in);
		iterations[0].primaryFunction(0);

		ByteArrayInputStream in2 = new ByteArrayInputStream(temp.getBytes());
        System.setIn(in2);
		iterations[1].primaryFunction(1);

		ByteArrayInputStream in3 = new ByteArrayInputStream(temp.getBytes());
        System.setIn(in3);
		iterations[2].primaryFunction(2);
		/*
		int place = 0;
		int besthap = iterations[0].totalhap();
		int potentialhap = iterations[1].totalhap();
		
		if (potentialhap > besthap)
		{
			place = 1;
			besthap = potentialhap;
		}

		potentialhap = iterations[2].totalhap();

		if (potentialhap > besthap)
		{
			place = 2;
			besthap = potentialhap;
		}

		iterations[place].finalPrint();
		*/	
			
	}
  
 	    //send in the hashmap,0 to just set an array send in hashmap,1 to output a set of teams
	  public String[] getKeys(HashMap<String, Integer> hash, int onOff)
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
				if(n%teamsize==0)
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
		  
		public void printTeams(User[] users)
		  {
			User fnUser = new User("NothingHere", -1);
			//print out the names and divide them into groups of 3
			System.out.println("\nTEAMS\n-------");
			int i = 1;
			for( int n = 0; n < count; n++)
			{
				if(users[n] == null)
					users[n] = fnUser;
				if(n%teamsize==0)
				{
					if(n!=0&&n!=1)
						System.out.print("\n");
					System.out.println("Team " + (i));
					i++;
				}
						
				System.out.println(users[n].name);
			}
		  }
}
