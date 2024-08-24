package task2;

 class Matrix {
	private double[][] elements;
	int xrow;
	int xcol;
	
	public Matrix(int row, int col){
		elements = new double[row][col];
		xrow = row;
		xcol = col;
	}
	
	public Matrix(double[][] a) {
		elements = a;
		xrow = a.length;
		xcol = a[0].length;
	}
	
	public double get(int row, int col) {
		if(row > xrow || row < 0 || col > xcol || col < 0)
		{
			return -1;
		}
		return elements[row][col];
	}
	
	public void set(int row, int col, double data) {
		if(row < xrow && row >= 0 && col < xcol && col >= 0)
		{
			elements[row][col] = data; 
		}
	}
	
	public Matrix add(Matrix b)
	{
		if(b.xrow != xrow || b.xcol != xcol)
		{
			return null;
		}
		Matrix ret = new Matrix(b.xrow, b.xcol);
		for(int i = 0; i < xrow; i++)
		{
			for(int j = 0; j < b.xcol; j++)
			{
				ret.elements[i][j] = b.get(i, j) + get(i,j);
			}
		}
		return ret;
	}

	public Matrix multiply(Matrix b){
		
		if(xcol != b.xrow) {return null;}
		
		double[][] newElements = new double[xrow][b.xcol];
		for(int i = 0; i < xrow; i++) {
			for(int j = 0; j < b.xcol; j++) {
				double sum = 0;
				for(int k = 0; k < xcol; k++) {
					sum += elements[i][j] * b.elements[k][j];
				}
				newElements[i][j] = sum;
			}
		}
		return new Matrix(newElements);
	}
	
	public void printmatrix() {
		for(int i = 0; i <xrow ; i++) {
			for(int j = 0; j <xcol ; j++) {
				System.out.print(get(i,j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[]args) {
		Matrix a = new Matrix(3,3);
		Matrix b = new Matrix(3,3);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				a.set(j, i, 4);
				b.set(i, j, 4);
			}
		}
		
		
		a.multiply(b).printmatrix();
		a.add(b).printmatrix();
		a.printmatrix();
		b.printmatrix();	
	}	
}


   
