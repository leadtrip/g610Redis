package wood.mike

import org.springframework.data.repository.CrudRepository

interface PersonRepository extends CrudRepository<Person, String> {}        // Spring based CrudRepository