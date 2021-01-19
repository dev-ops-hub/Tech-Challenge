#!/bin/sh

## Set the user 
SET USER = ubuntu

sudo apt-get update
sudo apt install awscli -y
sudo apt install docker.io -y

## Enable docker service to run at startup
sudo systemctl start docker
sudo systemctl enable docker

## set permission to the unix socket to communicate with engine 
## After running the below command, completely log out of your account and log back in
## Then you wont need the sudo to execute the docker command
sudo usermod -a -G docker $USER

#pull mysql image
docker pull mysql

#run the docker
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin -v ./data -d mysql:latest