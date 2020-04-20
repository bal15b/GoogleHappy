import java.util.Arrays; 
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
	public int test = 0;
	public double getMath(double n, int choice)
	{
		if (weighted == "t")
		{
			int count = 0;

			for (int i = 0; i <= n; i++)
				count += i;
			
			return (n-choice+1)/count;
		}

		return 1/n;
		
	}


	public class PageRank 
	{
	   
		public int path[][] = new int[10000][10000];
		public double pagerank[] = new double[10000];
	   
		public void calc(double totalNodes)
		{
		  
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
		public int total_prefs;
		public int id;
		public String name;
		public String pref[];
		public double happiness;
		
		
		//set user
		User(String[] p, int i)
		{
			name = p[0];
			
			total_prefs = p.length - 1;
			id = i;
			
			pref = new String[p.length];
			pref[0] = p[0];
			//fill this user with their preferences
			for(int j = 1; j < p.length; j++) 
				pref[j] = p[j];
			
		}
		//set user
		User(String p, int i)
		{
			name = p;
			id = i;
			total_prefs = 0;
			pref = new String[1];
			pref[0] = p;
		}
		
		//print users info
		public int printUserInfo()
		{
			System.out.println("\nName: " + name);
			System.out.println("ID: " + id);
			System.out.println("Happiness: " + happiness);
			System.out.println("TotalPrefs: " + total_prefs);
			System.out.printf("Prefs: ");
			if(pref.length > 1)
				for(int j = 1; j < pref.length; j++) 
					System.out.printf(pref[j] + " ");
					
			System.out.println("");
			System.out.println("------");
			return id;
		}	
		
		//print users info
		public void setHappiness(double n)
		{
			happiness = n;
		}

	}


	
	//primary list of people
	public int count; //amount of people
	public int teamsize;
	public PageRank p;
	public User[] c;
	
	//testing
	public int getUserInfo(String userName)
	{
		for(int i = 0; i < 9; i++)
		{
			if(c[i].name.equals(userName))
				return c[i].printUserInfo();
		}
		return -1;
		
	}
	
	private User[] orderByPR(User[] usersAr)
	{
		for(int n = 0; n < count; n++)
			for(int j = n; j < count; j++)
				if(p.pagerank[n+1] > p.pagerank[j+1])
				{
					//perform swap
					User temp = usersAr[n];
					usersAr[n] = usersAr[j];
					usersAr[j] = temp;
					
					j = n;
				}
				
		//order them by how many prefs each has by putting them 
		//while()
		//{
		//	if x 7
		//}*/
				
		return usersAr;
	}
	
	
	public User[] teams;
	public User[] fillTeams(User[] users)
	{
		
		teams = new User[count];
		//fill the first spots of the teams	
		for(int i = 0; i < count/teamsize; i++)
			teams[i*count/teamsize] = users[i];
			
		boolean found = false;
		//give the first people their preferences and then the seconds picks theirs so on...
		for(int n = 0; n < teamsize-1; n++)
		{	
			for(int i = 0, choice = 1; i < count/teamsize; i++)
			{	
				while(found == false)
				{	if(!(Arrays.asList(teams).contains(getThisUser(users, teams[i*teamsize+n].pref[choice]))))
					{	teams[i*teamsize+n+1] = getThisUser(users, teams[i*teamsize+n].pref[choice]);
						found = true;
					}
					else if(choice + 1 < teams[i*teamsize+1].pref.length && (!(Arrays.asList(teams).contains(getThisUser(users, teams[i*teamsize+n].pref[choice+1])))))
					{	teams[i*teamsize+n+1] = getThisUser(users, teams[i*teamsize+n].pref[choice+1]);
						found = true;
					}
					else if(choice + 1 < teams[i*teamsize+1].pref.length)
						choice++;
					else
						found = true;
				}	
				found = false;
				choice=1;
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
		User fnUser1 = new User("NothingHere", -1);
		for(int i = 0; i < teams.length; i++)
		{	if(teams[i] == null)
				teams[i] = fnUser1;
				
		}
		
		//smallTeams are teams of teamSize and are just 1 team at a time instead of one big array
		User[] smallTeams = new User[teamsize];
		System.arraycopy(teams, 0*teamsize, smallTeams, 0, teamsize);
		 
			 
		//go through all prefs on all small teams and on all cut if any cut.pref matches a person in a team put them on that team
		for(int t = 0; t < count/teamsize; t++)
		{	
			System.arraycopy(teams, t*teamsize, smallTeams, 0, teamsize);
			if(Arrays.asList(smallTeams).contains(fnUser1))
			{	
				for(int i = 0; i < cut.length; i++)
				{	
					prefLoop:
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
						
										for(int h = 0; h < tempCut.length; h++)
										{	
											if(tempCut[h] == null)
													tempCut[h] = fnUser1;
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
				teams[i] = cut[p];
			

		printTeams(teams);

		return teams;
		
	}
	
	private User getThisUser(User[] list, String name)
	{
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].name.equals(name))
				return list[i];
		}
		
		User fnUser = new User("getThisUserBroken", -1);
		return fnUser;
	}


	//reads from file and puts users into the people array
	private void prefs(HashMap<String, Integer> mentioned_people)
	{
		count = 0;
		c = new User[1000];
		Scanner scanner = new Scanner(System.in);

		String[] temp = new String[1000];

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
		teamsize = 3;
		//defines map
		HashMap<String, Integer> mentioned_people = new HashMap<String, Integer>();
		p = new PageRank();

		//loads the users and their prefs into the c array
		prefs(mentioned_people);
		
		//runs page rank
		p.calc(count);
		
		getKeys(mentioned_people, 0);
		
		//orderByPR(c);
		if(test == 0)
			fillTeams(c);
		
		
		//printTeams(c);

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
	  
	  
	  public void printTeams(User[] users)
	  {
		User fnUser = new User("NothingHere", -1);
		//print out the names and divide them into groups of 3
		System.out.println("\nTEAMS\n-------");
		int i = 1;
		for( int n = 0; n < 9; n++)
		{
			if(users[n] == null)
				users[n] = fnUser;
			if(n%3==0)
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
