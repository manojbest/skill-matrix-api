Prior to build set 
logging:
    file: skill-matrix.log
    path: ~/

Build
./mvnw clean package

Run 
java -Dspring.profiles.active=dev -jar target/skill-matrix-api-0.0.1-SNAPSHOT.jar

OR Using Docker

Build Image 
docker build -t wiley/skill-matrix-api .

Run
docker run -p 8082:8082 wiley/skill-matrix-api 


