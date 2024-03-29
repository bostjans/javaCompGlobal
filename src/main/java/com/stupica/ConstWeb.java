package com.stupica;

/* .. deprecated for future releases (above Java_v1.8):
import sun.net.www.protocol.http.HttpURLConnection;
*/


/**
 * Created by bostjans on 01/07/17.
 */
public class ConstWeb {

    /**
     * ..
     */
    static final public int	HTTP_RESP_CONTINUE = 100;

    /**
     * ..
     */
    static final public int	HTTP_RESP_SUCCESS = 200;        // HttpURLConnection.HTTP_OK;
    static final public int	HTTP_RESP_OK = HTTP_RESP_SUCCESS;
    static final public int	HTTP_RESP_NO_CREATED = 201;     // HttpURLConnection.HTTP_CREATED;
    static final public int	HTTP_RESP_NO_CONTENT = 204;     // HttpURLConnection.HTTP_NO_CONTENT;

    static final public int	HTTP_RESP_BAD_REQUEST = 400;
    static final public int	HTTP_RESP_UNAUTHORIZED = 401;
    static final public int	HTTP_RESP_FORBIDDEN = 403;
    static final public int	HTTP_RESP_NOT_FOUND = 404;
    static final public int	HTTP_RESP_MethodNotAllowed = 405;
    static final public int	HTTP_RESP_NotAcceptable = 406;
    static final public int	HTTP_RESP_ProxAuthRequired = 407;
    static final public int	HTTP_RESP_RequestTimeout = 408;
    static final public int	HTTP_RESP_Conflict = 409;
    static final public int	HTTP_RESP_Gone = 410;
    static final public int	HTTP_RESP_LengthRequired = 411;
    static final public int	HTTP_RESP_PreconditionFailed = 412;
    static final public int	HTTP_RESP_PayloadTooLarge = 413;
    static final public int	HTTP_RESP_URI_TooLong = 414;
    static final public int	HTTP_RESP_UnsuppMediaType = 415;
    static final public int	HTTP_RESP_RangeNotSatisfiable = 416;
    static final public int	HTTP_RESP_ExpectationFailed = 417;

    static final public int	HTTP_RESP_INTERNAL_SRV_ERR = 500;
    static final public int	HTTP_RESP_NET_CONNECT_TIMEOUT = 599;

    static final public int	HTTP_RESP_MIN = HTTP_RESP_CONTINUE;
    static final public int	HTTP_RESP_MAX = HTTP_RESP_NET_CONNECT_TIMEOUT;

    public static final String HTTP_METHOD_NAME_GET = "GET";
    public static final String HTTP_METHOD_NAME_POST = "POST";
    public static final String HTTP_METHOD_NAME_PUT = "PUT";
    public static final String HTTP_METHOD_NAME_DELETE = "DELETE";
    public static final String HTTP_METHOD_NAME_PATCH = "PATCH";
    public static final String HTTP_METHOD_NAME_OPTIONS = "OPTIONS";
    public static final String HTTP_METHOD_NAME_TRACE = "TRACE";

    public static final String HTTP_HEADER_NAME_REFERER = "Referer";
    public static final String HTTP_HEADER_NAME_ORIGIN = "Origin";

    // Default Application HTTP Header Key for: username, OE
    public static final String HTTP_HEADER_NAME_OECOMP = "sIdComp";
    public static final String HTTP_HEADER_NAME_USERNAME = "sUsername";


    static public boolean isHttpResponse(int aiVal) {
        if (aiVal < HTTP_RESP_MIN) return false;
        if (aiVal > HTTP_RESP_MAX) return false;
        return true;
    }
}
