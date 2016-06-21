package group3;

class Test {
	static String irum;
	
	static{
		irum = "SSD";
		System.out.println("irum = " + irum);
	}
	
	public static void main(String[] args) {
		Test ex = new Test();
		ex.irum = "HGD";
		System.out.print(ex.irum);
		System.out.println(irum);
	}
}
