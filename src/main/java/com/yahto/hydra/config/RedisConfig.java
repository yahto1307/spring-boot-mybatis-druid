//package com.yahto.hydra.config;
//
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.time.Duration;
//
///**
// * Created by yahto on 2019-06-05 17:21
// *
// * @author yahto
// */
//@Configuration
//@Slf4j
//public class RedisConfig {
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.database}")
//    private int database;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//    @Value("${spring.redis.ssl}")
//    private boolean ssl;
//
//    @Value("${spring.redis.connection-timeout}")
//    private int connectionTimeout;
//
//
//    @Bean(name = "redisTemplate")
//    @Primary
//    public RedisTemplate<String, Object> redisTemplate(@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory,
//                                                       @Qualifier("fastJsonConfig") FastJsonConfig fastJsonConfig) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        fastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);
//        //key use stringSerializer
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        //value use fastJsonSerializer
//        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean(name = "redisConnectionFactory")
//    @Primary
//    public RedisConnectionFactory connectionFactory() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(maxActive);
//        poolConfig.setMaxIdle(maxIdle);
//        poolConfig.setMaxWaitMillis(maxWaitMillis);
//        poolConfig.setMinIdle(minIdle);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(false);
//        poolConfig.setTestWhileIdle(true);
//        JedisClientConfiguration jedisClientConfiguration = null;
//        if (ssl) {
//            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
//                    poolConfig(poolConfig).and().
//                    readTimeout(Duration.ofMillis(connectionTimeout)).useSsl()
//                    .build();
//        } else {
//            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
//                    poolConfig(poolConfig).and().
//                    readTimeout(Duration.ofMillis(connectionTimeout)).build();
//        }
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//
//        redisStandaloneConfiguration.setDatabase(database);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
//        redisStandaloneConfiguration.setHostName(host);
//        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
//    }
//
//
//    @Bean("cacheManager")
//    @Primary
//    public CacheManager cacheManager(@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
//                .RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFactory);
//        return builder.build();
//    }
//}
