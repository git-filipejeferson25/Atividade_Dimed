package Model;


import Service.Linha_Service;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> {
	private int statusCode;
	private T data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setData(Linha_Service linha) {
		// TODO Auto-generated method stub

	}

}
