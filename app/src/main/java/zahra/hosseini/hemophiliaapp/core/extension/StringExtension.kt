package zahra.hosseini.hemophiliaapp.core.extension

fun String.toPersianNumber(): String {
    var result = ""
    var fa = '0'
    for (en in this) {
        fa = en
        when (en) {
            '0' -> fa = '۰'
            '1' -> fa = '۱'
            '2' -> fa = '۲'
            '3' -> fa = '۳'
            '4' -> fa = '۴'
            '5' -> fa = '۵'
            '6' -> fa = '۶'
            '7' -> fa = '۷'
            '8' -> fa = '۸'
            '9' -> fa = '۹'
        }
        result = "${result}$fa"
    }
    return result
}

fun String.formatTime(): String {
    val parts = this.split(":")
    val hour = parts[0].toInt()
    val minute = parts[1].toInt()

    val formattedHour = String.format("%02d", hour)
    val formattedMinute = String.format("%02d", minute)

    return "${formattedHour.toPersianNumber()}:${formattedMinute.toPersianNumber()}"
}


fun String.formatDate(): String {
    val parts = this.split("/")
    val year = parts[0].toInt()
    val month = parts[1].toInt()
    val day = parts[2].toInt()

    val formattedYear = String.format("%02d", year)
    val formattedMonth = String.format("%02d", month)
    val formattedDay = String.format("%02d", day)

    return "${formattedYear.toPersianNumber()}/${formattedMonth.toPersianNumber()}/${formattedDay.toPersianNumber()}"
}