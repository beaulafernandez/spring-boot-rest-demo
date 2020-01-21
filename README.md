# spring-boot-rest-demo

Run the project:
1. Download the zip / Clone the project
2. Traverse to the folder /target in the command line
3. Run the command 'java -jar spring-boot-rest-demo-0.0.1-SNAPSHOT'

Set up workspace :
1. Prerequisites : Java & Maven & IDE (Eclipse / IntelliJ)
2. Download the zip / Clone the project
3. Import into eclipse,as an existing maven project
4. Build/Run - mvn spring-boot:run

Endpoints :
1. view accounts of a customer : <baseurl>/customer/accounts/<customerId>
2. view transactions of an account : <baseurl>/account/transactions/<accountNo>

eg : sample customer id : CRN12345 / sample account number : 585309209
view accounts - http://localhost:8080/customer/accounts/CRN12345
view tranactions - http://localhost:8080/account/transactions/585309209

Database : h2 filed-base.
To access the database use the URL, http://localhost:8080/h2-console/ once the application is up and running.
The sql query to load the database is present in the data.sql. This file runs on start up of the application.
Note : 
->when you run the application use the existing h2 folder in the same project folder structure which contains the data and remove the data.sql file.
->if the data.sql is not removed - delete the any exisitng h2 folder before running the application. 

