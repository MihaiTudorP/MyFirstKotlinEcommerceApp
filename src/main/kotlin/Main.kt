fun main() {
    println("Please enter the shop name:")
    val shopName = readlnOrNull()

    println("Registering shop products:")
    val products = populateProductList()

    populateProductList()
}

private fun populateProductList(): MutableList<Product> {
    val products = mutableListOf<Product>()
    var continueReadingProducts: String? = "Y"

    while (continueReadingProducts?.uppercase()?.trim() != "N") {
        println("Reading product at index: [${products.size}]")
        val product = Product.readFromKeyboard()
        products.add(product)
        println("Do you want to register another product? [Enter for yes, \"N\" to stop]")
        continueReadingProducts = readlnOrNull()
    }
    return products
}

