package wood.mike

class PersonController {

    PersonService personService

    def index() {
        Person person = personService.addPerson()
        render "Hello ${person.name}, you are ${person.age} years old"
    }
}