package parking

class Menu {
    var parkingLot = ParkingLot(0)

    fun create(size: Int) {
        parkingLot = ParkingLot(size)
        println("Created a parking lot with $size spots.")
    }

    fun status() {
        if (doesNotParkingLotCreated()) return

        if (parkingLot.isEmpty()) {
            println("Parking lot is empty.")
        } else {
            println(parkingLot)
        }
    }

    fun park(car: Car) {
        if (doesNotParkingLotCreated()) return

        val spotNumber = parkingLot.findFreeSpot()
        if (spotNumber == 0) {
            println("Sorry, the parking lot is full.")
            return
        }

        parkingLot.parkCar(spotNumber, car)
        println("${car.color} car parked in spot ${spotNumber}.")
    }

    fun leave(spotNumber: Int) {
        if (doesNotParkingLotCreated()) return

        val car = parkingLot.findCar(spotNumber)
        if (car != null) {
            parkingLot.leaveCarSpot(spotNumber)
            println("Spot $spotNumber is free.")
        } else {
            println("There is no car in spot $spotNumber.")
        }
    }

    fun regByColor(color: String) {
        if (doesNotParkingLotCreated()) return

        val cars = parkingLot.findCarsByColor(color)
        if (cars.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(cars.joinToString { it.regNumber })
        }
    }

    fun spotByColor(color: String) {
        if (doesNotParkingLotCreated()) return

        val spots = parkingLot.findSpotsByColor(color)
        if (spots.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(spots.joinToString())
        }
    }

    fun spotByReg(regNumber: String) {
        if (doesNotParkingLotCreated()) return

        val spots = parkingLot.findSpotsByRegNumber(regNumber)
        if (spots.isEmpty()) {
            println("No cars with registration number $regNumber were found.")
        } else {
            println(spots.first())
        }
    }

    private fun doesNotParkingLotCreated(): Boolean {
        if (parkingLot.isNotCreated()) {
            println("Sorry, a parking lot has not been created.")
            return true
        }
        return false
    }
}
