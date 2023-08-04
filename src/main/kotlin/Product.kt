data class Product(val name: String, val price: Double = 0.0, var stock: Int = 0) {
    init {
        if (name.isEmpty() || price <= 0)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}