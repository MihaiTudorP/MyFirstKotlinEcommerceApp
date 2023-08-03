interface IProductRepository {
    fun findProduct(name: String): Product?
    fun updateStock(product: Product, amount: Int)
}