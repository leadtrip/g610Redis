package wood.mike

import java.util.concurrent.ThreadLocalRandom

class PersonService {

    PersonRepository personRepository

    Person addPerson() {
        Person person = new Person( UUID.randomUUID().toString(),  ThreadLocalRandom.current().nextInt(0, 100))
        personRepository.save(person)
    }

    def list() {
        personRepository.findAll()
    }

    def show(params) {
        personRepository.findById(params.id)
    }
}