package zahra.hosseini.hemophiliaapp.core.datastore

data class UserInfo(
    val age: String,
    val weight: String,
    val height: String,
    val family_history: Boolean,
    val timeOfDiagnosis: String,
    val sex: String,
)