import java.util.Scanner ;
import java.util.Random ;

public class Number4Set
{
	public int i1 ;
	public int i2 ;
	public int i3 ;
	public int i4 ;
	public int iInput ;
	public boolean bInputAgain ;
	public boolean bHomerun ;
	Random rand = new Random () ;
	
	
	public Number4Set ()
	{
		i1 = 0 ;
		i2 = 0 ;
		i3 = 0 ;
		i4 = 0 ;
		iInput = 0 ;
		bInputAgain = true ;
		bHomerun = false ;
	}
	
	public Number4Set ( boolean bool )
	{
		bInputAgain = true ;
		bHomerun = false ;
		
		
		while ( bInputAgain )
		{
			iInput = rand.nextInt ( 10000 ) ;
			NumSeparate () ;
			NumCheck () ;
		}
	}
	
	public void NumSet ()
	{
		Scanner sScan = new Scanner ( System.in ) ;
		
		
		while ( bInputAgain )
		{
			System.out.print ( "Input Number : " ) ;
			iInput = sScan.nextInt () ;

			if ( ( iInput > 9999 ) || ( iInput < 0 ) )
				;
			else
			{
				NumSeparate () ;
				NumCheck () ;
			}
		}
	}
	
	public void NumSeparate ()
	{
		i1 = iInput / 1000 ;
		i2 = iInput % 1000 / 100 ;
		i3 = iInput % 100 / 10 ;
		i4 = iInput % 10 ;
	}
	
	public void NumCheck ()
	{
		if ( ( i1 == i2 ) || ( i1 == i3 ) || ( i1 == i4 )
				|| ( i2 == i3 ) || ( i2 == i4 ) || ( i3 == i4 ) )
			;
		else
			bInputAgain = false ;
	}
	
	public void Compare ( Number4Set UserNum )
	{
		int iStrike = 0 ;
		int iBall = 0 ;
		
		
		if ( UserNum.i1 == this.i1 )
			++ iStrike ;
		else if ( UserNum.i1 == this.i2 )
			++ iBall ;
		else if ( UserNum.i1 == this.i3 )
			++ iBall ;
		else if ( UserNum.i1 == this.i4 )
			++ iBall ;
		if ( UserNum.i2 == this.i2 )
			++ iStrike ;
		else if ( UserNum.i2 == this.i1 )
			++ iBall ;
		else if ( UserNum.i2 == this.i3 )
			++ iBall ;
		else if ( UserNum.i2 == this.i4 )
			++ iBall ;
		if ( UserNum.i3 == this.i3 )
			++ iStrike ;
		else if ( UserNum.i3 == this.i1 )
			++ iBall ;
		else if ( UserNum.i3 == this.i2 )
			++ iBall ;
		else if ( UserNum.i3 == this.i4 )
			++ iBall ;
		if ( UserNum.i4 == this.i4 )
			++ iStrike ;
		else if ( UserNum.i4 == this.i1 )
			++ iBall ;
		else if ( UserNum.i4 == this.i2 )
			++ iBall ;
		else if ( UserNum.i4 == this.i3 )
			++ iBall ;
		
		
		if ( 4 == iStrike )
		{
			System.out.println ( "HomeRun!" ) ;
			this.bHomerun = true ;
		}
		else if ( ( 0 != iStrike ) || ( 0 != iBall ) )
			System.out.println ( iStrike + " Strike, " + iBall + " Ball" ) ;
		else
			System.out.println ( "Out" ) ;
		
		
		UserNum.bInputAgain = true ;
	}
	
}