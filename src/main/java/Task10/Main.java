package Task10;

public class Main {
    public static void main(String[] args) {
        InfoClass infoClass = new InfoClass("Task10.classes.Animal");
        infoClass.showClassInfo();
        infoClass = new InfoClass("Task10.classes.Pigeon");
        infoClass.showClassInfo();
        infoClass = new InfoClass("Task10.classes.Bird");
        infoClass.showClassInfo();
    }
}