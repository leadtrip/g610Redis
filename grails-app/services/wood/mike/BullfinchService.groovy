package wood.mike

class BullfinchService{

    BullfinchResponseRepository bullfinchResponseRepository

    def addResponse( BullfinchResponse response ) {
        bullfinchResponseRepository.save( response )
    }
}