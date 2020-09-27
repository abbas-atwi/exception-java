package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero quarto");

		int quartoNumero = sc.nextInt();
		System.out.println("CheckIn (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("CheckOut (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Invalido");
		} else {
			Reservas res = new Reservas(quartoNumero, checkIn, checkOut);
			System.out.println("reservas " + res);
			System.out.println();
			System.out.println("Atualizar data");
			System.out.println("CheckIn (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error somente datas futuras");
			}else if (!checkOut.after(checkIn)) { 
				System.out.println("Invalido");
			}
			else {
				res.updateDate(checkIn, checkOut);
			System.out.println("reservas " + res);
			
			}
			
		}

		sc.close();

	}

}
