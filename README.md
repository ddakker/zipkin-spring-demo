



```
## Zipkin Install for windows
git clone https://github.com/openzipkin/zipkin
cd zipkin

mvnw -DskipTests --also-make -pl zipkin-server clean install

java -jar zipkin-server\target\zipkin-server-2.12.3-SNAPSHOT-exec.jar

http://localhost:9411/zipkin/
``