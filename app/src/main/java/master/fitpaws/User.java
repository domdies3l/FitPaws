package master.fitpaws;

/**
 * Created by domin on 10/21/2017.
 */

public class User {

    private static String id;
    private static String name;
    private static String email;
    private static String password;
    private static String age;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        User.age = age;
    }

    public static String getWeight() {
        return weight;
    }

    public static void setWeight(String weight) {
        User.weight = weight;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        User.sex = sex;
    }

    public static String getBreed() {
        return breed;
    }

    public static void setBreed(String breed) {
        User.breed = breed;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        User.color = color;
    }

    private static String weight;
    private static String sex;
    private static String breed;
    private static String color;


}
