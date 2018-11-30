git pull
mvn clean package
nohup java $* -jar target/training-1.0-SNAPSHOT.jar > /dev/null &