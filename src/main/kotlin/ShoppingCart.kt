data class ShoppingCart(
    val customer: Customer,
    private val itemList: MutableList<ShoppingCartItem> = mutableListOf(),
    private val productRepository: IProductRepository
) {
    private var total = 0.0
    fun checkOut() {
        println("\n\n\nInvoice for ${customer.fullName()}:")
        for (item in itemList) {
            println(
                """
                Price per unit: ${item.product.price}
                Amount: ${item.amount}
                Total for this item: ${item.getTotal()}
            """.trimIndent()
            )
            productRepository.updateStock(item.product, item.amount)
        }

        println("\n\nGrand total: $total\n")
    }

    fun populateShoppingCart() {
        var continueShopping = ""
        do {
            println("Enter item name:")
            val itemName = readln()
            val product = productRepository.findProduct(itemName)
            if (product == null){
                println("Item not found! Do you want to enter another one? [\"N\" for no]")
                continueShopping = readln()
                if (continueShopping == "N")
                    break
                continue
            } else if (product.stock == 0) {
                println("The product is not in stock! Continue shopping? [\"N\" for no]")
                continueShopping = readln()
                if (continueShopping == "N")
                    break
                continue
            }
            println("Enter item amount:")
            var itemAmount = readln().toInt()
            val item = itemList.find { item -> item.product.name.equals(itemName) }
            val totalAmount = (item?.amount ?: 0) + itemAmount
            if (product.stock - totalAmount < 0){
                println("We only have ${product.stock} of product ${product.name}! Do you want that? [\"N\" for no]")
                val enough = readln()
                if (enough == "N")
                    continue
                if (item != null) {
                    itemAmount = product.stock - item.amount
                }
            }

            if (item != null) {
                item.amount += itemAmount
            } else {
                itemList.add(ShoppingCartItem(product, itemAmount))
            }

            total += itemAmount * product.price

            println("Would you like to continue shopping? [enter \"N\" for no or any key to continue]")
            continueShopping = readln().trim()
        } while (continueShopping != "N")
    }
}

data class ShoppingCartItem(val product: Product, var amount: Int) {
    fun getTotal(): Double = product.price.times(amount)
}