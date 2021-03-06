package org.pfaa.chemica.model;

import java.awt.Color;

public interface IndustrialMaterial {
	public enum Phase {
		SOLID, LIQUID, GAS;
	}
	public String name();
	public String getOreDictKey();
	public PhaseProperties getProperties(Phase phase);
	public Mixture mix(IndustrialMaterial material, double weight);
}
