package master.fitpaws;

/**
 * Created by domin on 10/29/2017.
 */

public class UserContext {

    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserContext.userId = userId;
    }
}
