# Project Overview

Bicycle-catalog is a simple microservice built with Spring Boot and Maven. This serves an API which depends 
on 2 other microservices - bicycle-management and bicycle-ratings. If any of these 2 dependent
microservices fail to respond then a circuit breaker is implemented which will serve data
through a fallback method.  

Service Discovery is achieved using Eureka server and the microservices are Eureka clients
which register with the server.

![Screenshot](microservices.svg)


## API details

## Technology stack

Spring Boot  
Eureka  
Resilience4J