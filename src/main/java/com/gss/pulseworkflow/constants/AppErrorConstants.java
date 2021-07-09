package com.gss.pulseworkflow.constants;
/**
 * ApiErrorConstants.java
 * 
 * @author Arjun
 * 
 */
public class AppErrorConstants {

	// invalid/missing params

		/**
		 * Reference to ERROR_CODE_MISSING_PARAMETER
		 */
		public static final String ERROR_CODE_MISSING_PARAMETER = "FS1001";

		/**
		 * Reference to ERROR_CODE_UNKNOWN_EXCEPTION
		 */
		public static final String ERROR_CODE_UNKNOWN_EXCEPTION = "FS1002";
		
		/**
		 * Reference to ERROR_MESSAGE_UNKNOWN_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_UNKNOWN_EXCEPTION = "Unknown Exception";

		/**
		 * Reference to ERROR_SQLEXCEPTION
		 */
		public static final String ERROR_SQLEXCEPTION = "Server Error";
		/**
		 * Reference to ERROR_MESSAGE_TYPE_SQL_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_TYPE_SQL_EXCEPTION = "Database Exception";
		/**
		 * Reference to ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION = "Validation Exception";
		/**
		 * Reference to ERROR_MESSAGE_TYPE_APPLICATION_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_TYPE_APPLICATION_EXCEPTION = "Application Exception";
		/**
		 * Reference to ERROR_MESSAGE_TYPE_UNKNOWN_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_TYPE_UNKNOWN_EXCEPTION = "Unknown Cloud Exception";
		/**
		 * Reference to ERROR_MESSAGE_NO_PERMISSION
		 */
		public static final String ERROR_MESSAGE_NO_PERMISSION = "No Method Permission Exception";
		/**
		 * Reference to ERROR_MESSAGE_UNEXPECTED_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_UNEXPECTED_EXCEPTION = "Unexpected Exception";
		/**
		 * Reference to ERROR_MESSAGE_DUPLICATE_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_DUPLICATE_EXCEPTION = "Data Already Exist Exception";
		/**
		 * Reference to ERROR_MESSAGE_AUTHENTICATION_EXCEPTION
		 */
		public static final String ERROR_MESSAGE_AUTHENTICATION_EXCEPTION = "Authentication Exception";

		// New Error Codes--------------------------------

		/**
		 * Reference to ERROR_TYPE_AUTHENTICATION_EXCEPTION
		 */
		public static final String ERROR_TYPE_AUTHENTICATION_EXCEPTION = "Authentication Exception";
		
		/**
		 * Reference to ERROR_TYPE_AUTHORIZATION_EXCEPTION
		 */
		public static final String ERROR_TYPE_AUTHORIZATION_EXCEPTION = "Authorization Exception";

		/**
		 * Reference to ERROR_TYPE_AUTHENTICATION_EXCEPTION
		 */
		public static final String ERROR_TYPE_BUSSINESS_EXCEPTION = "Bussiness Exception";
	 
		/** ERROR MESSAGES **/

		/**
		 * Reference to ERROR_MESSAGE_TOKEN_EMPTY
		 */
		public static final String ERROR_MESSAGE_BAD_CREDENTIALS = "Provide valid username and password";
		
		/**
		 * Reference to ERROR_MESSAGE_TOKEN_EMPTY
		 */
		public static final String ERROR_USER_PENDING_STATUS = "Email verification is pending";

		/**
		 * Reference to ERROR_MESSAGE_TOKEN_EMPTY
		 */
		public static final String ERROR_MESSAGE_TOKEN_EMPTY = "Your session is expired, please login again";// "Provide valid token value in AUTHORIZATION header";

		/**
		 * Reference to ERROR_MESSAGE_TOKEN_INVALID
		 */
		public static final String ERROR_MESSAGE_TOKEN_INVALID = "Your session is expired, please login again";

		/**
		 * Reference to ERROR_MESSAGE_TOKEN_EMPTY
		 */
		public static final String ERROR_MESSAGE_INVALID_ID = "Invalid Id";

		public static final String ERROR_MESSAGE_INVALID_EMAIL_ID = "Invalid password reset request, please provide correct email address";

		public static final String ERROR_MESSAGE_TOKEN_USED = "Your account is already activated";

		public static final String ERROR_MESSAGE_ACTIVATION_TOKEN_INVALID = "Unable to activate email address, Please check the email and try again";

