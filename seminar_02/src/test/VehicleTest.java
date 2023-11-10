import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class VehicleTest {

    //проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void carInstance() {
        main.Car car = new main.Car("Audi", "A6", 2016);
        assertThat(car).isInstanceOf(main.Vehicle.class);
    }

    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void carNumWheels() {
        main.Car car = new main.Car("Audi", "A6", 2016);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    //проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motorcycleNumWheels() {
        main.Motorcycle motorcycle = new main.Motorcycle("Kawasaki", "DS", 2021);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void carTestDrive() {
        main.Car car = new main.Car("Audi", "A6", 2016);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    //проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void motorcycleTestDrive() {
        main.Motorcycle motorcycle = new main.Motorcycle("Kawasaki", "DS", 2021);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void carTestPark() {
        main.Car car = new main.Car("Audi", "A6", 2016);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void motorcycleTestPark() {
        main.Motorcycle motorcycle = new main.Motorcycle("Kawasaki", "DS", 2021);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}