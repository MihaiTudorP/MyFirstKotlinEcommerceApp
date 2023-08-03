import jdk.internal.joptsimple.internal.Strings.isNullOrEmpty

data class Customer(val firstName: String, var lastName: String) {
    init {
        if (isNullOrEmpty(firstName) || !Regex("[A-Za-z-]+$").matches(firstName)){
            throw IllegalArgumentException("Invalid first name!")
        }

        if (isNullOrEmpty(lastName) || !Regex("[A-Za-z-]+$").matches(lastName)){
            throw IllegalArgumentException("Invalid first name!")
        }
    }
    fun fullName(): String{
        return "$firstName $lastName"
    }

    companion object{
        fun readCustomer(): Customer? {
            var customer: Customer? = null
            do {
                try {
                    val customerFirstName = readLnWithMessage("Enter customer first name:")
                    val customerLastName = readLnWithMessage("Enter customer last name:")
                    customer = Customer(customerFirstName, customerLastName)
                } catch (e: Exception) {
                    println(e.message)
                }

                var retry = ""

                if (customer === null) {
                    retry = readLnWithMessage("Do you want to retry? [\"N\" for no]")
                }
            } while (customer === null && "N" != retry)
            return customer
        }
    }
}