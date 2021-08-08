package auction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class AbstractCustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String UNKNOWN_HTTP_METHOD = "Unknown-Http-Method";

    /**
     * 500 INTERNAL_ERROR ~ For each Unhandled Errors.
     */
    @ExceptionHandler({Exception.class, InternalServerErrorException.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        var exceptionResponse = new ExceptionResponse(
            LocalDateTime.now().toString(),
            status.value(),
            "Unexpected error. " + ex.getMessage(),
            getHttpMethodName((ServletWebRequest) request) + " " + request.getDescription(false),
            ex.getMessage()
        );
        return new ResponseEntity<>(exceptionResponse, status);
    }

    /**
     * 400 BAD_REQUEST
     */
    @ExceptionHandler({BadRequestException.class, IllegalArgumentException.class})
    public final ResponseEntity<Object> handleBadRequestException(Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        var exceptionResponse = new ExceptionResponse(
            LocalDateTime.now().toString(),
            status.value(),
            "Invalid request. " + ex.getMessage(),
            getHttpMethodName((ServletWebRequest) request) + " " + request.getDescription(false),
            ex.getMessage()
        );
        return new ResponseEntity<>(exceptionResponse, status);
    }

    /**
     * 404 NOT_FOUND
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        var exceptionResponse = new ExceptionResponse(
            LocalDateTime.now().toString(),
            status.value(),
            "Data not found. " + ex.getMessage(),
            getHttpMethodName((ServletWebRequest) request) + " " + request.getDescription(false),
            ex.getMessage()
        );
        return new ResponseEntity<>(exceptionResponse, status);
    }

    /**
     * Detect Http method name using request. Default name is Unknown
     */
    protected String getHttpMethodName(ServletWebRequest request) {
        if (request != null && request.getHttpMethod() != null) {
            return request.getHttpMethod().name();
        }
        return UNKNOWN_HTTP_METHOD;
    }
}
