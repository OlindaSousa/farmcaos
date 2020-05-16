package ie.cct.farmcaos2019414;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestExecption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1854594800079985335L;

	public BadRequestExecption(String msg) {
		super(msg);
	}
	
}
