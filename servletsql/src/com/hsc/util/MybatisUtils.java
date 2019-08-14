package com.hsc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils {

    // sqlSession的静态变量
    private static SqlSessionFactory factory = null;

    // 加载配置文件
    static {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
            factory = builder.build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取sqlSession接口
    public static SqlSession getSqlSession(){
        return factory.openSession();
    }

    // 获取sqlSession接口
    public static SqlSession getSqlSession(boolean isAutoCommit){
        return factory.openSession(isAutoCommit);
    }

    // 提交事务，回收资源
    public static void closeSession(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
