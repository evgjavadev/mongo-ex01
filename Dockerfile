FROM openjdk:11.0.10-jdk

COPY target/mongo-todo-0.0.1-SNAPSHOT.jar /app/application.jar

WORKDIR /app

# ENV MONGO_DB_HOST=host.docker.internal
# ENV MONGO_DB_HOST=mongodb_5

# EXPOSE 8080

ENTRYPOINT ["java","-jar","application.jar"]