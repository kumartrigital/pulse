package com.gss.pulseworkflow.response;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gss.pulseworkflow.constants.AppConstants;
import com.gss.pulseworkflow.constants.AppErrorConstants;
import com.gss.pulseworkflow.constants.PulseWorkForceException;


/**
 * ResponseHelper.java
 * 
 * @author 
 * 
 */
public class ResponseHelper {

	/**
	 * Reference to EXCEPTION_RESPONSE
	 */
	public static Response EXCEPTION_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_CODE_UNKNOWN_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_UNKNOWN_EXCEPTION,
			AppErrorConstants.ERROR_MESSAGE_TYPE_UNKNOWN_EXCEPTION);

	/**
	 * Reference to TOKEN_EMPTY_EXCEPTION_RESPONSE
	 */
	public static Response TOKEN_EMPTY_EXCEPTION_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_CODE_TOKEN_VALIDATION_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_TOKEN_EMPTY,
			AppErrorConstants.ERROR_TYPE_AUTHENTICATION_EXCEPTION);

	/**
	 * Reference to TOKEN_INVALID_EXCEPTION_RESPONSE
	 */
	public static Response TOKEN_INVALID_EXCEPTION_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_CODE_TOKEN_VALIDATION_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_TOKEN_INVALID,
			AppErrorConstants.ERROR_TYPE_AUTHENTICATION_EXCEPTION);

	/**
	 * Reference to BAD_CREDENTIALS_EXCEPTION_RESPONSE
	 */
	public static Response BAD_CREDENTIALS_EXCEPTION_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_CODE_BAD_CREDENTIALS_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_BAD_CREDENTIALS,
			AppErrorConstants.ERROR_TYPE_AUTHENTICATION_EXCEPTION);

	/**
	 * Reference to VALIDATION_EXCEPTION
	 */
	public static Response VALIDATION_EXCEPTION_FOR_INVALID_EMAIL = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_INVALID_EMAIL_ID,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);
	/**
	 * Reference to
	 */
	public static Response DUPLICATE_EMAIL_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION,
			AppErrorConstants.ERROR_MESSAGE_DUPLICATE_EMAIL_ID,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);
	
	public static Response DUPLICATE_VALIDATION_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION,
			AppErrorConstants.ERROR_MESSAGE_DUPLICATE_VALIDATION,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);

	public static Response INVALID_EMAIL_ID_RESPONSE = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION, AppErrorConstants.INVALID_EMAIL_ID,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);

	public static final Response INVALID_IMAGE_FILE_ENTENSION_ERROR = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION,
			AppErrorConstants.ERROR_MESSAGE_IMAGE_FILE_EXTENSION,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);

	public static final Response INVALID_VIDEO_FILE_ENTENSION_ERROR = new Response(AppConstants.STATUS_FAILURE,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION,
			AppErrorConstants.ERROR_MESSAGE_VIDEO_FILE_EXTENSION,
			AppErrorConstants.ERROR_MESSAGE_TYPE_VALIDATION_EXCEPTION);

	/**
	 * @param obj
	 * @return Response
	 */
	public static Response buildResponse(Object obj,String status) {

		return new Response(obj,status);
	}

	/**
	 * Exception response
	 * 
	 * @param obj
	 * @return Response
	 */
	public static Response buildExceptionResponse(Exception e) {
		if(e!=null) {
		e.printStackTrace();
		}
		Response res = null;
		if (e instanceof PulseWorkForceException) {
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_UNKNOWN_EXCEPTION,
					((PulseWorkForceException) e).getExceptionMsg(), AppErrorConstants.ERROR_CODE_UNKNOWN_EXCEPTION);
		} else if (e instanceof SQLException) {
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_SQL_EXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_SQL_EXCEPTION, AppErrorConstants.ERROR_MESSAGE_TYPE_SQL_EXCEPTION);
		} else if (e instanceof NoHandlerFoundException) {
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_NOHANDLERFOUNDEXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_NOHANDLERFOUNDEXCEPTION, AppConstants.ERROR_MESSAGE_TYPE);
		} else if (e instanceof NullPointerException) {
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_NULLPOINTEREXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_NULLPOINTEREXCEPTION,
					AppConstants.ERROR_MESSAGE_TYPE);
		} else if(e instanceof NumberFormatException){
			res = new Response(AppConstants.STATUS_FAILURE,AppErrorConstants.ERROR_CODE_NUMBERFORMATEXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_NUMBERFORMATEXCEPTION, AppConstants.ERROR_MESSAGE_TYPE);
		}else if(e instanceof IndexOutOfBoundsException){
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_INDEXOUTOFBOUNDEXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_INDEXOUTOFBOUNDEXCEPTION, AppConstants.ERROR_MESSAGE_TYPE);
		}else if(e instanceof SecurityException){
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_INDEXOUTOFBOUNDEXCEPTION,
					AppErrorConstants.ERROR_MESSAGE_INDEXOUTOFBOUNDEXCEPTION, AppConstants.ERROR_MESSAGE_TYPE);
		}
		/*else if (e instanceof CommunicationsException) {
			   res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_COMMUNICATIONSEXCEPTION,
			     AppErrorConstants.ERROR_MESSAGE_COMMUNICATIONSCEPTION,AppConstants.ERROR_MESSAGE_TYPE);
			  }
		else if(e instanceof RuntimeException) {
			   res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_COMMUNICATIONSEXCEPTION,
			     AppErrorConstants.ERROR_MESSAGE_COMMUNICATIONSCEPTION,
			     AppErrorConstants.ERROR_MESSAGE_TYPE_SQL_EXCEPTION);
			  }*/
		else if(e instanceof RuntimeException) {
			   res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_COMMUNICATIONSEXCEPTION,
			     AppErrorConstants.ERROR_MESSAGE_COMMUNICATIONSCEPTION,
			     AppErrorConstants.ERROR_MESSAGE_TYPE_SQL_EXCEPTION);
			  }
		else {
		
			res = new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_UNKNOWN_EXCEPTION,
					e.getMessage(), AppErrorConstants.ERROR_CODE_UNKNOWN_EXCEPTION);
		}
		// TODO: based on type of exception , send corresponding error
		// codes/messages
		return res;

	}

	/**
	 * @param obj
	 * @return Response
	 */
	public static Response buildIdResponse(Object id) {
		Response res = new Response();
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(AppConstants.ID_NAME, id.toString());
		res.setResult(properties);
		return res;

	}

	/**
	 * @return Response
	 */
	public static Response buildResponse() {
		return new Response();

	}

	public static Response buildSuccessResponse(String successMessage) {
		return new Response(successMessage,null,null);

	}

	public static Response buildFailureResponse(String errorResponse) {
		return new Response(AppConstants.STATUS_FAILURE, AppErrorConstants.ERROR_CODE_FAILURE, errorResponse);

	}

	public static Response buildErrorResponse(String errorMessage) {
		return new Response(errorMessage);

	}
}