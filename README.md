# lets-simulate-httpd

# How to use

## A. Setup Minikube
```
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
minikube start --memory=8192 --cpus=4
eval $(minikube docker-env)
```

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

## C. Apply k8s resources
```
$ kubectl apply -f k8s/istio-deployment.yml
$ kubectl apply -f k8s/httpd-deployment.yml
$ kubectl apply -f k8s/tomcat-deployment.yml
```

Others
```
kubectl delete pod -l app=httpd
kubectl delete pod -l app=tomcat
minikube service istio-ingressgateway -n istio-system
```