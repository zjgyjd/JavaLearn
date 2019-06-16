package com.zjgyjd;

import com.zjgyjd.mapper.UserMapper;
import com.zjgyjd.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * MyBatis的API
 *  1， SqlSessionFactory  一次只创建一个
 *  2,  SqlSession       每次用开启,用完关闭
 */
public class MybatisTest {

    public SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitial() {
        String strFile = "sqlMapConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(strFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = (User) sqlSession.selectOne("mytest.queryUserById", 53);
            System.out.println(user);
            List<User> user2 = sqlSession.selectList("mytest.queryUserByUser", "王");
            System.out.println(user2);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();//别忘了关我呦
        }
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User s = new User();
        s.setUsername("YH");
        s.setBirthday(null);
        s.setAddress("SX");
        s.setSex("1");
        try {
            sqlSession.selectOne("mytest.addUser", s);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();//别忘了关我呦
        }
    }

    @Test
    public void testQueryUserByUser() {
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> usersList = userMapper.queryUserByUser("王");
            System.out.println(usersList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
