package home_made_02;
/* 
Класс Aircraft (самолеты):
Наследует от Vehicle.
Реализует методы абстрактного класса displayInfo.
Реализует методы интерфейса Flyable.
Добавляет свойства: int maxAltitude (максимальная высота полета), boolean isFlying (флаг состояния полета).
Реализует методы:
void startEngine() - запуск двигателя самолета.
void stopEngine() - остановка двигателя самолета.
void takeOff() - взлет самолета.
void land() - посадка самолета. 
*/

public class Aircraft extends Vehicle {

    public Aircraft(int id, String brand, String model, int year) {
        super(id, brand, model, year);
    }

    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startEngine'");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopEngine'");
    }

    @Override
    public void accelerate(int speed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accelerate'");
    }

    @Override
    public void brake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'brake'");
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayInfo'");
    }
    
}
