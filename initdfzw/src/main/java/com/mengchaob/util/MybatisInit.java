package com.mengchaob.util;

import io.vertx.core.Future;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisInit {
    private static SqlSession sqs=null;
    public static void init(Future<Void> startFuture) throws IOException {
        String resource = ContextDFZW.getMybatisConf();
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //取出session
        sqs = sqlSessionFactory.openSession();
        startFuture.complete();
    }

    public static SqlSession getSqs() {
        return sqs;
    }
}
