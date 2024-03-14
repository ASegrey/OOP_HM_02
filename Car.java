package home_made_02;
/* 
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
*/


public class Car extends Vehicle  {
    private int fuelCapacity;       // емкость топливного бака
    private int currentFuelLevel;   // текущий уровень топлива
    private int speed;              // скорость
    private boolean sEngine;    // Запущен или нет двигатель

    /**
     * 
     * @param id уникальный идентификатор
     * @param brand марка
     * @param model модель
     * @param year год выпуска
     * @param fuelCapacity емкость топливного бака
     */
    public Car (int id, String brand, String model, int year,int fuelCapacity) {
        super(id, brand, model, year);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void startEngine() {
        if (Car.this.getCurrentFuelLevel() == 0){
            System.out.println("Необходимо заправить бензин!");
        }
        else{this.sEngine = true;}
     }

    @Override
    public void stopEngine() {
        if (this.speed == 0){this.sEngine = false;}
            else{System.out.println("Необходимо остановиться!");}
    }

    @Override
    public void accelerate(int speed) {
        if (Car.this.issEngine()){
            this.speed += speed;
        }
        else {System.out.println("Необходимо запустить двигатель!");}
    }

    @Override
    public void brake() {
        this.speed = 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Информация о машине:");
        System.out.println("Номер " + Car.this.getId() + " Марка " + Car.this.getModel() + " Год выпуска" + Car.this.getYear());
        System.out.println("Информация о движении:");
        System.out.print("Двигатель ");
        if (Car.this.issEngine()){
            System.out.println("запущен");
            System.out.println("Скорость " + Car.this.getSpeed() + " Топлива в баке " + Car.this.getCurrentFuelLevel() + " Ёмкость бака" + Car.this.getFuelCapacity());
        }
        else{
            System.out.println("Остановлен");
            System.out.println("Топлива в баке " + Car.this.getCurrentFuelLevel() + " Ёмкость бака" + Car.this.getFuelCapacity());
        }
    }

    void refuel(int liters){
        if (Car.this.getFuelCapacity() < Car.this.getCurrentFuelLevel()){
            Car.this.setCurrentFuelLevel(liters);
        }
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(int currentFuelLevel) {
        if (this.fuelCapacity >= (this.currentFuelLevel + currentFuelLevel)){
            this.currentFuelLevel += currentFuelLevel;
            System.out.println("Заправлено " + currentFuelLevel + "л");
        }
        else {
            System.out.println("Полный бак");
            System.out.println("Заправлено " + (this.fuelCapacity - this.currentFuelLevel) + "л");
            this.currentFuelLevel = this.fuelCapacity;
        }
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        if (  this.currentFuelLevel >= this.fuelCapacity){
            this.currentFuelLevel = this.fuelCapacity;
        }
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean issEngine() {
        return sEngine;
    }
    
    public void setsEngine(boolean sEngine) {
        this.sEngine = sEngine;
    }
}
