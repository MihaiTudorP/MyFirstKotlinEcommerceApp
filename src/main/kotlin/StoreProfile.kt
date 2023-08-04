data class StoreProfile(var storeName: String) {
    init {
        val storeNameRegex = Regex("^[A-Za-z\\- ]+$")
        if (storeName.isEmpty() || !storeNameRegex.matches(storeName)){
            throw IllegalArgumentException("Invalid store name!")
        }
    }
}