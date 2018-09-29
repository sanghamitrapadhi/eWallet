# eWallet

# e-Wallet
Technologies and Frameworks used : Java8, Spring Boot, Maven, RestAPI, JPA and Hibernate, Lombok, Swagger UI and H2 inmemory database
NOTE:JAVA8 and Maven should be set

Import the project as Maven project in STS.

In the terminal window, type: mvn clean install

Please make sure lombok is configured in eclipse.ini
NOTE:To configure lombok.jar in eclipse, goto the file location in command prompt and type java - jar lombok-16.22.jar, it will open a popup, mention the path of eclipse.ini and click install/update.

Click Maven -> Update project.

Goto InmemoryWalletApplication.java and run as Spring Boot application.

Open http://localhost:8080/eWallet/h2-console/ which opens the H2 database and can see the tables created.
Player, Account and Transaction

Open http://localhost:8080/eWallet/swagger-ui.html which opens the swagger where the rest API's can be tested
You can see all the controllers and the REST API's
