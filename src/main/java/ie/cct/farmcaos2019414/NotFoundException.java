package ie.cct.farmcaos2019414;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6518457792854645243L;

	public NotFoundException(String msg) {
		super(msg);
	}
	
}