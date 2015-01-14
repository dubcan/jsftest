package com.dubcan.jsftest.modal;

import java.io.Serializable;

public interface ModalData extends Serializable {
	interface Visitor {

		void visit(FooModalData data);

		void visit(BarModalData data);

		void visit(BazModalData data);
	}
	
	void accept(Visitor v);
}
