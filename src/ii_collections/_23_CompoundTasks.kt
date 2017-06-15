package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    //this.
    return this.customers.filter { it.orderedProducts.contains(product) }.toSet()
    // Return the set of customers who ordered the specified product
    //todoCollectionTask()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return this.orders.filter { order -> order.isDelivered }.flatMap { order -> order.products }.maxBy { product -> product.price }

// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
    //todoCollectionTask()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers.flatMap { it.orders }.flatMap {it.products  }.count { productInOrder -> productInOrder== product }
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
   // todoCollectionTask()
}
