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

public class Aircraft extends Vehicle implements Flyable {

    private int maxAltitude;    // максимальная высота полета
    private boolean isFlying;   // флаг состояния полета
    private int speed;              // скорость
    private boolean sEngine;    // Запущен или нет двигатель
    private int fuelCapacity;       // емкость топливного бака
    private int currentFuelLevel;   // текущий уровень топлива

    /**
     * 
     * @param id уникальный идентификатор
     * @param brand марка
     * @param model модель
     * @param year год выпуска
     * @param maxAltitude максимальная высота полета
     * @param fuelCapacity емкость топливного бака
     */
    public Aircraft(int id, String brand, String model, int year, int maxAltitude, int fuelCapacity) {
        super(id, brand, model, year);
        this.maxAltitude = maxAltitude;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void startEngine() {
        if (Aircraft.this.getCurrentFuelLevel() == 0){
            System.out.println("Необходимо заправить топливо!");
        }
        else{this.sEngine = true;}
    }

    @Override
    public void stopEngine() {
        if (speed == 0 && !isFlying){sEngine = false;}
            else{System.out.println("Необходимо приземлиться и остановиться!");}
    }

    @Override
    public void accelerate(int speed) {
        if (sEngine){
            this.speed += speed;
        }
        else {System.out.println("Необходимо запустить двигатель!");}
    }

    @Override
    public void brake() {
        if (!isFlying){
            speed = 0;
        }
        else{
            System.out.println("Необходимо приземлиться");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Информация о самолёте:");
        System.out.println("Номер " + Aircraft.this.getId()+ "; Производитель " + Aircraft.this.getBrand() + "; Марка " + Aircraft.this.getModel() + "; Год выпуска " + Aircraft.this.getYear());
        System.out.println("Информация о полете:");
        System.out.print("Двигатель ");
        if (sEngine){
            System.out.print("запущен и самолет находтся ");
            /*В воздухе или на земле */
            if (isFlying){
                System.out.println("в воздухе");
            }
            else {System.out.println("на земле");}
            System.out.println("Скорость " + speed + "; Топлива в баке " + currentFuelLevel + "; Ёмкость бака " + fuelCapacity);
        }
        else{
            System.out.println("Остановлен");
            System.out.println("Топлива в баке " + currentFuelLevel + "; Ёмкость бака " + fuelCapacity);
        }
        System.out.println();
    }
    
    @Override
    public void takeOff(){
        if (speed != 0){
            isFlying = true;
        }
        else{
            System.out.println("Скорость равна нулю");
        }
    }

    @Override
    public void land(){
        isFlying = false;
    }

    void refuel(int liters){
        if (fuelCapacity >= currentFuelLevel){
            Aircraft.this.setCurrentFuelLevel(liters);
        }
    }
    
    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public int getCurrentFuelLevel() {
        return currentFuelLevel;
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

}
