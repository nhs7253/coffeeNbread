package com.cnb.validation.annotation;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.List;




public class MultiRowTarget implements Serializable {
	
	private List<Target> targets;

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public MultiRowTarget(List<Target> targets) {
		super();
		this.targets = targets;
	}

	@Override
	public String toString() {
		return "AddShoppingBasketProductForm [targets=" + targets + "]";
	}
	
	
	
}
