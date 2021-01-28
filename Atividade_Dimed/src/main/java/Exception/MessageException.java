package Exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;


@Getter
public class MessageException extends RuntimeException{
		
		private static final long serialVersionUID = -7982161811881602695L;
			
			private final HttpStatus httpStatus;
			
			public MessageException(final String mensagem, final HttpStatus httpStatus) {
				super(mensagem);
				this.httpStatus = httpStatus;
			}

			public HttpStatus getHttpStatus() {
				return httpStatus;
			}


		}
