package wood.mike

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.ListOperations
import org.springframework.data.redis.core.RedisTemplate

import javax.annotation.Resource

class RedisService {

    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    void addLink( String userId, Integer randomId ) {
        println "Adding user $userId and random ID $randomId"
        listOps.leftPush(userId, randomId);
        listOps.leftPop(userId)
    }
}