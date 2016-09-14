import java.io.*;
import java.util.*;
class Pokemon
{
	public static void main(String[] args)
	{
		int i = 0;
		double total = 0;
		double[] poke = new double[3];//stores the count of different pokemon bought
		double[] price = new double[3];//stores the prices of different Pokemon types
		String[] type = new String[3];//stores the names of different pokemon
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Pokemon Toy Store\n");
		System.out.printf("How many Pikachu's : ");
		double pik = sc.nextDouble();
		while (pik < 0)
		{  
        	System.out.println("Invalid. Please enter again: ");
        	pik = sc.nextDouble();
     	}
		if(pik>0)
		{
			poke[i] = pik;
			price[i] = 6;
			type[i] = "Pikachu ";
			i++;
		}
		System.out.printf("\nHow many Squirtles : ");
		double squ = sc.nextDouble();
		while (squ < 0)
		{  
        	System.out.println("Invalid. Please enter again: ");
        	squ = sc.nextDouble();
     	}
		if(squ>0)
		{
			poke[i] = squ;
			price[i] = 5;
			type[i] = "Squirtle";
			i++;
		}
		System.out.printf("\nHow many Charmanders : ");
		double cha = sc.nextDouble();
		while (cha < 0)
		{  
        	System.out.println("Invalid. Please enter again: ");
        	cha = sc.nextDouble();
     	}
		if(cha>0)
		{
			poke[i] = cha;
			price[i] = 5;
			type[i] = "Charmander";
			i++;
		}
		i--;
		for(int j=0; j<i; j++)
		for (int x = 0; x < i; x++)
		{
            if (poke[x] < poke[x + 1])
            {
                double temp = poke[x];
                poke[x] = poke[x + 1];
                poke[x + 1] = temp;
                temp = price[x];
                price[x] = price[x + 1];
                price[x + 1] = temp;
                String temp_type = type[x];
                type[x] = type[x + 1];
                type[x + 1] = temp_type;
            }
        }
		if (i>0)// this helps in applying discounts to pokemon
		{
			double disc = poke[0];
			for(int x=0; x<=i; x++)//to find grouped pokemon
				if(poke[x]<disc)
					disc=poke[x];
			if (i == 2)
			{
				for(int x=0; x<=i; x++)//helps in applying 20% discount to 3 grouped pokemon
				{
					total = total + disc * (0.8 * price[x]);
					System.out.printf("\n"+type[x]+"\t%.0f\t20%% off\t%.2f", disc, disc * (0.8 * price[x]));
					poke[x] = poke[x] - disc;
				}
				i--;
			}
			for(int x=0; x<=i; x++)//to find grouped pokemon
					if(poke[x]<disc)
						disc=poke[x];
			if (i == 1 && disc!=0)
			{
				for(int x=0; x<=i; x++)// helps in applying 10% discount to 2 grouped pokemon
				{
					total = total + disc * (0.9 * price[x]);
					System.out.printf("\n"+type[x]+"\t%.0f\t10%% off\t%.2f", disc, disc * (0.9 * price[x]));
					poke[x] = poke[x] - disc;
				}
				for(int x=0; x<=i; x++)// price calculated for non-grouped pokemon
				{
					total = total + (poke[x] * price[x]);
					if((poke[x] * price[x]) != 0)
						System.out.printf("\n"+type[x]+"\t%.0f\t 0%% off\t%.2f", poke[x], poke[x]* price[x]);
				}
			}
			else
			{
				for(int x=0; x<=i; x++)// price calculated for non-grouped pokemon
				{
					total = total + (poke[x] * price[x]);
					if((poke[x] * price[x]) != 0)
						System.out.printf("\n"+type[x]+"\t%.0f\t 0%% off\t%.2f", poke[x], poke[x]* price[x]);
				}
			}
		}
		else// price calculated for non-grouped pokemon
		{
			if(type[0]==null)
				System.out.println("No Pokemon bought. Buy some Pokemon. We're giving good discounts today!!!");
			else
			{
				total = total + (poke[0] * price[0]);
				System.out.printf("\n"+type[0]+"\t%.0f\t 0%% off\t%.2f", poke[0], poke[0]* price[0]);
			}
		}
		System.out.printf("\nTotal Bill for all Pokemon is %.2f\n",total);
	}
}