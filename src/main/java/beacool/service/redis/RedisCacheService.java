package beacool.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class RedisCacheService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final static long validTime = 60;

    @Autowired
    public RedisCacheService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 根据用户名生成一个token
     * @param accoutNumber
     * @return
     */
    public String generateToken(String accoutNumber){
        String token= UUID.randomUUID().toString().replace("-","");
        redisTemplate.opsForValue().set(token, accoutNumber, validTime, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 根据token获取用户名
     * @param token
     * @return
     */
    public String getAccountNumber(String token){
        return redisTemplate.opsForValue().get(token);
    }

    /**
     * 删除某个token
     * @param token
     */
    public void deleteToken(String token){
        redisTemplate.delete(token);
    }
}
