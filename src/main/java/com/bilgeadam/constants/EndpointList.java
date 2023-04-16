package com.bilgeadam.constants;

public class EndpointList {
    public static final String CUSTOMER = "/customer";
    public static final String ORDER = "/order";
    public static final String PRODUCT = "/product";
    public static final String RESTAURANT = "/restaurant";

    /*
    GENERAL END POINTS
     */
    public static final String SAVE = "/save";
    public static final String DELETE = "/delete";
    public static final String FIND_ALL = "/find-all";
    public static final String FIND_BY_ID = "/find-by-id";
    public static final String FIND_BY_NAME_CONTAINS = "/find-by-name-contains";
    public static final String ACTIVATE_STATUS="/activate-status";
    public static final String UPDATE = "/update";

    /*
    Customer END POINTS
     */
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String FIND_BY_ORDER_BY_NAME = "/find-by-order-by-name";
    public static final String FIND_BY_NAME = "/find-by-name";
    public static final String EXISTS_NAME = "/exits-name";
    public static final String FIND_BY_EMAIL = "/find-by-email";
    public static final String FIND_PASSWORD_GREATER_THAN_JPQL = "/find-password-greater-than-jpql";
    public static final String FIND_PASSWORD_GREATER_THAN_NATIVE = "/find-password-greater-than-native";
    public static final String FIND_EMAIL_ENDS_WITH = "/find-email-ends-with";

    /*
    RESTAURANT END POINTS
     */
    public static final String FIND_RESTAURANT_ORDER_PRODUCT = "/find-restaurant-order-product";


    /*
    COMMENT END POINTS
     */
    public static final String FIND_BY_MOVIE_DATE_BETWEEN = "/find-by-movie-date-between";
    public static final String FIND_BY_USER_ID_AND_DATE = "/find-by-user-id-and-date";
}
