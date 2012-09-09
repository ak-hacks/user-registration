#!/bin/sh

#Simple shell script to hit the registration service 10 times to showcase thread pooling capability

for i in {1..10}
do curl http://localhost:8080/UserRegistration/user/add.htm?firstname=firstname$i
done