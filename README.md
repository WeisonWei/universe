# universe

## 权限的维度设计
  1. 查询权限
  2. 上报权限

## 日志收集：
 1. 通过采集的方式
 2. 支持上报的方式
    ps:上报格式的设计

## 系统支持的功能
  1. 向kfk生产，消费
  2. 多数据源的推送
  3. 日志关键字维度的解析
  4. 实时解析上报的数据问题
  
## 与Es的交互
  1. 向不同版本的ES推送数据
  2. 对数据进行增删改查(设计超时时间)
  3. 页面的开发
  
## Es与kbn的结合

## Build dev env
### 1 portainer
docker run -d --privileged --restart always --name portainer -v /data:/data -v /var/run/docker.sock:/var/run/docker.sock -p 9000:9000 portainer/portainer
[containers](http://localhost:9000/#/containers)

### 2 registry2
sudo docker run -d --restart always --name registry2 -v registry_data:/var/lib/registry -p 5000:5000 registry:2

### 3 zookeeper
docker pull wurstmeister/zookeeper
docker run -d --name zookeeper -p 2181:2181 -v /etc/localtime:/etc/localtime wurstmeister/zookeeper

### 4 kafka
docker pull wurstmeister/kafka:2.11-0.11.0.3
docker run  -d --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.250.1:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.250.1:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -t wurstmeister/kafka

#### 4.1 topic
docker exec -it kafka /bin/bash
cd /opt/kafka_*
bin/kafka-topics.sh --create --zookeeper 192.168.250.1:2181 --replication-factor 1 --partitions 1 --topic uvsLog
#### 4.2 producer
bin/kafka-console-producer.sh --broker-list 192.168.250.1:9092 --topic uvsLog
#### 4.3 consumer
bin/kafka-console-consumer.sh --bootstrap-server 192.168.250.1:9092 --topic uvsLog --from-beginning 

### 5 mysql
docker pull mysql

#### 5.1 set root passwd
sudo docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql
#### 5.1 create database
```sql
CREATE DATABASE uvslog;
show DATABASES;
use uvslog;
```

[mysql(https://www.cnblogs.com/sablier/p/11605606.html)  


![img.png](META-INF/img.png)
[spring-kafka](https://spring.io/projects/spring-kafka) 

