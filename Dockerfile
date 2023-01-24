FROM openjdk:17-jdk-alpine
COPY "./target/PayMethosRiderAPP-01.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]