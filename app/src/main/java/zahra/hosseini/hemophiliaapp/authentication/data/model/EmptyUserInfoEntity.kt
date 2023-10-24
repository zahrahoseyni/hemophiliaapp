package zahra.hosseini.hemophiliaapp.authentication.data.model

class EmptyUserInfoEntity(
    phoneNumber: String = "",
    sex: String = "",
    weight: String = "",
    height: String = "",
    bmi: String = "",
    age: String = "",
    familyHistory: Boolean = false,
    timeOfDiagnosis: String = "",
) : UserInfoEntity(phoneNumber, sex, weight, height,bmi, age, familyHistory, timeOfDiagnosis)
