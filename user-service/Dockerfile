# Using Java runtime environment (base image)
FROM openjdk:17-jdk-slim

# Giving name for the build time variable (jar file location)
ARG jar_file=build/libs/*.jar

#now copying the jar file from the local(host) to container
COPY ${jar_file} app.jar

#then telling the docker to run the commands after the container starts
ENTRYPOINT ["java","-jar","/app.jar"]

# Explanations

# FROM means start building the image from an existing "Base Image"
# ARG defines a build time variable (used only while building the image)
# here it points to the spring boot  jar file after we runnig the application using ./gradlew build
# build/libs/*.jar -> matches your generated JAR inside the service
# by doing so this will let the docker to know where to find your JAR file inside your service
# folder when copying

# COPY takes file from local folder and puts them inside the Docker image
# (app.jar is the name inside the container - we can name it anything)

# EnTRYPOINT tells the docker to run the command after the container starts
#==========================================================================================
# commands to do in local terminal
# ./gradlew clean build -x test (-x test excludes tests when building)
        # → This creates: user-service/build/libs/user-service-0.0.1-SNAPSHOT.jar
# docker build -t user-service .
        # -t user-service → tags the image with the name user-service.
        # . → means "look for Dockerfile in the current directory".
# docker run -p 8081:8081 user-service
        # Maps your machine’s port 8081 → container’s port 8081.

# check in browser/postman using url ->  http://localhost:8081/user/...  (depending on your controller endpoints).
