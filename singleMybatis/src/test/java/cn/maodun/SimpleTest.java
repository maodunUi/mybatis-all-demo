package cn.maodun;

import cn.maodun.singleDemo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试前修改命名空间为 namespace="UserMapper"
 *
 * @author DELL
 * @date 2022/9/20
 */
public class SimpleTest {

    @Test
    //查询操作
    public void testSelectList() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    //插入操作
    public void testSave() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUname("xxx");
        user.setUpassword("abc");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数：namespace+id
        sqlSession.insert("userMapper.save", user);

        //mybatis执行更新操作  提交事务
        //sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //修改操作
    public void testUpdate() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUid(3);
        user.setUname("lucy");
        user.setUpassword("123");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.update("userMapper.update", user);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //删除操作
    public void testDelete() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.delete("userMapper.delete", 3);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //查询一个对象
    public void testQuery() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
}