		public static final String INVALID_EMAIL_ID = "Invalid Email Id";
		/**
		 * duplicate email id
		 */
		public static final String ERROR_MESSAGE_DUPLICATE_EMAIL_ID = "Email id is not exist, please use another one";
		public static final String ERROR_MESSAGE_DUPLICATE_VALIDATION = "Record is already available with entered values";

		public static final String ERROR_CODE_VALIDATION_ERROR = "Invalid parameters present";

		public static final String ERROR_MESSAGE_NO_VALID_UPLOAD_FOUND = "Please upload valid file extension";

		public static final String ERROR_MESSAGE_IMAGE_FILE_EXTENSION = "Please upload valid file extension like jpg,jpeg,bmp,png,gif";

		public static final String ERROR_MESSAGE_VIDEO_FILE_EXTENSION = "Please upload valid file extension like mp4,flv,webm,mpg,ogv,mov,m4v,3gpp,quicktime";

		public static final String ERROR_MESSAGE_DOC_FILE_EXTENSION = "Please upload valid file extension like txt,doc,docx,xls,pdf";

		public static final String ERROR_MESSAGE_IMAGE_FILE_SIZE = "File size should not exceeded more than 1 MB";

		public static final String ERROR_MESSAGE_VIDEO_FILE_SIZE = "Video size should not exceeded more than 25 MB";

		public static final String ERROR_MESSAGE_DOC_FILE_SIZE = "Doc size should not exceeded more than 5 MB";

		public static final String NO_FRAME_COUNT_ERROR = "No valid frames are available in your account";

		public static final String ERROR_CODE_SUCCESS = "Success";
		public static final String ERROR_CODE_FAILURE = "Failure";
		
		public static final String ERROR_MESSAGE_DUPLICATE_KEYNAME = "Keyname already exists, please enter different";
	    

		/**
		 * Reference to ERROR_CODE_TOKEN_VALIDATION_EXCEPTION
		 */
		public static final String ERROR_CODE_TOKEN_VALIDATION_EXCEPTION = "CRMVAL02";
		/** ERROR CODES **/

		/**
		 * Reference to ERROR_CODE_BAD_CREDENTIALS_EXCEPTION
		 */
		public static final String ERROR_CODE_BAD_CREDENTIALS_EXCEPTION = "CRMVAL01";
		
		/**
		 * Reference to ERROR_SQL_EXCEPTION
		 */
		public static final String ERROR_CODE_SQL_EXCEPTION = "1001";
		
		public static final String ERROR_MESSAGE_SQL_EXCEPTION = "Error while executing the query";
		
		/**
		 * Reference to ERROR_NOHANDLER_EXCEPTION
		 */
		
		public static final String ERROR_CODE_NOHANDLERFOUNDEXCEPTION = "1002";
		
		public static final String ERROR_MESSAGE_NOHANDLERFOUNDEXCEPTION = "No Handler To Perform Operation";

		
		
		/**
		 * Reference to ERROR_NULLPOINTER_EXCEPTION
		 */
		public static final String ERROR_CODE_NULLPOINTEREXCEPTION = "1003";
		
		public static final String ERROR_MESSAGE_NULLPOINTEREXCEPTION = "Provide the values for required fields";

		/**
		 * Reference to ERROR_NUMBERFORMAT_EXCEPTION
		 */
		public static final String ERROR_CODE_NUMBERFORMATEXCEPTION = "1004";
		
		public static final String ERROR_MESSAGE_NUMBERFORMATEXCEPTION = "Provide the values of correct type";
		
		/**
		 * Reference to ERROR_INDEXOUTOFBOUND_EXCEPTION
		 */
		public static final String ERROR_CODE_INDEXOUTOFBOUNDEXCEPTION = "1005";
		
		public static final String ERROR_MESSAGE_INDEXOUTOFBOUNDEXCEPTION = "The limit is exceeded check it again";
		
		/**
		 * Reference to ERROR_SecurityException_EXCEPTION
		 */
		public static final String ERROR_CODE_SECURITYEXCEPTION = "1006";
		
		public static final String ERROR_MESSAGE_SECURITYEXCEPTION = "Attempted to violate the security";
		
		
		
		 
		 /**
		  * Reference to ERROR_COMMUNICATIONSException_EXCEPTION
		  */
		 public static final String ERROR_CODE_COMMUNICATIONSEXCEPTION = "1007";
		 
		 public static final String ERROR_MESSAGE_COMMUNICATIONSCEPTION = "Attempted to get values not present in DB";

 
}
