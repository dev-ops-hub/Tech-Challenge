# Ansible playbook to create and load the docker image into the target machine

<ol>
<li>This playbook creates a build directory on the "build" server, copies the Dockerfile to this directory, and then builds the container using the docker_image 
Ansible module. </li>
<li>The source parameter set to "build" tells the module to build a container imagebased on the listed path. 
<li>In this case, the path points to the directory and Dockerfile that were copied to the build host.</li>
<li>Running this playbook successfully builds the container image:</li>
</ol>
<p><b>sudo ansible-playbook -i inventory.ini build.yml</b>


<ol>
<li>This playbook first archives the image using the docker_image module and then fetches the file from the remote server and 
places it into the local directory.</li> 
<li>After successfully running the playbook, you have a tar file in your local directory that contains the contents of the image:</li>
</ol>
<p><b>sudo ansible-playbook -i inventory.ini save.yml</b>

<ol>
<li>This playbook copies the tarball created in the save.yml playbook to all of the Docker hosts.</li> 
<li>It then loads the container image to make it available to future docker run commands.</li>
</ol>
<br> Save the private key file to SSH authentication agent.  
<br> $ssh-agent bash
<br> $ssh-add ~/.ssh/keypair.pem
<p><b>sudo ansible-playbook -i inventory.ini load.yml</b>

<ol>
<li>login to the target machine and run the docker image in the container</li>
</ol>
<p><b>docker run --rm -it -p 80:8080 webapp-container</b>
