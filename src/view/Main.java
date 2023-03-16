package view;

import java.util.concurrent.Semaphore;

import controller.BankControll;

public class Main 
{
	public static void main(String[] args)
	{
		Semaphore perm = new Semaphore(1);
		
		for (int i = 1; i <= 20; i++)
		{
			BankControll pessoa = new BankControll(i, perm);
			pessoa.bank();
		}
		
		
	}

}
