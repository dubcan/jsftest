package com.dubcan.jsftest.card;

import java.io.Serializable;

public interface RegisterCardResponse extends Serializable {
	public interface Visitor<T> {
		T visit(Success response);

		T visit(Error response);
	}

	<T> T accept(Visitor<T> visitor);

	public interface Success extends RegisterCardResponse {
		Long getTransactionId();
	}

	public interface Error extends RegisterCardResponse {
		String getErrorMessage();
	}
}