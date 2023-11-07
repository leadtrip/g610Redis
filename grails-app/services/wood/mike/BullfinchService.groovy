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
        response.id = UUID.randomUUID().toString()
        response
    }
}