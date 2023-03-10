#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=mangopot

echo "> 현재 실행 중인 Docker 컨테이너 pid 확인" >> /home/ec2-user/app/step2/deploy.log
CURRENT_PID=$(sudo docker container ls -q)

if [ -z $CURRENT_PID ]
then
  echo "> 현재 구동중인 Docker 컨테이너가 없으므로 종료하지 않습니다." >> /home/ec2-user/app/step2/deploy.log
else
  echo "> sudo docker stop $CURRENT_PID"   # 현재 구동중인 Docker 컨테이너가 있다면 모두 중지
  sudo docker stop $CURRENT_PID
  sudo docker system prune -a -f
  sleep 5
fi

cd /home/ec2-user/app/step2/zip/

echo ">docker-compose up" >> /home/ec2-user/app/step2/deploy.log
nohup docker-compose up > $REPOSITORY/nohup.out 2>&1 &