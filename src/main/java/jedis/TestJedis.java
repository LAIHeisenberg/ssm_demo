package jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class TestJedis {


    private JedisPoolConfig jedisPoolConfig;
    private JedisPool jedisPool;
    private Jedis jedis;

    @Before
    public void initJedisPool(){
        System.out.println("----- init");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxIdle(20);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);

    }

    @After
    public void destroyJedisPool(){
        System.out.println("-----  destroy");
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testJedis(){

        jedis = jedisPool.getResource();
        jedis.sadd("mySet","laiyaozong");
        jedis.sadd("mySet","laihuiying");

        Set<String> mySet = jedis.smembers("mySet");
        for (String s : mySet){
            System.out.println(s);
        }
    }

}
