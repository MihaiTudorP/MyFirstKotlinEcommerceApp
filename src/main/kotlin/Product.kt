data class Product(val name: String?, val price: Double?) {

    init {
        if (name == null || price == null)
            throw IllegalArgumentException("Product details cannot be null")
    }


    companion object {
        fun readFromKeyboard(): Product {
            println("Enter product name")
            val productName = readLine()

            println("Enter product price")
            val productPrice = readLine()?.toDouble()

            return Product(productName, productPrice)
        }
    }
}