package org.pfaa.chemica.model;

import java.awt.Color;

public class ChemicalPhaseProperties extends PhaseProperties {
	public final Thermo thermo;
	
	public ChemicalPhaseProperties(Color color, double density, Thermo thermo, Hazard hazard) {
		super(color, density, hazard);
		this.thermo = thermo;
	}
	
	public static class Solid extends ChemicalPhaseProperties {
		public Solid(Color color, double density, Thermo thermo, Hazard hazard)
		{
			super(color, density, thermo, hazard);
		}
		public Solid(Color color, double density, Thermo thermo)
		{
			this(color, density, thermo, new Hazard());
		}
		public Solid(double density, Thermo thermo, Hazard hazard)
		{
			this(Color.WHITE, density, thermo, hazard);
		}
		public Solid(double density, Thermo thermo)
		{
			this(density, thermo, new Hazard());
		}
		public Solid(Thermo thermo)
		{
			this(Double.NaN, thermo);
		}
		public Solid() {
			this(null);
		}
	}
	
	public static class Liquid extends ChemicalPhaseProperties {
		public Liquid(Color color, double density, Thermo thermo, Hazard hazard)
		{
			super(color, density, thermo, hazard);
		}
		public Liquid(double density, Thermo thermo, Hazard hazard)
		{
			this(new Color(200, 200, 230), density, thermo, hazard);
		}
		public Liquid(double density, Thermo thermo)
		{
			this(density, thermo, new Hazard());
		}
		public Liquid(Thermo thermo)
		{
			this(Double.NaN, thermo);
		}
		public Liquid() {
			this(null);
		}
	}
	
	public static class Gas extends ChemicalPhaseProperties {
		public Gas(Color color, Thermo thermo, Hazard hazard)
		{
			super(color, Double.NaN, thermo, hazard);
		}
		public Gas(Thermo thermo, Hazard hazard)
		{
			this(Color.WHITE, thermo, hazard);
		}
		public Gas(Thermo thermo)
		{
			this(thermo, new Hazard());
		}
		public Gas()
		{
			this(null);
		}
		
		public Gas(Color color, double density, Thermo thermo, Hazard hazard)
		{
			super(color, density, thermo, hazard);
		}
		
		public Gas assumeDensityAtSTP(double molarMass) {
			double density = Gas.getDensity(molarMass, Constants.STANDARD_TEMPERATURE, Constants.STANDARD_PRESSURE);
			return new Gas(this.color, density, this.thermo, this.hazard);
		}
		
		public static double getDensity(double molarMass, double temperature, double pressure) {
			return (molarMass * pressure) / (Constants.R * temperature);
		}
	}
}