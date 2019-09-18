package com.stupica;


/**
 * Created on 5/11/17.
 *
 * @author bostjanStupica
 */
public class ConstGlobal {

    /**
     * These values may be used as exit status codes.
     */
    /** SUCCESS = 0 */
    static final public int	PROCESS_EXIT_SUCCESS = 0;
    /** FAILURE = 1 */
    static final public int	PROCESS_EXIT_FAILURE = 1;
    /** FAIL_PARAM = 2 */
    static final public int	PROCESS_EXIT_FAIL_PARAM = 2;

    /**
     * These values may be used as exit status codes.
     */
    /** SUCCESS/OK = 1 */
    static final public int	RETURN_SUCCESS = 1;
    /** SUCCESS/OK = 1 */
    static final public int	RETURN_OK = 1;
    /** WARNING = 0
     * Something is not as expected. */
    static final public int	RETURN_WARNING = 0;
    static final public int	RETURN_WARN = 0;
    static final public int	RETURN_ERROR = -1;
    static final public int	RETURN_NODATA = -2;
    static final public int	RETURN_VALID = RETURN_OK;
    static final public int	RETURN_INVALID = -3;
    static final public int	RETURN_ARCHIVED = 2;
    static final public int	RETURN_NOTARCHIVED = -4;
    static final public int	RETURN_ENDOFDATA = 3;
    static final public int	RETURN_DUPLICATEDATA = 4;
    static final public int	RETURN_MOREDATA = 5;
    static final public int	RETURN_UNKNOWN = 66;
    static final public int	RETURN_UNKNOWNSTATUS = 66;
    static final public int	RETURN_UNKNOWNSTATE = 66;
    static final public int	RETURN_NA = 77;
    static final public int	RETURN_FUNCNOTSUPPORTED = -88;
    static final public int	RETURN_FUNCNOTENABLED = -89;
    static final public int	RETURN_SEC_ERROR = -77;   // Security violation/error

    // Define: empty string
    public static final String DEFINE_STR_NOVALUE = "/";

    /**
     * These values may be used as encodings.
     */
    public final static String ENCODING_UTF8 = "UTF8";
    public final static String ENCODING_UTF_8 = "UTF-8";

    /**
     * These values are used in Network functions/operations.
     */
    public final static int MACADDR_LENGTH = 17;
    public final static String WIN_OSNAME = "Windows";
    public final static String LINUX_OSNAME = "Linux";
    public final static String MACOSX_OSNAME = "Mac OS X";
    public final static String WIN_MACADDR_REG_EXP = "^[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}$";
    public final static String LINUX_MACADDR_REG_EXP = "^[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}$";
    public final static String LINUX_IBM_MACADDR_REG_EXP = "^[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}$";
    public final static String WIN_MACADDR_EXEC = "ipconfig /all";
    public final static String LINUX_MACADDR_EXEC = "ifconfig";

    /**
     * These values are used in Security functions/operations.
     */
    static public String sCertText = "CERTIFICATE";
    static public String sCertStartText = "BEGIN " + sCertText;
    static public String sCertStart = "-----" + sCertStartText + "-----";
    static public String sCertStop = "-----END CERTIFICATE-----";
    static public String sCertPrivateKeyText = "RSA PRIVATE KEY";
    static public String sCertPrivateKeyStart = "-----BEGIN " + sCertPrivateKeyText + "-----";
    static public String sCertPrivateKeyStop = "-----END " + sCertPrivateKeyText + "-----";
    static public String sCertCrlText = "X509 CRL";
    static public String sCertCrlStart = "-----BEGIN " + sCertCrlText + "-----";
    static public String sCertCrlStop = "-----END " + sCertCrlText + "-----";

    static public String sDIGEST_ALG_SHA1 = "SHA1";
    static public String sDIGEST_ALG_SHA2 = "SHA2";
    static public String sDIGEST_ALG_SHA256 = "SHA256";
    static public String sDIGEST_ALG_SHA384 = "SHA384";
    static public String sDIGEST_ALG_SHA512 = "SHA512";
    static public String sDIGEST_ALG_RIPEMD160 = "RIPEMD160";
    static public String sDIGEST_ALG_SHA_1 = "SHA-1";
    static public String sDIGEST_ALG_SHA_2 = "SHA-2";
    static public String sDIGEST_ALG_SHA_256 = "SHA-256";
    static public String sDIGEST_ALG_SHA_384 = "SHA-384";
    static public String sDIGEST_ALG_SHA_512 = "SHA-512";
    static public String sDIGEST_ALG_RIPEMD_160 = "RIPEMD-160";
}
