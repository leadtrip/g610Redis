package wood.mike

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.hash.HashMapper
import org.springframework.data.redis.hash.Jackson2HashMapper
import org.springframework.data.redis.hash.ObjectHashMapper

import javax.annotation.Resource
import java.util.concurrent.ThreadLocalRandom

class RedisService {

    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name="redisTemplate")
    private HashOperations<String, byte[], byte[]> hashOperations;

    HashMapper<Object, byte[], byte[]> hashMapper = new ObjectHashMapper()

    Jackson2HashMapper jackson2HashMapper = new Jackson2HashMapper(true)

    Person addPersonHashMapper() {
        String key = "Person:${ThreadLocalRandom.current().nextInt(0, 10000000)}"
        Map<byte[], byte[]> mappedHash = hashMapper.toHash(createRandomPerson())
        hashOperations.putAll(key, mappedHash)
        loadHashedPerson(key)
    }

    Person loadHashedPerson(String key) {
        println "Getting hashed Person with key $key"
        Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
        return (Person) hashMapper.fromHash(loadedHash);
    }

    Person addPersonJackson2HashMapper() {
        Map<String, Object> hash =  jackson2HashMapper.toHash(createRandomPerson())
        jackson2HashMapper.fromHash(hash) as Person
    }

    Person createRandomPerson() {
        Person person = new Person(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(0, 100))
        person.id = ThreadLocalRandom.current().nextInt(0, 100000)
        person
    }
}