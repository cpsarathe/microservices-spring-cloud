# spring-boot-microservices

### 1. start rabbit mq server
> docker run -d --name rabbit-name-management -p 15672:15672 -p 5672:5672 -p 5671:5671 -e RABBITMQ_DEFAULT_USER=guest –e RABBITMQ_DEFAULT_PASS=guest rabbitmq:3-management

verify using web interface 

> http://localhost:15672/#/

### 2. start cloud config server , and as a prerequisite setup db schema and db table using cloud-config-server/db-scripts.sql
> http://localhost:9090/cloud-config-server/jdbc/latest

### 3 . start eureka server for microservices to be auto discoverable
> http://localhost:9070/

### 4. start zuul-api-gateway , it helps in routing , monitoring , resiliency it also get registered with eureka server
> http://localhost:9070/
> flow  https://miro.medium.com/max/3000/1*MReN7nz3HPh4ypoPJG4tHQ.png 

### 5. start user-ws application which after startup get registered with eureka server
> reload http://localhost:9070/ and see app name listed

> Direct user services access 
> http://localhost:8007/users/1 

> User Service Access via ZUUL API Gateway 
> http://localhost:9080/user-ws/users/1

### 6. This user creation request via POST call will send event to RabbitMQ and would be consumed by account application
> http://localhost:9080/user-ws/users
 
body 
>  {
    "firstName": "cp1",
    "lastName": "sarath1e",
    "email": "cp1.sars@gmddail.com",
    "password": "df2354534512"
   }

### 7. Start Account application and check in the console listener message "Users Registered by Client" 