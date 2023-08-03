fun main() {
    val shopName = readLnWithMessage("Please enter the shop name:")

    val productRepository = ProductRepository.getInstance()
    val customer: Customer? = Customer.readCustomer()

    if (customer === null) return

    val shoppingCart = ShoppingCart(customer, productRepository = productRepository)
    shoppingCart.populateShoppingCart()
    shoppingCart.checkOut()
}

fun readLnWithMessage(message: String): String {
    println(message)
    return readln()
}

