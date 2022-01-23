#!/bin/sh
mvn clean package && docker build -t com.khoders.smartschool/smartweb .
docker rm -f smartweb || true && docker run -d -p 9080:9080 -p 9443:9443 --name smartweb com.khoders.smartschool/smartweb