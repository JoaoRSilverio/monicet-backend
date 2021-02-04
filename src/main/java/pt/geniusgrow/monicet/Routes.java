package pt.geniusgrow.monicet;

public class Routes {


    public static final String HOME ="/";
    public static final String API = "/api";
    public static final String WEB = "/web";
    public static final String MOBILE = "/mobile";
    public static final String VERSION1 = "/v1.0";
    public static final String FRONTENDV1 = API + WEB + VERSION1;

    // FRONT END ROUTES
    public static final String TESTROUTE= FRONTENDV1 + "/testme";
    public static final String WEB_REGISTER =  FRONTENDV1 + "/register";


    // CONTROLLER
    public static final String LOGIN_CONTROLLER = FRONTENDV1 + "/login";
    public static final String PERSON_CONTROLLER = FRONTENDV1 + "/person";
    public static final String COMPANY_CONTROLLER = FRONTENDV1 + "/company";
    public static final String BOAT_CONTROLLER = FRONTENDV1 + "/company/{companyId}/boat";

    // SPECIAL ACTIONS
    public static final String CHANGE_PASSWORD_REQUEST = "/changePassRequest";
    public static final String CHANGE_PASSWORD = "changePass";

    // ACTIONS
    public static final String SEARCH = "/";
    public static final String READ = "/{id}";
    public static final String UPDATE = "/update/{id}";
    public static final String CREATE = "/add";
    public static final String DELETE = "/delete/{id}";

}
