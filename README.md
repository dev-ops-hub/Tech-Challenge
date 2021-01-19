# ANGULARJS-SPRINGBOOT

<b>FUNCTIONAL FLOW</b>
<ol>
<li>This is a web application form to allow users to submit inquiries into the system.</li> 
<li>A web form will be displayed to the user to fill in their inquries. Upon success submission,
an acknowledgement will be displayed.</li>
<li>There will be validation checks to make sure all the necessary information is filled in</li>
<li>If an error encounters, an error page will be displayed. </li>
<li>In addition, admin can retrieve all the enquries submit by entering the userId and password</li>
</ol>

<b>TECHNICAL DETAILS</b>
<ol>
<li>The application is based on AngularJS and SpringBoot application.</li> 
<li>The java files are compiled using java 1.8.</li>
<li>MySQL (version 8) databases are used to store the inquries for the time being. 
It will be implemented with mongoDB at later stage.</li>
<li>All the application and databases are run in a docker container</li>
<li>Ansible is used to build the docker image and deploy into the target machine. (see DevOps folder)</li>
<li>AWS will be used to host the environment. (see below for the architecture diagram)</li>
<li>ec2 instances are based on ubuntu server 18 image. </li>
<li>There will be 4 ec2 instances setup: (1) Jenkins; (2) Ansible build host; (3)Web Application; (4)Database Server</li>
</ol>

The folder structure:
<br>  -- AngularJS-SpringBoot - src -> Store all the java files
<br>  -- DeveOps - Ansible -> Store the ansible scripts
<br>             - Docker  -> Store the dockerfile
<br>             - setup   -> scripts to install docker, database and tables creation 
             
             
# Screenshots
![](https://github.com/dev-ops-hub/restful-queryform/blob/main/architecture.jpg)