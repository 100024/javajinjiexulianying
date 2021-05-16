1.执行java -jar gateway-server-0.0.1-SNAPSHOT.jar 启动相关服务 （8088端口）
2.sb -u http://localhost:8088 -c 40 -N 30 (40个线程 持续30秒进行压测)

结果：RPS：2914.2 （每秒可处理请求2914.2个）