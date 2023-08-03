import jdk.internal.joptsimple.internal.Strings.isNullOrEmpty

data class Product(val name: String, val price: Double = 0.0, var stock: Int = 0) {
    init {
        if (isNullOrEmpty(name) || price <= 0)
            throw IllegalArgumentException("Product details cannot be empty")
    }


    companion object {
        fun readFromKeyboard(): Product {
            println("Enter product name")
            val productName = readln()

            println("Enter product price")
            val productPrice = readln().toDouble()

            println("How much do you have in stock?")
            val stock = readln().toInt()

            return Product(productName, productPrice, stock)
        }
    }
}