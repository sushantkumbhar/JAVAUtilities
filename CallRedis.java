ackage test;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisCommands;

import redis.clients.jedis.JedisPool;

import redis.clients.jedis.JedisPoolConfig;

public class CDBRadisCache {

      public static void main(String[] args)

      {

            try{

                  setCardKeyUserName("key1","100");

                  System.out.println(getUserName("key1"));

            }

            catch(Exception e)

            {

                  e.printStackTrace();

            }

      }

 

      {

           

      }

      @SuppressWarnings("resource")

      public static String setCardKeyUserName(String CardKey ,String UserName)

      {

            Jedis jedis = new Jedis("host",6379,8000);

            jedis.set(CardKey,UserName);

            System.out.println("Set is completed");

            jedis.close();

            return UserName;

      }

 

      @SuppressWarnings("resource")

      public static String getUserName(String CardKey)

      {

            //JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

          //jedisPoolConfig.setMaxWaitMillis(10000);

           

          int readTimeout=50000;

          //JedisPool pool = new JedisPool(jedisPoolConfig, "host", 6379,readTimeout);

            Jedis jedis = new Jedis("host",6379,8000);

            System.out.println("Get is completed");

            //return((JedisCommands) pool).get(CardKey);

            jedis.close();

            return jedis.get(CardKey); 

 

      }

}