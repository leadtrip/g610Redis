package wood.mike

class PersonController {

    PersonService personService

    def index() {
        [people: personService.list()]
    }

    def show() {
        render personService.show(params).orElseThrow(() -> new NotFoundException(params.id))
    }

    def add() {
        Person person = personService.addPerson()
        render "Added ${person.toString()}"
    }

    def handleNotFoundException(NotFoundException ex) {
        render ex.message
    }
}