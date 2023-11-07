package wood.mike

import groovy.json.JsonParserType
import groovy.json.JsonSlurper

class BullfinchService{

    BullfinchResponseRepository bullfinchResponseRepository

    BullfinchResponse addResponse() {
        bullfinchResponseRepository.save( buildResponse() )
    }

    BullfinchResponse buildResponse() {
        def bfJson = new JsonSlurper(type: JsonParserType.CHARACTER_SOURCE).parse(getClass().getClassLoader().getResourceAsStream('bullfinchresponse.json'))
        BullfinchResponse response = new BullfinchResponse(bfJson['styles'], bfJson['body'])
        response.id = buildKey()
        response
    }

    String buildKey() {
        Random random = new Random()
        boolean isLoggedIn = random.nextBoolean()
        String saleId = 'A' + UUID.randomUUID().toString().substring(0, 5)
        boolean showPrices = random.nextBoolean()
        boolean isMobile = random.nextBoolean()
        String featureFlags = 'blah'
        String themeJSONUri = 'abcdefg'
        "$isLoggedIn-$saleId-$showPrices-$isMobile-$featureFlags-$themeJSONUri"
    }

    Optional<BullfinchResponse> getResponse(params) {
        bullfinchResponseRepository.findById(params.id)
    }

    def list() {
        bullfinchResponseRepository.findAll()
    }
}