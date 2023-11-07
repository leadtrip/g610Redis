package wood.mike

class BullfinchController {

    BullfinchService bullfinchService

    def index() {
        BullfinchResponse response = bullfinchService.addResponse()
        render response.toString()
    }

}