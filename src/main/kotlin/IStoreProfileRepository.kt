interface IStoreProfileRepository {
    fun getStoreName(): String
    fun changeStoreName(newName: String)
}