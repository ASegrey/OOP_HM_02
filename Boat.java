package home_made_02;
/* 
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

*/

public class Boat extends Vehicle implements Swimmable {
    private int maxSpeed;           // максимальная скорость на воде
    private boolean isSailing;      // флаг состояния движения по воде
    private int speed;              // скорость
    private boolean sEngine;        // Запущен или нет двигатель
    private int fuelCapacity;       // емкость топливного бака
    private int currentFuelLevel;   // текущий уровень топлива    
    
    /**
     * 
     * @param id уникальный идентификатор
     * @param brand марка
     * @param model модель
     * @param year год выпуска
     * @param maxSpeed максимальная скорость на воде
     * @param fuelCapacity емкость топливного бака
     */
    public Boat(int id, String brand, String model, int year, int maxSpeed, int fuelCapacity) {
        super(id, brand, model, year);
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void startSwimming() {
        if (speed == 0 && sEngine){
            isSailing = true;
        }
        else{
            System.out.println("Скорость не ноль или зажигание выключено");
        }
    }

    @Override
    public void stopSwimming() {
        if (speed == 0){
            isSailing = false;
        }
        else{
            System.out.println("Скорость не ноль, остановите лодку");
        }
    }

    @Override
    public void startEngine() {
        if (currentFuelLevel != 0){
            sEngine = true;
        }
        else{
            System.out.println("Необходимо заправить топливо!");
        }
    }

    @Override
    public void stopEngine() {
        if (speed == 0){sEngine = false;}
            else{System.out.println("Необходимо остановиться!");}
    }

    @Override
    public void accelerate(int speed) {
        if (sEngine && isSailing){
            if (maxSpeed >= (this.speed + speed)){
                this.speed += speed;
            }
            else{
                this.speed = maxSpeed;
                System.out.println("Максимальная скорость " + maxSpeed);
            }
        }
        else {System.out.println("Необходимо запустить двигатель или выбрать движение по воде!");}
    }

    void refuel(int liters){
        if (fuelCapacity >= currentFuelLevel){
            Boat.this.setCurrentFuelLevel(liters);
        }
    }

    public void setCurrentFuelLevel(int currentFuelLevel) {
        if (fuelCapacity >= (this.currentFuelLevel + currentFuelLevel)){
            this.currentFuelLevel += currentFuelLevel;
            System.out.println("Заправлено " + currentFuelLevel);
        }
        else {
            System.out.println("Полный бак");
            System.out.println("Заправлено " + (fuelCapacity - this.currentFuelLevel));
            this.currentFuelLevel = fuelCapacity;
        }
    }

    @Override
    public void brake() {
        speed = 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Информация о лодке:");
        System.out.println("Номер " + Boat.this.getId() + "; Производитель " + Boat.this.getBrand() + "; Марка " + Boat.this.getModel() + "; Год выпуска " + Boat.this.getYear());
        System.out.println("Информация о движении:");
        System.out.print("Двигатель ");
        if (sEngine){
            System.out.print("запущен и лодка движется ");
            /*В воздухе или на земле */
            if (isSailing){
                System.out.println("по воде");
            }
            else {System.out.println("по земле?");}
            System.out.println("Скорость " + speed + "; Топлива в баке " + currentFuelLevel + "; Ёмкость бака " + fuelCapacity);
        }
        else{
            System.out.println("Остановлен");
            System.out.println("Топлива в баке " + currentFuelLevel + "; Ёмкость бака " + fuelCapacity);
        }
        System.out.println();
    }
    
}
