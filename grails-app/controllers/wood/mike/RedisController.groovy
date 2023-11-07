package wood.mike

class RedisController {

    RedisService redisService

    def addPersonHashMapper() {
        Person person = redisService.addPersonHashMapper()
        render "Added ${person.toString()}"
    }

    def addPersonJackson2HashMapper() {
        Person person = redisService.addPersonJackson2HashMapper()
        render "Added ${person.toString()}"
    }
}