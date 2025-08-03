# lets-simulate-httpd

# How to use

## A. Setup Minikube

## B. Build Docker image
From application root directory
### 1. Build docker image for httpd
```
# From application root directory.
$ docker build -f docker/Dockerfile-httpd -t my-httpd:latest docker/
```

### 2. Build docker image for application on tomcat
```
$ docker build -f docker/Dockerfile-tomcat -t my-tomcat:latest docker/
```
