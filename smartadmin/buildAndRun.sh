#!/bin/sh
mvn clean package && docker build -t com.khoders.smartschool/smartadmin .
docker rm -f smartadmin || true && docker run -d -p 9080:9080 -p 9443:9443 --name smartadmin com.khoders.smartschool/smartadmin