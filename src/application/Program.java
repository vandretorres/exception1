package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){


		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Check-in date: (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date: (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());


			Reservation res= new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation" + res);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date: (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date: (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());


			res.updateDates(checkIn, checkOut);
			System.out.println("Reservation" + res);

		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
			
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Room Number. Only numbers are accpeted");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpeted error");
		}
		
		
		finally {
			
			sc.close();
		}

	}

}


