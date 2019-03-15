package previous2018;

public class Test {

	public static void main(String[] args) {
		long x=0;
		for(int i=0; i<100000;i++)
		{
			for(int j=0; j<100000;j++)
			{
				x++;
			}
		}
		System.out.println("done "+x);

	}

}
