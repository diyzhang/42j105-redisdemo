package cn.toj.redisdemo;

import cn.toj.redisdemo.dao.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * @author Carlos
 * @description Redis操作类
 * @Date 2020/7/16
 */

public class RedisDemo {

    //1.创建一个字符串常量REDIS_KEY，当作存入的key
    private static final String REDIS_KEY = "Carlos";

    public static void main(String[] args) {

        //2. 创建Redis连接
        Jedis jedis = new Jedis("localhost", 6379);

        //3. 创建类的序列化反序列化对象
        Gson gson = new Gson();

        //4. 创建一个User类并使用构造函数进行赋值，再使用gson对象将其序列化为String类型的字符串
        User user = new User(25, "Carlos", "Male", "Beijing, Haidian");
        String userToJson = gson.toJson(user);

        //5. 查看Redis是否存在key值为Carlos的键值对
        System.out.println("Redis中当前是否存在key值为Carlos的键值对：\n" + jedis.exists(REDIS_KEY) + "\n");

        //6. 将REDIS_KEY和被序列化话的user对象分别作为键值对的key和value存入Redis中
        jedis.set(REDIS_KEY, userToJson);

        //7. 再次查看Redis是否存在key值为Carlos的键值对
        System.out.println("执行jedis.set方法后否存在key值为Carlos的键值对：\n" + jedis.exists(REDIS_KEY) + "\n");

        //8. 使用get方法获得存入的value值
        System.out.println("使用get方法获得存入的value值：\n" + jedis.get(REDIS_KEY) + "\n");

        //9. 根据get方法的获得value值转换为User对象并输出
        User userFromJson = gson.fromJson(jedis.get(REDIS_KEY), User.class);
        System.out.println("根据get方法的获得value值转换为User对象：\n" + userFromJson + "\n");

        //10. 根据key值删除键值对并输出Redis中是否还存在key值为Carlos的键值对
        jedis.del(REDIS_KEY);
        System.out.println("根据key值删除键值对后Redis是否还存在key值为Carlos的键值对：\n" + jedis.exists(REDIS_KEY));

    }

}
