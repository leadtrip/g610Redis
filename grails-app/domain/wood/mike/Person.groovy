package wood.mike

import org.springframework.data.redis.core.RedisHash

@RedisHash("Person")
class Person{
    String name
    Integer age

    Person(String name, Integer age) {      // constructor is required by spring/redis else save fails
        this.name = name
        this.age = age
    }
}