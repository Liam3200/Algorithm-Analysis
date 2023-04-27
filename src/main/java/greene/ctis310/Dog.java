package greene.ctis310;

public class Dog {
    // attributes
    private String name;
    private int age;
    private String breed;
    private String color;
    private int barked = 0;

    // constructors
    // public Dog() {
    // name = "Fido";
    // age = 0;
    // breed = "mutt";
    // color = "brown";
    // }

    public Dog(String name, int age, String breed, String color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    // constructor that creates random values for each attribute
    public Dog() {
        // create a random name
        int nameNum = (int) (Math.random() * 10);
        switch (nameNum) {
            case 0:
                name = "Casper";
                break;
            case 1:
                name = "Rover";
                break;
            case 2:
                name = "Spot";
                break;
            case 3:
                name = "Buddy";
                break;
            case 4:
                name = "Max";
                break;
            case 5:
                name = "Duke";
                break;
            case 6:
                name = "Jack";
                break;
            case 7:
                name = "Rocky";
                break;
            case 8:
                name = "Bear";
                break;
            case 9:
                name = "Tucker";
                break;
            default:
                name = "Fido";
                break;
        }
        // create a random age
        age = (int) (Math.random() * 20);
        int breedNum = (int) (Math.random() * 5);
        switch (breedNum) {
            case 0:
                breed = "westie";
                break;
            case 1:
                breed = "lab";
                break;
            case 2:
                breed = "poodle";
                break;
            case 3:
                breed = "pug";
                break;
            case 4:
                breed = "bulldog";
                break;
            default:
                breed = "mutt";
                break;
        }
        // create a random color
        int colorNum = (int) (Math.random() * 5);
        switch (colorNum) {
            case 0:
                color = "white and black spots";
                break;
            case 1:
                color = "black";
                break;
            case 2:
                color = "white";
                break;
            case 3:
                color = "gray";
                break;
            case 4:
                color = "golden";
                break;
            default:
                color = "brown";
                break;
        }
        barked = (int) (Math.random() * 1001);
    }

    // override the compareTo method
    public int compareTo(Dog otherDog) {
        // compare the names of the dogs if one name is higher in the alphabet than the
        // other return 1
        if (name.compareTo(otherDog.getName()) > 0) {
            return 1;
        }
        // compare the names of the dogs if one name is lower in the alphabet than the
        // other return -1
        else if (name.compareTo(otherDog.getName()) < 0) {
            return -1;
        }
        // if the names are equal return 0
        return 0;

    }

    // create a method that makes the dog bark
    public void bark() {
        System.out.println("Woof!");
        barked++;
    }

    // getters and setters
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBarked() {
        return barked;
    }

    public void setBarked(int barked) {
        this.barked = barked;
    }

    // toString
    @Override
    public String toString() {
        return "Dog name: [" + name + "] age: " + age + ", breed: " + breed +
                ", color: " + color + ", barked: " + barked;
    }
}
