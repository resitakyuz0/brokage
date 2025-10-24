Hello, 

I used Spring Web, Spring Security, H2 Database, Spring JPA, Lombok and Mockito for this project

The application gets populated with seed data automatically when you run it, and use an in-memory 
database, no additional configuration is needed.

I used Basic Auth so be sure to send username and password by selecting it in the client tool you use.

Username:user
Password:password

The application basically has two controllers which control the assets and orders namely AssetController
and OrderController. 

For the orders endpoint urls are 

localhost:8080/Orders METHOD:GET-> list the orders

localhost:8080/Orders METHOD:POST-> create new order but does not update until matched

localhost:8080/Orders/id METHOD:POST-> matches the given pending order and update corresponding fields

For simplicity matcher method just takes the id of the order to be matched (not the customerId, unique Id of the Orders table)

The other methods should be straightforward

Used repository pattern and service layer.

Project uses maven dependencies

mvn package

mvn spring-boot:run

commands can be used to build and run, or any IDE will suffice