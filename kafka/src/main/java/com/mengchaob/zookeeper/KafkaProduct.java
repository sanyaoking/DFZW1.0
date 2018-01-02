package com.mengchaob.zookeeper;

import com.mengchaob.util.ContextDFZW;
import io.vertx.core.Vertx;
import io.vertx.kafka.client.producer.KafkaProducer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProduct {

    public static void init(){
//按照kafka官网启动服务后，要注意修改kafka配置文件中的zookeeper.properties中的dataDir的路径存在
        //然后启动代码目录下静态文件中的kafka服务
        //1. bin/zookeeper-server-start.sh config/zookeeper.properties
        //2. bin/kafka-server-start.sh config/server.properties
        //完成上面步骤后，就可以运行本段代码
        //创建生产者start
        Map<String, String> config_product = new HashMap<>();
        //kafka默认的服务端口
        config_product.put("bootstrap.servers", ContextDFZW.getkafkaPbyKey("bootstrap.servers"));
        config_product.put("key.serializer", ContextDFZW.getkafkaPbyKey("key.serializer"));
        config_product.put("value.serializer",ContextDFZW.getkafkaPbyKey("value.serializer"));
        config_product.put("acks",ContextDFZW.getkafkaPbyKey("acks"));
        Vertx vertx = Vertx.vertx();
        KafkaProducer<String, String> producer = KafkaProducer.create(vertx, config_product);
    }
}
