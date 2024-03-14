/* 

Задание: Разработка системы управления транспортными средствами

Создайте систему управления транспортными средствами с использованием принципов 
объектно-ориентированного программирования. В системе должны присутствовать 
следующие классы и интерфейсы:

Абстрактный класс Vehicle:

Содержит общие свойства и методы для всех видов транспортных средств.
Свойства: int id (уникальный идентификатор), String brand (марка), String model (модель), int year (год выпуска).
Методы:
void startEngine() - запуск двигателя (реализация в подклассах).
void stopEngine() - остановка двигателя (реализация в подклассах).
void accelerate(int speed) - увеличение скорости на указанное значение (реализация в подклассах).
void brake() - прекращение движения (реализация в подклассах).
abstract void displayInfo() - вывод информации о транспортном средстве (реализация в подклассах).

Интерфейс Flyable (летающие транспортные средства):
Методы: void takeOff(), void land().

Интерфейс Swimmable (плавающие транспортные средства):
Методы: void startSwimming(), void stopSwimming().


Класс Car (автомобили):
Наследует от Vehicle.
Реализует методы абстрактного класса displayInfo.
Добавляет свойства: int fuelCapacity (емкость топливного бака), int currentFuelLevel (текущий уровень топлива).
Реализует методы:
void startEngine() - запуск двигателя автомобиля.
void stopEngine() - остановка двигателя автомобиля.
void accelerate(int speed) - увеличение скорости автомобиля на указанное значение.
void brake() - прекращение движения автомобиля.
void refuel(int liters) - заправка автомобиля (увеличение уровня топлива).

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

Класс Boat (лодки):
Наследует от Vehicle.
Реализует методы абстрактного класса displayInfo.
Реализует методы интерфейса Swimmable.
Добавляет свойства: int maxSpeed (максимальная скорость на воде), boolean isSailing (флаг состояния движения по воде).
Реализует методы:
void startEngine() - запуск двигателя лодки.
void stopEngine() - остановка двигателя лодки.
void startSwimming() - начало движения лодки по воде.
void stopSwimming() - прекращение движения лодки по воде.

Главный класс Main для проверки:
Создайте объекты различных транспортных средств (автомобиль, самолет, лодка).
Продемонстрируйте их работу, вызывая соответствующие методы (запуск двигателя, движение, взлет, посадка и т.д.).
Выведите информацию о каждом транспортном средстве с использованием метода displayInfo. */

package home_made_02;

public class Main {
    public static void main(String[] args) {
        Car mustang = new Car(777, "Ford", "Mustang", 2001, 100);
        Aircraft su27 = new Aircraft(111, "Сухой", "СУ-27", 2000, 18000, 11975);
        Boat hunter = new Boat(999, "Хантер", "Хатер 360", 2024, 5, 20);
        mustang.displayInfo();
        su27.displayInfo();
        hunter.displayInfo();
        mustang.setCurrentFuelLevel(110);
        mustang.startEngine();
        mustang.accelerate(100);
        mustang.displayInfo();

        mustang.brake();
        mustang.stopEngine();
        mustang.displayInfo();

        su27.setCurrentFuelLevel(10000);
        su27.startEngine();
        su27.accelerate(500);
        su27.takeOff();
        su27.accelerate(1000);
        su27.displayInfo(); 

        su27.accelerate(700);
        su27.land();
        su27.brake();
        su27.stopEngine();
        su27.displayInfo();
        
        hunter.startEngine();
        hunter.setCurrentFuelLevel(10);
        hunter.startEngine();
        hunter.startSwimming();
        hunter.accelerate(100);
        hunter.displayInfo();

        hunter.brake();
        hunter.stopSwimming();
        hunter.stopEngine();
        hunter.displayInfo();

    }
}
