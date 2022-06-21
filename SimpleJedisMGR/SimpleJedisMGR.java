package net.nebulabc.viridiantools.tools;

import net.nebulabc.viridiantools.Viridiantools;
import redis.clients.jedis.Jedis;

public class SimpleJedisMGR {

    private static final String JedisPass = "some-secure-password";
    public static String get(String key) {
        Jedis j = null;
        try {
            j = Viridiantools.pool.getResource();
            //j.auth(JedisPass);
            return j.get(key);
        }finally {
            assert j != null;
            j.close();
        }
    }
    public static void set(String key, String value) {
        Jedis j = null;
        try {
            j = Viridiantools.pool.getResource();
            //j.auth(JedisPass);
            j.set(key, value);
        }finally {
            assert j != null;
            j.close();
        }
    }
    public static boolean check(String key) {
        Jedis j = null;
        try {
            j = Viridiantools.pool.getResource();
            //j.auth(JedisPass);
            return j.get(key) != null;
        }finally {
            assert j != null;
            j.close();
        }
    }
}
