FROM amazoncorretto:17-alpine-jdk
COPY target/jobportalapp.jar jobportalapp.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "jobportalapp.jar" ]