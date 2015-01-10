package com.dubcan.jsftest.registrar.card;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubcan.jsftest.card.CardBinder;
import com.dubcan.jsftest.card.CardRegistrar;
import com.dubcan.jsftest.card.RegisterCardRequest;
import com.dubcan.jsftest.card.RegisterCardResponse;

/**
 * Only for test purposes
 * @author dubcan
 *
 */
@Deprecated
@Stateless
@Local(CardRegistrar.class)
public class CardRegistrarStubEJB implements CardRegistrar {

	private static final double ERROR_CHANCE = 0; //0.00 - 1.00
	private static final Logger log = LoggerFactory.getLogger(CardRegistrarStubEJB.class);
	
	@EJB
	private CardBinder cardBinder;
	
	@Override
	public RegisterCardResponse register(RegisterCardRequest request) {
		log.trace("starting... {}", request);
		RegisterCardResponse result = getResult();
		cardBinder.finish();
		log.trace("finished. result = {}", result );
		return result;
	}

	private RegisterCardResponse getResult() {
		if (Math.random() > ERROR_CHANCE) {
			return new RegisterCardResponse.Success() {
				private static final long serialVersionUID = 1L;

				@Override
				public <T> T accept(Visitor<T> visitor) {
					return visitor.visit(this);
				}
				
				@Override
				public Long getTransactionId() {
					return (long) (Math.random() * 1000 + 1);
				}
			};
		}
		
		return new RegisterCardResponse.Error() {
			private static final long serialVersionUID = 1L;

			@Override
			public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this);
			}
			
			@Override
			public String getErrorMessage() {
				return "some error occured";
			}
		};
	}
}
