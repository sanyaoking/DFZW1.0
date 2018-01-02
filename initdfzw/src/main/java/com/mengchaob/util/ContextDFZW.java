package com.mengchaob.util;

import org.apache.ibatis.io.Resources;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.function.BiConsumer;

/**
 * 装载整个系统的配置信息的上下文环境
 */
public class ContextDFZW {
    private static String kafkaProperties="";
    private static String mybatisConf = "";
    private static  HashMap<String,String> kafkaprocli = new HashMap<String,String>();

    public static String getkafkaPbyKey(String key){
        return kafkaprocli.get(key);
    }

    public static String getMybatisConf() {
        return mybatisConf;
    }

    public static void init() throws IOException {
        kafkaProperties="kafka/kafkaproduct_client.properties";
        mybatisConf="mybatis/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(kafkaProperties);
        Properties p = new Properties();
        p.load(is);

        BiConsumerImplContextDFZW bi = new BiConsumerImplContextDFZW(kafkaprocli);
        p.forEach(bi);
    }
    static class BiConsumerImplContextDFZW implements BiConsumer{
        private HashMap<String,String> kafkaprocli=null;
        public BiConsumerImplContextDFZW(HashMap<String,String> kafkaprocli){
            this.kafkaprocli = kafkaprocli;
        }
        @Override
        public void accept(Object o, Object o2) {
            String key = (String)o;
            String value = o2==null?"":(String)o2;
            kafkaprocli.put(key,value);
        }
    }
    public static void main(String[] arg){
        try {
            ContextDFZW.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
