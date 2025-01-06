# Docker Instructions

How to run app in Docker Container
---

1. Go to root directory of the application in the terminal
2. Run the following command "docker run -p 8080:8080 coin_calculator"


# Coin Calculator Application

How to start the coin_calculator application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/coin_calculator-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

