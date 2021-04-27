# AutomationChallenge
About
This file contains my answers to the Automation Challenge given to me Resolver.

Setup
Step 1
Download JDK 11 (LTS) @    https://www.oracle.com/ca-en/java/technologies/javase-downloads.html

Step 2
Be sure to place the folder  in the default java location.

Step 3
Open System Properties change to the Advance Tab.Click the Environment Variables

Step 4
Add a New System Variable environment Variable Name for java (JAVA_HOME)  for Variable value set the Path to the JDK. click ok.

Step 5 
Then in System Variable edit the path. Add the variable(%JAVA_HOME%\bin) Then click ok.

Step 6
Download Intelli j IDEA community  @  https://www.jetbrains.com/idea/download/#section=windows
(Eclipse also works if you can set up and selenium Project).
Under project settings and select the SDK 

Step 7
Download Maven (package management system) https://maven.apache.org/download.cgi
(I used the zip version)

Step 8
Extract the ZIP.
Move the folder to program files.

Step 9
Open System Properties change to the Advance Tab. Click the Environment Variables
Add a New System Variable environment Variable Name for java (MAVEN_HOME) the path name should lead to the bin folder.

Edit the path variables add (%MAVEN_HOME%\bin)


Project File Setup: 
Step 1
Go to File / New / Project

Step 2
Select Maven / Click next.

Step 3
Choose the name and location then Finish
(In the project outline under the test)

Step 4
Create a resources folder. Right click the parent folder. Select new/ then directory

Step 5
Download Your Chromedriver  https://chromedriver.chromium.org/downloads
Place it in the Resource file.

Step 6 
Place Automation Challenge in the test/java file. 


Run Method:

Click the green triangle on the left hand of the class declaration and select Run

OR

You can look at the top just below the options navigation bar there is a the same larger green triangle while on the file you would like to run.
