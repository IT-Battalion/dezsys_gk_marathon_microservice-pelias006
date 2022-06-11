FROM openjdk:8-jre
ADD target/DEZSYS_GK_MARATHON_MICROSERVICE-2.1.0.RELEASE.jar app.jar
EXPOSE 1111
EXPOSE 2222
EXPOSE 3333
EXPOSE 4444
# Optional default command
# ENTRYPOINT ["java","-jar","/app.jar","reg"]
