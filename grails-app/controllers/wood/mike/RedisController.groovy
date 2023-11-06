package wood.mike

import java.util.concurrent.ThreadLocalRandom

class RedisController {

    RedisService redisService

    def index() {
        String userId = UUID.randomUUID().toString()
        Integer randomId = ThreadLocalRandom.current().nextInt(0, 100)
        redisService.addLink(userId, randomId)
        render "Added $randomId for user $userId"
    }
}