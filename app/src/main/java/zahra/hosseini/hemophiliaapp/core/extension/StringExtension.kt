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