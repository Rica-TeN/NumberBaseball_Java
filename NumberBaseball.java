import java.util.Scanner ;

public class NumberBaseball
{
	boolean bCheck ;
	
	
	public static void main ( String args [] )
	{
		Number4Set AINum = new Number4Set ( true ) ;
		Number4Set UserNum = new Number4Set () ;
		int iCount = 0 ;
		final int iMax = 10 ;
		
		while ( iCount < iMax )
		{
			UserNum.NumSet () ;
			AINum.Compare ( UserNum ) ;
			
			
			if ( AINum.bHomerun )
				break ;
			
			++ iCount ;
		}
	}
}