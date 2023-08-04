class CustomerRepository private constructor(private val customers: MutableSet<Customer> = mutableSetOf()) {
    fun addCustomer(customer: Customer): Customer {
        if (!customers.add(customer)) {
            throw IllegalArgumentException("The customer is already registered")
        }
        return customers.find { item -> item.equals(customer) }!!
    }

    companion object {
        private var instance: CustomerRepository? = null
        fun getInstance(): CustomerRepository {
            if (instance == null) {
                instance = CustomerRepository()
            }
            return instance!!
        }
    }
}