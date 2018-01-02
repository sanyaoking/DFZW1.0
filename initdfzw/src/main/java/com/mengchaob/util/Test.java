package com.mengchaob.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] arg) throws Exception{

        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //取出session
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List list = session.selectList("dfzwtest.selectuser");
            System.out.println("aaaa");
        } finally {
            session.close();
        }

    }
}
