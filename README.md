# Simple Distributed System: Time Synchronization Server and Client #

## 1. Overview ##

The primary goal of this assignment is to learn how to develop a simple distributed system by building a distributed time synchronization service. Your system should consist of two parts -- a server and a client -- that implement a time synchronization protocol of your choice.  Multiple instances of your client should be able to synchronize their respective clocks in parallel with your server.

A second goal of this assignment is to familiarize ourselves with working with a real distributed cloud environment consisting of two separate physical machines. To this end, you should demonstrate your system working with your time synchronization server running on a remote cloud machine on a cloud platform of your choice and client instances running on your local machine. The amount of cloud resources required for this assignment is minimal and will fit within the free tier or free educational credits offered by popular cloud service platforms (e.g., Amazon Web Services’ EC2 service). You can do all of your development and testing on your local machine and will need a cloud machine only for the very last step.

You can do this assignment in teams of at most two. 

## 2. Assignment Steps ##

Proceed in the following steps to complete this assignment.

* **Step 1**: Familiarize yourselves with the “hello world” code snippets demonstrated in class. You are unlikely to be able to do this assignment unless you can successfully exchange messages between a simple client and server program. The choice of the communication abstraction to use in this assignment is up to you.

* **Step 2**: Design your time synchronization protocol. “Time” in this assignment refers to UNIX time in milliseconds, i.e., the number of seconds elapsed since midnight, January 1, 1970, for example, System.currentTimeMillis() in Java returns the local UNIX time. Designing your protocol involves the following sub-steps and design constraints:
	
	1. Choose the communication abstraction you plan to use.
	2. Choose the time synchronization protocol you plan to implement.
	3. Identify the message types and the format of the data carried within the messages exchanged between the client and server. 
	4. Ensure that your design allows your server to talk to multiple client instances simultaneously communicating with it.
	5. Simply make your client maintain a separate local variable for its time synchronized with the remote server. Your client does NOT have to change the system clock on the local machine.

* **Step 3**: Implementation and testing instructions:
	1. Your server should be named TSServer.ext where .ext is the appropriate language extension, e.g., .java and .class for java source and binary; .py for python, .c and .o for C source and binary, and so on. Similarly, your client should be named TSClient.ext.
	2. Your server should be runnable without any arguments. Your client should expect a single optional string argument identifying the server host (either a hostname or the host IP address); if no argument is specified, the default hostname should be localhost (or 127.0.0.1). You should be able to test your system as follows by running each command on a separate terminal:

		Local testing example:
	
   				java TSServer
  				java TSClient

		Distributed testing example:
	
  				python TSServer.py
 				python TSClient.py <remote_host>

		Multiple clients local testing example:
	
  				java TSServer
 				java TSClient
 				java TSClient
  
	3. If you write your program in a compiled language (as opposed to an interpreted language), the binary files must be generated in the same directory as the source files. If you are using C, please include a Makefile. If you are using Java, include pre-compiled class files as part of your submission.


	4. After a few seconds of running your synchronization protocol, your client should print (1) REMOTE_TIME: the value of its local variable maintaining the time synchronized with the server; (2) LOCAL_TIME: the local time on the machine; and (3) RTT_ESTIMATE: the estimated round-trip time between your client and your server. The last three lines of your client’s output should look as follows with each line having a string and a number of milliseconds separated by whitespace.

		REMOTE_TIME    1568570955
		
		LOCAL_TIME        1568570962
		
		RTT_ESTIMATE    118


	5. Have your server listen on a unique port that is 10,000 + the last 4 digits of your student ID (either one of the two teammates’ ID). This will help our experimental autograder (see further below) run different teams’ servers in parallel on a common remote machine we maintain.
	6. Make sure you document your code clearly. Documentation is as much for your own benefit as it is for us to read your code.


## 3. Submission ##

You need  to submit the following on Gradescope:

1. A design document named TSDesign.pdf listing the team member names and student IDs, describing your design briefly (<1 page), and including three screenshots as follows. The first screenshot should show your server and client running on your local machine. The second screenshot should show your server running on a remote cloud machine and your client running on your local machine. The third screenshot should show your server running on a remote machine and two separate client instances started simultaneously on your client machine:

	* Tip: On Linux/MacOS or other Unix machine, you can simply start the two clients near-simultaneously by starting the first as a background process using ‘&’:
    		python TSClient & python TSClient 
			Alternatively, you can write a simple (synchronization-free) multithreaded client program to start two instances of your client in two separate threads back-to-back.


2. Your source code and pre-compiled platform-agnostic binaries (if relevant).
3. We have a simple auto-grader for the programmatic part of this assignment. You would need to stick to the naming and output format instructions above exactly in order to get any useful feedback from the autograder. 
	* The final tests and test environment may be different from that before the submission deadline, so while the autograder should offer you helpful feedback, its score may not neccessarily be reflective of your final score.
	* Please bear with any rough edges in this autograder and rest assured that the TAs will also review your submissions manually.
	* If you plan to use any language other than Python or Java or C or C++, you need to confirm that with the TAs first so they can try to support it in the autograder. We can not guarantee support for all languages, but will try.


