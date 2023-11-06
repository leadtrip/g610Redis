package wood.mike

import org.springframework.data.redis.core.RedisHash

@RedisHash("Person")
class Person{
    private String name
    private Integer age

    Person(String name, Integer age) {
        this.name = name
        this.age = age
    }

    String getName() {
        return name
    }

    Integer getAge() {
        return age
    }
}