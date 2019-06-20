import java.util.Calendar;

public class Timee
{
	public static void main(String[] args) 
	{


		Calendar cal = Calendar.getInstance();
		int hour = cal.get( Calendar.HOUR_OF_DAY );
		int month = cal.get( Calendar.MONTH );

		if( hour == 5 ) {
			if( month > 2 && month < 9 ) {
				System.out.println( "Good morning!" );
			}
			else {
				System.out.println( "Good night!" );
			}
		}
		else if( hour > 5 && hour < 12 ) {
			System.out.println( "Good morning!" );
		}
		else if( hour > 11 && hour < 17 ) {
			System.out.println( "Good afternoon!" );
		}
		else if( hour == 17 ) {
			if( month > 2 && month < 9 ) {
				System.out.println( "Good afternoon!" );
			}
			else {
				System.out.println( "Good evening!" );
			}
		}
		else if( hour > 17 && hour < 19 ) {
			System.out.println( "Good evening!" );
		}
		else {
			System.out.println( "Good night!" );
		}
	}
}
