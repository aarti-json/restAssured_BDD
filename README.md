API Automation using RestAssured -BDD Framework
Conduct an API testing cycle of the reqres.in using rest assured in BDD framework 

reqres.in - Product Requirements

1.	Users must be able to register with a valid username and password.
2.	Registered users must be able to authenticate with the service.
3.	Users must be informed of errors when using the service.
4.	Users must be able to create new resources.
5.	Users must be able to update existing resources.
6.	Users must be able to remove resources.

Prerequisites

• Eclipse
• Java
• Maven 
• Maven dependencies  – same is downloaded in pom.xml

Running the tests:

1)	Run Through Eclipse 

• Pull the code from GitHub https://github.com/aarti-json/ 
• Import Code 
• Go to Test Suites folder >> Open testng.xml and run the test 

2)	Run through command prompt 

• Download maven-surefire-plugin should be downloaded 
• Open cmd , Go to location of project >>mvn clean >> mvn test

3)	How to check report 

• Go to Test-output >> Open “API_Test_Result.html”

Note – Report is only generated when you will run the test suite from TestNG.xml

Results:

• Logs are generated once testcase completed 
• Report of Pass/Fail test case are generated after completion of test suite 




