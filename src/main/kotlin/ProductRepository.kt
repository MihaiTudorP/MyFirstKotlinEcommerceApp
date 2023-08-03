class ProductRepository private constructor(val products: MutableList<Product> = mutableListOf()) : IProductRepository {
    override fun findProduct(name: String): Product? {
        return products.find { item -> item.name == name }
    }

    override fun updateStock(product: Product, amount: Int) {
        products.find { item -> item == product }!!.stock-=amount
    }

    companion object{
        private var instance: ProductRepository? = null
        private fun populateProductList(): ProductRepository {
            val products = mutableListOf<Product>()
            var continueReadingProducts: String? = "Y"

            while (continueReadingProducts?.uppercase()?.trim() != "N") {
                println("Reading product at index: [${products.size}]")
                val product = Product.readFromKeyboard()
                products.add(product)
                continueReadingProducts = readLnWithMessage("Do you want to register another product? [Enter for yes, \"N\" to stop]")
            }

            return ProductRepository(products)
        }

        fun getInstance(): ProductRepository{
            if (instance == null){
                instance = populateProductList()
            }
            return instance!!
        }
    }
}