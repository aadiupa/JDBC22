import java.sql.SQLException;
import java.util.Scanner;
public class JdbcConnection
{
	static ConnectToDB ss=new ConnectToDB ();
	static Scanner s = new Scanner(System.in);
	static JdbcConnection h = new JdbcConnection();
	static String a="";
	public static void main(String[] args) 
	{

		ss.getConn();
		String s5="truncate table mycart" ;
		try 
		{
			ss.st.execute(s5);
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}

		int a1=0;
		try 
		{
			#modified
			System.out.println("Enter your Username");
			a = s.next();
			System.out.println("Enter your Password");
			String b = s.next();
			String s1="select utid from user_details where uname='"+a+" 'and pwd='"+b+"'";
			ss.st=ss.con.createStatement();
			ss.rs = ss.st.executeQuery(s1);
			while(ss.rs.next())
			{
				a1 = ss.rs.getInt(1);
			}
			switch(a1)
			{
			case 1:
				h.isAdmin();

				break;

			case 2:
				h.isCustomer();
				break;

			default: System.out.println("Invalid Username or password");
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}

	}
	public void isAdmin() 
	{
		if(a!="")
		{
			System.out.println("Welcome to admin console '" + a + "' ");
			a="";
		}
		System.out.println("Press 1 if you want to add a new Dish"
				+ "\nPress 2 if you want to update a Dish " 
				+ "\nPress 3 if you want to add a new Category");
		int a2 = s.nextInt();
		switch(a2)
		{
		case 1: h.addingDish();

		break;
		case 2: h.updateDish();

		break;

		case 3: h.addingCategory();

		break;

		default: System.out.println("This is an invalid input");
		System.out.println("If you want to go back to the admin console then press 1 else press any key");
		int a5 = s.nextInt();
		if(a5==1)
		{
			isAdmin();
		}
		else
		{
			ss.isClose();
			System.out.println("Connection is Closed");
			System.exit(0);
		}
		}
	}
	public void isCustomer() 
	{
		if(a!="")
		{
			System.out.println("Welcome to the Hotel Mr/Ms. '" + a + "' ");
			a="";
		}
		System.out.println("Press 1 if you want to see the Menu "
				+ "\nPress 2 to add items in your cart"
				+ " \nPress 3 to view the cart");
		int a3 = s.nextInt();
		switch(a3)
		{
		case 1: h.seeMenu();


		break;

		case 2: h.addItem();
		//System.out.println("Press 1 to continue else press any key to quit" );


		break;

		case 3: h.viewCart();
		break;

		default: System.out.println("Invalid input");
		System.out.println("If you want to go back to the console then press 1 else press any key");
		int a5 = s.nextInt();
		if(a5==1)
		{
			isCustomer();
		}
		else
		{
			ss.isClose();
			System.out.println("Connection is Closed");
			System.exit(0);
		}
		}

	}

	public void addingDish()
	{ 
		System.out.println("Enter the number of dishes you want to add ");
		int no = s.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter the dish name which you want to enter");
			String dname= s.next();
			System.out.println("Enter the dish type \n1 for Veg "
					+ "\n2 for NonVeg");
			int dtype=s.nextInt();
			System.out.println("Enter the dish category");
			System.out.println("Press 1 for Soup \n Press 2 for starters \n Press 3 for maincourse"
					+ " \n Press 4 for Desserts");
			int cat= s.nextInt();
			System.out.println("Enter the cost of the Dish");
			int cost = s.nextInt();
			System.out.println("Enter the availability of the dish as (True or false)");
			String avail = s.next();
			String s2 = "insert into dish(dname, dcost,davail, did, cid) "
					+ "values('"+dname+"','"+cost+"','"+avail+"','"+dtype+"','"+cat+"')";
			try 
			{
				ss.st.executeUpdate(s2);
				System.out.println("Inserted");

				System.out.println("Press 1 to continue else press any key to quit" );
				int n1=s.nextInt();
				if(n1==1) 
				{
					h.isAdmin();
				}
				else 
				{ 
					ss.isClose();
					System.out.println("Thank you ");
					System.exit(0);
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void updateDish()
	{
		System.out.println("Enter the dish id you want to update ");
		int did= s.nextInt();
		System.out.println("What you want to update in this dish \n"
				+ "Press 1 for name"
				+ "\nPress 2 for Cost "
				+ "\nPress 3 for availability");
		int ab= s.nextInt();
		switch(ab)
		{
		case 1: System.out.println("Enter the new name for the dish");
		String nw=s.next();
		String stw="update dish set dname='"+nw+"' where dishid='"+did+"'";
		try {
			ss.st.executeUpdate(stw);
			System.out.println("updated");
			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isAdmin();
			}
			else 
			{ 
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
			break;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		case 2: System.out.println("Enter the new cost for the dish you want to update");
		int sr = s.nextInt();
		String srw="update dish set dcost='"+sr+"' where dishid='"+did+"'";
		try 
		{
			ss.st.executeUpdate(srw);
			System.out.println("updated");
			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isAdmin();
			}
			else 
			{ 
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
			break;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}


		case 3:System.out.println("Enter the availability of dish(true or false)");
		String sp = s.next();
		String srw2="update dish set davail='"+sp+"' where dishid='"+did+"'";
		try
		{
			ss.st.executeUpdate(srw2);
			System.out.println("updated");
			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isAdmin();
			}
			else
			{
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
			break;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Updated");

		default: System.out.println("Invalid option, Please select a valid option");

		}
	}
	public void addingCategory() 
	{
		System.out.println("Enter the new category name you want");
		String st = s.next();
		String st1= "insert into category(cname) values('"+st+"')";
		try 
		{
			ss.st.executeUpdate(st1);
			System.out.println("Successfully Inserted");
			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isAdmin();
			}
			else 
			{ 
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void seeMenu()
	{
		System.out.println("Press 1 if you want Veg Menu"
				+ "\nPress 2 for Non-Veg Menu"
				+ "\nPress 3 for consolidate Menu");
		int n=s.nextInt();
		switch(n)
		{
		case 1: System.out.println("Veg menu ");
		System.out.println("-----------------------------------------");
		String st1= "select dname,dcost from dish where did='"+n+"'";
		try 
		{
			ss.rs = ss.st.executeQuery(st1);
			while(ss.rs.next())
			{
				System.out.println(ss.rs.getString(1) + " " + ss.rs.getString(2));
			}
			System.out.println("Press 1 to continue else press any key to quit" );
			int n2=s.nextInt();
			if(n2==1) 
			{
				h.isCustomer();
			}
			else 
			{
				ss.isClose();
				System.out.println("Thank you for visiting");
				System.exit(0);
			}
			break;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		case 2: System.out.println("non veg menu");
		String st2= "select dname,dcost from dish where did='"+n+"'";
		try
		{
			ss.rs = ss.st.executeQuery(st2);
			while(ss.rs.next())
			{
				System.out.println(ss.rs.getString(1) + " " + ss.rs.getString(2));
			}
			System.out.println("Press 1 to continue else press any key to quit" );
			int n2=s.nextInt();
			if(n2==1) 
			{
				h.isCustomer();
			}
			else 
			{
				ss.isClose();
				System.out.println("Thank you for visiting");
				System.exit(0);
			}
			break;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		case 3: System.out.println("Consolidate Menu");
		String st3= "select dname,dcost from dish";
		try
		{
			ss.rs = ss.st.executeQuery(st3);
			while(ss.rs.next())
			{
				System.out.println("Dish Name-- " + ss.rs.getString(1) + "Price-- " + ss.rs.getString(2));
			}
			System.out.println("Press 1 to continue else press any key to quit" );
			int n2=s.nextInt();
			if(n2==1)
			{
				h.isCustomer();
			}
			else 
			{
				ss.isClose();
				System.out.println("Thank you for visiting");
				System.exit(0);
			}
			break;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
	}
	public void addItem()
	{
		//	seeMenu();
		System.out.println("Enter the number of dishes you want to add");
		int n =s.nextInt();
		try
		{
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter the dish name you want to add");
				String st= s.next();
				String st1= "select dcost from dish where dname='"+st+"'";
				int c=0;

				ss.rs=ss.st.executeQuery(st1);
				while(ss.rs.next())
				{
					c = ss.rs.getInt(1);
				}
				int sp=1;
				String st2= "insert into mycart(i_name,qtyy,dcost) values('"+st+"','"+sp+"','"+c+"')";
				ss.st.executeUpdate(st2);
			}
			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isCustomer();
			}
			else 
			{ 
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}


	public void viewCart() 
	{
		try
		{
			String st= "select cartid, i_name, qtyy, dcost from mycart";
			ss.rs=ss.st.executeQuery(st);
			while(ss.rs.next())
			{
				System.out.println("S.no " + ss.rs.getInt(1)+ "\nDish Name-- " + ss.rs.getString(2)+ "\nQuantity-- " +ss.rs.getInt(3)+ "\nPrice-- " +ss.rs.getInt(4));
				System.out.println();
			}
			String st1= "select sum(dcost) from mycart";
			ss.rs=ss.st.executeQuery(st1);
			while(ss.rs.next())
			{
				System.out.println();
				System.out.println("Total cost of the item "+ ss.rs.getInt(1));
			}

			System.out.println("Press 1 to continue else press any key to quit" );
			int n1=s.nextInt();
			if(n1==1) 
			{
				h.isCustomer();
			}
			else 
			{ 
				ss.isClose();
				System.out.println("Thank you ");
				System.exit(0);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
