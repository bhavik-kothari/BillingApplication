# BillingApplication

This application is purely intended to be prepared as a part of assignment to demonstrate low level design of Billing Application.

It is prepared using IntelliJ IDE, MySQL, Spring Boot framework - JPA, RESTful WebServices, Hikari Connection Pool, Mock based Unit Testcases, SonarLint (SonarQube).

Kindly, setup the mysql database first by importing the "billing.sql" file, so that project can be executed. Do consider both DDL and DML statements from the SQL file. Also check and update mysql username and password as per requirements.

There are mock based unit test cases prepared to consider various scenarios which are covered up in OrderEndpoint class and other Service classes.

Considering Spring Boot application, one can start the application by executing my.assignment.billing.BillingApplication.java which will deploy the application directly using tomcat. 

I have prepared one REST Webservice exposed as given below:

1. POST request
2. URL -> http://localhost:8080/api/v1/order/getDiscount
3. Header -> Content-Type : application/json
4. Body ->

	{
    	"user" : {
    		"username" : "bhavik"
    	},
    	"productOrders" : [
    		{
    			"id" : "1",
    			"quantityToOrder" : "1"
    		},
    		{
    			"id" : "3",
    			"quantityToOrder" : "1"
    		},
    		{
    			"id" : "4",
    			"quantityToOrder" : "1"
    		},
    		{
    			"id" : "5",
    			"quantityToOrder" : "1"
    		}
    	]
    }

