class StoreProfileRepository private constructor() : IStoreProfileRepository {
    private val storeProfile = StoreProfile("YourStoreNameHere")

    override fun getStoreName(): String{
        return storeProfile.storeName
    }

    override fun changeStoreName(newName: String){
        storeProfile.storeName = newName
    }

    companion object{
        private var instance: StoreProfileRepository? = null
        fun getInstance(): StoreProfileRepository{
            if (instance == null){
                instance = StoreProfileRepository()
            }
            return instance!!
        }
    }
}