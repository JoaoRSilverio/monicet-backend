package pt.geniusgrow.monicet;

public class Routes {
    public static final String HOME ="/";
    public static final String API = "/api";
    public static final String WEB = "/web";
    public static final String MOBILE = "/mobile";
    public static final String VERSION1 = "/v1.0";
    public static final String FRONTENDV1 = API + WEB + VERSION1;

    // FRONT END ROUTES
    public static final String REGISTER =  FRONTENDV1 + "/register";
    public static final String LOGIN = FRONTENDV1 + "/login";

}
