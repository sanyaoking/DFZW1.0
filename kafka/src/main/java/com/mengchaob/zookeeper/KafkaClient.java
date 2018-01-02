package com.mengchaob.zookeeper;

import com.mengchaob.util.ContextDFZW;
import io.vertx.core.Vertx;
import io.vertx.kafka.client.consumer.KafkaConsumer;

import java.util.HashMap;
import java.util.Map;

public class KafkaClient {
    public static void init(){
        //在一个服务用中应该统一使用同一个vertx
        Vertx vertx = Vertx.vertx();
        Map<String, String> config_consume = new HashMap<>();
        config_consume.put("bootstrap.servers", ContextDFZW.getkafkaPbyKey("bootstrap.servers"));
        config_consume.put("key.deserializer", ContextDFZW.getkafkaPbyKey("key.deserializer"));
        config_consume.put("value.deserializer", ContextDFZW.getkafkaPbyKey("value.deserializer"));
        config_consume.put("group.id", ContextDFZW.getkafkaPbyKey("group.id"));
        config_consume.put("auto.offset.reset",ContextDFZW.getkafkaPbyKey("auto.offset.reset"));
        config_consume.put("enable.auto.commit", ContextDFZW.getkafkaPbyKey("enable.auto.commit"));
        KafkaConsumer<String, String> consumer = KafkaConsumer.create(vertx, config_consume);
        consumer.handler(record -> {
            System.out.println("Processing key=" + record.key() + ",value=" + record.value() +
                    ",partition=" + record.partition() + ",offset=" + record.offset());
        });


//        //增加主题
//        consumer.subscribe("test");
//        for (int i = 0; i < 5; i++) {
//            // only topic and message value are specified, round robin on destination partitions
//            KafkaProducerRecord<String, String> record =
//                    KafkaProducerRecord.create("test", "message_" + i);
//            producer.write(record);
//        }
    }
}
