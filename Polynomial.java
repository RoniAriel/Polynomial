public class Polynomial {
	int degree;
	double[] coeff;

	/*
	 * Creates the zero-polynomial with p(x) = 0 for all x.
	 */
	public Polynomial() {
		this.coeff = new double[1];
		this.coeff[0] = 0.0;
		degree = 0;
	}

	/*
	 * Creates a new polynomial with the given coefficients.
	 */
	public Polynomial(double[] coefficients) {
		int lastValidIndex = -1;
		if (coefficients.length >= 1) {
			 lastValidIndex = GetLastValidIndex(coefficients);
		}
		if (lastValidIndex >= 0) {
			BuildFieldsForPoly(coefficients, lastValidIndex);
		}
		if (lastValidIndex < 0){
			ZeroArray();
		}
	}

	private int GetLastValidIndex(double[] array) {
		int lastValidIndex = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != 0.0) {
				lastValidIndex = i;
				return lastValidIndex;
			}
		}
		return lastValidIndex;
	}

	private void BuildFieldsForPoly(double[] coefficients, int LastValidIndex) {
		this.coeff = new double[LastValidIndex + 1];
		for (int i = 0; i <= LastValidIndex; i++) {
			this.coeff[i] = coefficients[i];
		}
		this.degree = this.coeff.length - 1;
	}

	private void ZeroArray (){
		this.coeff= new double[1];
		this.coeff[0] =0.0;
		this.degree =0;
	}

	/*
	 * Addes this polynomial to the given one
	 *  and retruns the sum as a new polynomial.
	 */
	public Polynomial adds(Polynomial polynomial) {
		double[] b = this.coeff;
		double[] a = polynomial.coeff;
		if (polynomial.coeff.length > this.coeff.length) {
			 a = this.coeff;
			 b = polynomial.coeff;
		}
		double [] addPolynomial =addingPoly(a,b);
		return new Polynomial(addPolynomial);
		}


	/*
	 * Multiplies a to this polynomial and returns 
	 * the result as a new polynomial.
	 */
	public Polynomial multiply(double a)
	{
		double [] multiplyPoly = new double [this.coeff.length] ;
		for (int i=0; i< coeff.length; i++){
			multiplyPoly[i] = (this.coeff[i] *a);
		}
		return new Polynomial(multiplyPoly);
	}

	private double [] addingPoly (double [] a, double [] b){
		int n = a.length;
		double[] addPolynomial = new double[b.length];
		for (int i = 0; i < a.length; i++) {
			addPolynomial[i] = (a[i] + b[i]);
		}
		while (b.length > n) {
			addPolynomial[n] = b[n];
			n++;
		}
		return addPolynomial;
	}
	/*
	 * Returns the degree (the largest exponent) of this polynomial.
	 */
	public int getDegree()
	{
		return this.degree;
	}
	/* given index = return coff
	 * Returns the coefficient of the variable x 
	 * with degree n in this polynomial.
	 */
	public double getCoefficient(int n) {
		if (n <= this.degree) {
			return this.coeff[n];
		} else {
			return 0.0;
		}
	}
	
	/*
	 * set the coefficient of the variable x 
	 * with degree n to c in this polynomial.
	 * If the degree of this polynomial < n, it means that that the coefficient of the variable x 
	 * with degree n was 0, and now it will change to c. 
	 */
	public void setCoefficient(int n, double c)
	{
		if (n <= this.degree){
			this.coeff[n] =c;
		}
		else {
			double [] AddcoeffTemp = new double[n+1];
			AddcoeffTemp[n] =c;
			double [] setNew = addingPoly(this.coeff, AddcoeffTemp);
			this.coeff = setNew;
			this.degree = this.coeff.length-1;
		}
	}

	
	/*
	 * Returns the first derivation of this polynomial.
	 *  The first derivation of a polynomal a0x0 + ...  + anxn is defined as 1 * a1x0 + ... + n anxn-1.
	
	 */
	public Polynomial getFirstDerivation()
	{
		if (this.coeff.length == 1){ return new Polynomial();}
		double [] FirstDerivation = new double[this.coeff.length-1];
		for (int i = 1; i< this.coeff.length; i++){
			FirstDerivation[i-1] = this.coeff[i]* i;
		}
		return new Polynomial(FirstDerivation);
	}
	
	/*
	 * given an assignment for the variable x,
	 * compute the polynomial value
	 */
	public double computePolynomial(double x)
	{
		double Sum = 0.0;
		for (int i =0; i< this.coeff.length; i++){
			Sum += coeff[i] * (Math.pow(x, i));
		}
		return Sum;
	}
	
	/*
	 * given an assignment for the variable x,
	 * return true iff x is an extrema point (local minimum or local maximum of this polynomial)
	 * x is an extrema point if and only if The value of first derivation of a polynomal at x is 0
	 * and the second derivation of a polynomal value at x is not 0.
	 */
	public boolean isExtrema(double x)
	{
		Polynomial FirstDerivationPoly = getFirstDerivation();
		if (FirstDerivationPoly.computePolynomial(x) != 0) {
			return false;
		}
		Polynomial SecondDerivationPoly = FirstDerivationPoly.getFirstDerivation();
		if (SecondDerivationPoly.computePolynomial(x) == 0){
			return false;
		}
		return true;
	}
	
	
	
	

    
    

}
