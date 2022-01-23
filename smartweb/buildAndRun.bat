@echo off
call mvn clean package
call docker build -t com.khoders.smartschool/smartweb .
call docker rm -f smartweb
call docker run -d -p 9080:9080 -p 9443:9443 --name smartweb com.khoders.smartschool/smartweb