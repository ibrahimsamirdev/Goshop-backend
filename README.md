# Goshop-backend
The Back-end of Goshop, an E-commerce platform (Java, Microservices)

##Ports

| Application | Port |
| --- | --- |
| netflix eureka naming server | 8761 |
| spring cloud config server | 8888 |
| product service | 8080, 8081 ,... |
| order service | 8000, 8001 ,... |
| payment service | 8100, 8101 ,... |

##URLs

| Application | Port |
| --- | --- |
| netflix eureka naming server | http://localhost:8761/ |
| spring cloud config server | http://localhost:8888/product-service/dev http://localhost:8888/product-service/default |
| product service | http://localhost:8080/product/config |
| order service | http://localhost:8000/order/config |
| payment service | http://localhost:8000/payment/config |