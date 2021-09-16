package parking

class ParkingLot(private val size: Int) {
    private val spots = arrayOfNulls<Car>(size)

    fun isNotCreated() = spots.isEmpty()

    fun isEmpty() = spots.filterNotNull().isEmpty()

    fun findCar(spotNumber: Int): Car? {
        if (spotNumber > size) {
            println("Spot number must not exceed the size of the parking lot: $size")
            return null
        }
        return spots[spotNumber - 1]
    }

    fun parkCar(spotNumber: Int, car: Car) = spots.set(spotNumber - 1, car)

    fun leaveCarSpot(spotNumber: Int) = spots.set(spotNumber - 1, null)

    fun findFreeSpot() = spots.indexOfFirst { it == null } + 1

    fun findCarsByColor(color: String) = spots.filterNotNull()
        .filter { it.color.lowercase() == color.lowercase() }

    fun findSpotsByColor(color: String) = spots.withIndex()
        .filter { it.value?.color?.lowercase() == color.lowercase() }
        .map { it.index + 1 }

    fun findSpotsByRegNumber(regNumber: String) = spots.withIndex()
        .filter { it.value?.regNumber == regNumber }
        .map { it.index + 1 }

    override fun toString() = spots.withIndex()
        .filter { it.value != null }
        .joinToString(
            separator = "\n",
            transform = { "${it.index + 1} ${it.value}" }
        )
}
