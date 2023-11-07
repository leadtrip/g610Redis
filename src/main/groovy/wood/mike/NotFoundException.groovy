package wood.mike

class NotFoundException extends Exception{

    NotFoundException(String id) {
        super("Nothing found for ID $id")
    }
}
