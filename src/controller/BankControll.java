package controller;

import java.util.concurrent.Semaphore;

public class BankControll 
{
	private int pessoaId;
	private int saldo = 1000;
	Semaphore pausaDeposit;
	Semaphore pausaSaque;
	
	
	public BankControll(int pessoa, Semaphore pausa)
	{
		this.pessoaId = pessoa;
		this.pausaDeposit = pausa;
		this.pausaSaque = pausa;
	}

	public void bank()
	{
		new Thread()
		{
			public void run()
			{
				int op = (int) (Math.random() * 2) + 1;
				try {
					
					
					if(op == 1)
					{
						pausaDeposit.acquire();
						Thread.sleep((int) (Math.random() * 201) + 200);
						deposit();
					}
					else
					{
						pausaSaque.acquire();
						Thread.sleep((int) (Math.random() * 201) + 200);
						saque();
					}
					
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if(op == 1)
					{
						pausaDeposit.release();
					}
					else 
					{
						pausaSaque.release();
					}
				}
				
			}
		}.start();
	}
	
	
	
	public void deposit()
	{
		System.out.print("Pessoa " + this.pessoaId + " tem como saldo :" + this.saldo + "\nApos o deposito foi para ");
		this.saldo += (Math.random() * 201) + 100;
		System.out.println(this.saldo + "\n");
	}
	
	public void saque()
	{
		System.out.print("Pessoa " + this.pessoaId + " tem como saldo :" + this.saldo + "\nApos o deposito foi para ");
		this.saldo -= (Math.random() * 201) + 100;
		System.out.println(this.saldo + "\n");
	}
}
