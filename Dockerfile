FROM openjdk:12
LABEL maintainer="chathurangat@gmail.com"
WORKDIR /app
EXPOSE 8085
COPY target/selling-items-service.jar /app/selling-items-service.jar
ENTRYPOINT ["java","-jar","selling-items-service.jar"]