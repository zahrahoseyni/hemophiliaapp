package zahra.hosseini.hemophiliaapp.main.home.data

data class ReportModel(
    val date: String,
    val bleeding: String = "",
    val injection: String = "",
    val bleedingReason: String = "",
)