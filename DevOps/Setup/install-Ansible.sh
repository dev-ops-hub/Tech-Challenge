#!/bin/sh

##Execute the following commands to install python and python-pip
sudo apt install python
sudo apt-get install software-properties-common
sudo apt-add-repository universe
sudo apt-get update
sudo apt-get install python-pip 

##Execute the following commands to install boto and boto3
pip install boto
pip install boto3
pip install "urllib3<1.25"
pip install "urllib3<1.24"
pip install "urllib3<1.23"

python
import boto
exit()

##Execute following commands to install Ansible 2.8

sudo apt update
sudo apt-add-repository ppa:ansible/ansible
sudo apt install ansible
