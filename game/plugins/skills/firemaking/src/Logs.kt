enum class Logs(val id: Int, val level: Int, val experience: Double) {

    LOG(1511, 1, 40.0),
    ACHEY(2862, 1, 40.0),
    OAK(1521, 15, 60.0),
    WILLOW(1519, 30, 90.0),
    TEAK(6333, 35, 105.0),
    ARCTIC_PINE(10810, 42, 125.0),
    MAPLE(1517, 45, 135.0),
    MAHOGANY(6332, 50, 157.5),
    EUCALYPTUS(12581, 58, 193.5),
    YEW(1515, 60, 202.5),
    MAGIC(1513, 75, 303.8),
    RED(7406, 1, 250.0),
    BLUE(7405, 1, 250.0),
    RED2(7404, 1, 250.0);

    companion object {
        //We vararg here so we can check used and target at the same time
        fun getFromIDs(vararg ids: Int) : Logs? {
            for (log in Logs.values()) {
                if (ids.contains(log.id))
                    return log
            }
            return null
        }
    }
}