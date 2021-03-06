package ii_collections

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }

    val squares = list.map { it * it }
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    return customers.map { it -> it.city }.toSet()
    // Return the set of cities the customers are from
    //todoCollectionTask()
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    return customers.filter { it.city == city }.toList()
    // Return a list of the customers who live in the given city
    //todoCollectionTask()
}


