package wood.mike

class BullfinchController {

    BullfinchService bullfinchService

    def index() {
        [responses: bullfinchService.list()]
    }

    def show() {
        render bullfinchService.getResponse(params).orElseThrow(() -> new NotFoundException(params.id))
    }

    def add() {
        BullfinchResponse response = bullfinchService.addResponse()
        render "Added bullfinch response with ID ${response.id}"
    }

    def handleNotFoundException(NotFoundException ex ) {
        render ex.message
    }
}