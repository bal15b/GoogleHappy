# GoogleHappy

To run through command line
---
java -cp target/classes GoogleHappy -v 0 -t 3 -p 0 < filename.csv

v = verbosity
t = teamsize 
p = 0 
The program gives the least popular person highest precident
p = 1
The program gives the most popular person highest precident





What is it?
----
The GoogleHappy sorting system using the same system as Google does for organizing teams based on preference when taking in a list of preferences using the pagerank system that is also part of the Google search engine. It follows references to the preferred individuals among every input list, creating a weighing system that then determines teams.

Glossary
---
### PageRank
This function is the meat of the program and fulfills the PageRank requirement of the project by attempting to create our own version of Google's PageRank system that works for preferences. The majority of the work comes from an internal function inside of there called 'calc' that recieves how many nodes there are and then begins to count the links between the various nodes accepted. With the amount of links and the weight of the links, the PageRank for every single node is created.
### Perfs
The Perfs function scans in the files submitted by the user, filtering through them and accepting everyone's preferences in order. These are then sorted into arrays of descending preference, made fo reach individual person.
### PrimaryFunction
This function runs everything, it's the central hub through which all other functions are accessed. It also defines the map where the PageRank function will be run through. 

Inception Deck
---
### Why are we here?
The purpose of the project is to design a system based upon Google's pagerank algorithm that counts references towards certain targets in distributing input strings into teams. Our customers could include teachers, professors, or managers meant to split up work for projects based on preference.

### Pitch
For teachers who need to organize students into teams, the GoogleHappy sorting system is a program that sorts input people based on preferences and how often people prefer having them, unlike Canvas' random team creation program.

### Product Box
If you are a teacher or project leader, you know team selection can be a hard task. That's why GoogleHappy was made to solve the problem. The GoogleHappy program uses a version of Google's pagerank algorithm and the preferences of users to assign people into teams based on happiness and reference numbers. Give it a try today with a thirty-day trial for 59.98, if you don't like it you can have your money back!

### The Not List
There will be no user interface, nor will it require an internet connection.

### Meet Your Neighbors
There were only three people working on this project without any third party influence besides our client (Dr. Reeves).

### Our Solution
What makes our solution different from the rest is allowing user verbosity to alter the way that pagerank is looked at within the system, either putting preference towards those with higher references towards them or those with lower references. This added preferential option helps professors and managers choose what kind of team they prefer, also giving options to look at multiple optimal teams.

### What Keeps Us Up At Night
Deciding between the most and least references for pagerank having more weight is something that was keeping us wondering what we should focus on. Along with that, one of our big issues was keeping in contact online, which we used a discord group and a group text to keep up communication best we could.

### Size It Up
The project took roughly four weeks, the first week being spent discussing pagerank and working on implementing a pagerank algorithm. Week two was figuring out what to do with it, where issues arise, and beginning to put people into teams. The third week was proper sorting and weighing with the pagerank. And the last week was simply polish, allowing verbosity from the command line.

### Be Clear on What is Going to Give
Our most important thing was quality, scope and budget were very strictly defined. The hope of the project was to deliver a very usable software by the end of the four weeks, fulfilling our 'A' proposal condition.

### What is it Going to Take
We know how to make sorting into teams. What we really need is to determine a pagerank algorithm and determine the weight of someone with more references towards them than less.

### Drucker Results
##### Wade
###### Top 3 Strengths
1. Natural diplomat
2. Attention to detail
3. Crunch-time guarantees
###### How Do You Perform?
* Hate office politics
* Afternoon/night person
* Minimialist
###### What Are Your Values?
* Respect for others
* Honesty
* Continuous improvement
###### What Can You Contribute?
* A realistic plan
* A wonderful user experience
* Rigorous exploratory testing

##### Nicolas
###### Top 3 Strengths
1. Attention to detail
2. Excellent listener
3. Get things done
###### How Do You Perform?
* Love eliminating waste
* List maker
* Working alone and group coding
###### What Are Your Values?
* Respect for others
* Doing a quality job
* Having fun :)
###### What Can You Contribute?
* Rigorous exploratory testing
* A realistic plan
* Quality code

##### Ben
###### Top 3 Strengths
1. Finding the optimal way to do things (or at least trying to)
2. Can communicate with others
3. Knows how to type
###### How Do You Perform?
* Perfer to work in larger chunks instead of spreading it out
* Forced to be a morning person
* Professional time waster
###### What Are Your Values?
* Likes having fun
* Wants to get good grades
* Want to learn about the places I don't know much about
###### What Can You Contribute?
* Ideas
* Code
* Other stuff
