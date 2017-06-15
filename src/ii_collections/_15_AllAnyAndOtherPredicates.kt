package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City): Boolean {
    return this.city == city
    // Return true if the customer is from the given city
    //todoCollectionTask()
}

fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
    return this.customers.all { customer -> customer.city == city }
    // Return true if all customers are from the given city
    //todoCollectionTask()
}

fun Shop.hasCustomerFrom(city: City): Boolean {
    return this.customers.any { it.isFrom(city) }
    // Return true if there is at least one customer from the given city
    //todoCollectionTask()
}

fun Shop.countCustomersFrom(city: City): Int {
    val isFromCity: (Customer) -> Boolean = { customer -> customer.isFrom(city) }
    return this.customers.count(isFromCity)
    // Return the number of customers from the given city
    //todoCollectionTask()
}

fun Shop.findAnyCustomerFrom(city: City): Customer? {
    return this.customers.find { customer -> customer.isFrom(city) }
    // Return a customer who lives in the given city, or null if there is none
    //todoCollectionTask()
}
