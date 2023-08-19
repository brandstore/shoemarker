package house.brandstore.shoemarker.batch.config.property

interface HttpProperties {
    val url: String
        get() {
          return ""
        }

    val connectionTimeoutMs: Int
        get() {
            return 4000
        }
    val socketTimeoutMs: Long
        get() {
            return 1000L
        }
}