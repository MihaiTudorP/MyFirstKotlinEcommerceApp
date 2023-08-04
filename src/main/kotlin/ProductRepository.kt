class ProductRepository private constructor(private val products: MutableList<Product> = mutableListOf()) : IProductRepository {
    override fun findProduct(name: String): Product? = products.find { item -> item.name == name }

    override fun updateStock(product: Product, amount: Int) {
        products.find { item -> item == product }!!.stock-=amount
    }

    override fun addProduct(product: Product): Product {
        val itemInList = findProduct(product.name)
        if (itemInList != null) throw IllegalArgumentException("Product already registered!")
            products.add(product)
        return findProduct(product.name)!!
    }

    companion object{
        private var instance: ProductRepository? = null

        fun getInstance(): ProductRepository{
            if (instance == null){
                instance = ProductRepository()
            }
            return instance!!
        }
    }
}