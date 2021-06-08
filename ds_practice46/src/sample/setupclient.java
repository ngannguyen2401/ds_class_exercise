package sample;

public class setupclient {
    private int ID;
    private String name;
    private int age;

    public setupclient() {
    }

    public setupclient(int iD, String name, int age) {
        ID = iD;
        this.name = name;
        this.age = age;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return getID() + " - " + getName() + " - " + getAge();
    }
}
