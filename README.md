# eWallet

Technologies and Frameworks used : Java8, Spring Boot, Maven, RestAPI, JPA and Hibernate, Lombok, Swagger UI and H2 inmemory database
NOTE:JAVA8 and Maven should be set.
Please open terminal/command prompt and type java -version, should use java1.8.
Please open terminal/command prompt and type mvn -version, it should display latest version of maven.

Import the project as Maven project in STS. Right click and update project.

Please make sure lombok is configured in eclipse.ini
NOTE:To configure lombok.jar in eclipse, goto the path where lombok is in your machine 
(for e.g: type : cd /Users/sanghamitra/.m2/repository/org/projectlombok/lombok/1.16.22/ 
in terminal/command prompt and then type java -jar lombok-16.22.jar), it will open a popup, mention the path of eclipse.ini and click install/update.
Please visit http://www.vogella.com/tutorials/Lombok/article.html for more info
If you are using IntelliJ, visit https://projectlombok.org/setup/intellij 

In the terminal window, type: mvn clean install

Click Maven -> Update project.

Goto InmemoryWalletApplication.java and run as Spring Boot application.

Open http://localhost:8080/eWallet/h2-console/ which opens the H2 database and can see the tables created.
Player, Account and Transaction

Open http://localhost:8080/eWallet/swagger-ui.html which opens the swagger and where the rest API's can be tested

---------------------------------------------------------------------
