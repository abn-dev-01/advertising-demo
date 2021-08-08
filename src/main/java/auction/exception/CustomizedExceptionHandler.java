package auction.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends AbstractCustomizedExceptionHandler {

//    public static final String NO_NAME = "No name";
//    public static final String NO_DESCRIPTION = "No description";
//
//    /**
//     * 400 BAD_REQUEST
//     *
//     * @param ex
//     * @param request
//     *
//     * @return
//     */
//    @ExceptionHandler(UnknownFilteringFieldException.class)
//    public final ResponseEntity<Object> handleCommon400BadExpressions(Exception ex, WebRequest request) {
//
//        var status = HttpStatus.BAD_REQUEST;
//        final var name = request != null && ((ServletWebRequest) request).getHttpMethod() != null
//            ? ((ServletWebRequest) request).getHttpMethod().name()
//            : NO_NAME;
//        final var description = request != null ? request.getDescription(false) : NO_DESCRIPTION;
//
//        var exceptionResponse = new ExceptionResponse(
//            LocalDateTime.now().toString(),
//            status.value(),
//            status.getReasonPhrase(),
//            name + " " + description,
//            ex.getMessage());
//        return new ResponseEntity<>(exceptionResponse, status);
//    }
}
