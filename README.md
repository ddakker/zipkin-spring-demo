# Zipkin 을 이용하여 애플리케이션간 흐름을 추적하고, 각 구간에 대해 모니터링 해보자

## Zipkin Install for windows
```
git clone https://github.com/openzipkin/zipkin
cd zipkin

mvnw -DskipTests --also-make -pl zipkin-server clean install

java -jar zipkin-server\target\zipkin-server-2.12.3-SNAPSHOT-exec.jar
```
http://localhost:9411/zipkin/

## Demo App
```
    gradlew :web-home:bootRun
    gradlew :web-api:bootRun
```
* http://localhost:8180/user/ddakker
* http://localhost:8280/api/user/ddakker

> http://localhost:8180/user/ddakker
>> -> HTTP REST 호출 
>>> http://localhost:8280/api/user/ddakker

