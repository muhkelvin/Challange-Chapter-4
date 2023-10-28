package rizkyfadilah.binar.synrgy6.android.challengechapter4.room

class RoomRepository(private val accountDao: AccountDao) {
    suspend fun checkAccount(email: String, password: String): UserModel {
        return accountDao.checkAccount(email, password)
    }

    suspend fun createAccount(value: UserModel) {
        return accountDao.createAccount(value)
    }
}
