package package01;

public class Player {
    public int happiness, health, grade, week;
    public double money;

    //Constructor
    Player(int happiness, int health, int grade, int week, double money) {
        this.happiness = happiness;
        this.health = health;
        this.grade = grade;
        this.money = money;
        this.week = week;
    }

    //Getters
    public int getHappiness(){
        return happiness;
    }
    public int getHealth(){
        return health;
    }
    public int getGrade(){
        return grade;
    }
    public double getMoney(){
        return money;
    }
    public int getWeek(){
        return week;
    }
    //Setters
    public void setHappiness(int happiness){
        this.happiness = happiness;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public void setMoney(double money){
        this.money = money;
    }
    public void setWeek(int week){
        this.week = week;
    }
}
