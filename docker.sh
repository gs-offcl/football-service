docker build -t football-service:1.0.0 --no-cache -f Dockerfile .
docker container run --name c_football-service -d -p 8080:8080 -t football-service:1.0.0