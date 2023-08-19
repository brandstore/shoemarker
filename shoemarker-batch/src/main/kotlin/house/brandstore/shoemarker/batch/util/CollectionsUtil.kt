package house.brandstore.shoemarker.batch.util

class CollectionsUtil {
    companion object {
        fun contains(origin: List<String>, diff: List<String>): Boolean {
            return diff.find { origin.contains(it) } != null
        }
    }
}