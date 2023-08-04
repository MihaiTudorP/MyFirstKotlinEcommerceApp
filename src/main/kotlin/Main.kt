import java.lang.Exception
import kotlin.system.exitProcess

fun main() {
    val storeProfileRepository = StoreProfileRepository.getInstance()
    val productRepository = ProductRepository.getInstance()
    displayUI(storeProfileRepository, productRepository)

//
//    val shoppingCart = ShoppingCart(customer, productRepository = productRepository)
//    shoppingCart.populateShoppingCart()
//    shoppingCart.checkOut()
}

private fun displayUI(storeProfileRepository: IStoreProfileRepository,
                      productRepository: IProductRepository){
    while(true){
        displayMenu(storeProfileRepository)
        processOption(storeProfileRepository, productRepository, CustomerRepository.getInstance()
        )
    }
}
private fun displayMenu(storeProfileRepository: IStoreProfileRepository) {
    println(
        """
            
            
        Welcome to ${storeProfileRepository.getStoreName()}!
        
        Please select the action you want to perform:
        0. Change the store name
        1. Add new products
        2. Add a customer
        3. Place an order
        4. Exit
    """.trimIndent()
    )
}

private fun processOption(storeProfileRepository: IStoreProfileRepository,
                          productRepository: IProductRepository,
                          customerRepository: CustomerRepository) {
    val option = readln().toInt()
    when (option) {
        0 -> changeStoreName(storeProfileRepository)
        1 -> addProducts(productRepository)
        2 -> addCustomers(customerRepository)
        4 -> exitProcess(0)
        else -> println("Invalid option. Please choose another one from the menu.")
    }
}

private fun addCustomers(customerRepository: CustomerRepository){
    do{
    try {
        customerRepository.addCustomer(Customer.readCustomer()!!)
    } catch (e: Exception){
        println(e.message)
    }}
        while (askForContinueReading())
}

private fun changeStoreName(storeProfileRepository: IStoreProfileRepository) {
    storeProfileRepository.changeStoreName(readLnWithMessage("Please enter the store name:"))
    println("Store name changed successfully")
}

private fun addProducts(productRepository: IProductRepository) {
    do {
        try {
            productRepository.addProduct(Product.readFromKeyboard())
        } catch (ex: Exception) {
            println(ex.message)
        }
    } while (askForContinueReading())
}

private fun askForContinueReading(): Boolean {
    println("Do you want to add another one? ['N' for no]")
    return readln().trim().lowercase() != "n"
}

fun readLnWithMessage(message: String): String {
    println(message)
    return readln()
}

// TODO: Menu
// - change shop name
// - create new product
// - create new customer
// - create new shopping cart
// - modify product
// - modify customer
// - print product list
// - print customer list
// - print customer purchases list

// - should have multiple customers and shopping carts