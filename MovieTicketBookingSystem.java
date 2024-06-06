import java.util.Scanner;

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Displaying available cinemas
        System.out.println("Welcome to Movie Ticket Booking System");
        System.out.println("Choose a cinema from the following:");
        System.out.println("1. Cinema A");
        System.out.println("2. Cinema B");
        System.out.println("3. Cinema C");
        System.out.print("Enter your choice: ");
        int cinemaChoice = scanner.nextInt();
        
        // Displaying available movies at selected cinema
        System.out.println("\nAvailable movies at selected cinema:");
        switch (cinemaChoice) {
            case 1:
                System.out.println("1. Movie 1");
                System.out.println("2. Movie 2");
                break;
            case 2:
                System.out.println("1. Movie 3");
                System.out.println("2. Movie 4");
                break;
            case 3:
                System.out.println("1. Movie 5");
                System.out.println("2. Movie 6");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        System.out.print("Enter the movie number: ");
        int movieChoice = scanner.nextInt();
        
        // Asking for number of tickets
        System.out.print("\nEnter number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        
        double totalPrice = 0;
        
        // Asking for combo meals
        System.out.print("\nDo you need a combo? (yes/no): ");
        String comboChoice = scanner.next();
        if (comboChoice.equalsIgnoreCase("yes")) {
            // Displaying combo options with prices
            System.out.println("\nCombo options:");
            System.out.println("1. Burger, Cold Drink, Popcorn - Rs. 300");
            System.out.println("2. Burger, Cold Drink - Rs. 200");
            System.out.println("3. Popcorn, Cold Drink - Rs. 180");
            System.out.print("Enter combo choice: ");
            int comboOption = scanner.nextInt();
            switch (comboOption) {
                case 1:
                    System.out.println("You selected Burger, Cold Drink, Popcorn combo.");
                    totalPrice += 300;
                    break;
                case 2:
                    System.out.println("You selected Burger, Cold Drink combo.");
                    totalPrice += 200;
                    break;
                case 3:
                    System.out.println("You selected Popcorn, Cold Drink combo.");
                    totalPrice += 180;
                    break;
                default:
                    System.out.println("Invalid combo choice!");
                    return;
            }
        }
        
        // Asking for type of ticket
        System.out.println("\nSelect type of ticket:");
        System.out.println("1. Gold (Rs. 200)");
        System.out.println("2. Silver (Rs. 150)");
        System.out.println("3. Platinum (Rs. 250)");
        System.out.print("Enter ticket type: ");
        int ticketType = scanner.nextInt();
        
        double ticketPrice = 0;
        switch (ticketType) {
            case 1:
                ticketPrice = 200;
                break;
            case 2:
                ticketPrice = 150;
                break;
            case 3:
                ticketPrice = 250;
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        // Selecting seat numbers
        System.out.println("\nSelect seat numbers (e.g., A1, B2, C3):");
        String[] seats = new String[numberOfTickets];
        for (int i = 0; i < numberOfTickets; i++) {
            boolean isSeatBooked;
            do {
                System.out.print("Enter seat number for ticket " + (i + 1) + ": ");
                String seat = scanner.next();
                isSeatBooked = isSeatAlreadyBooked(seats, seat);
                if (isSeatBooked) {
                    System.out.println("This seat is already booked. Please choose another seat.");
                } else {
                    seats[i] = seat;
                }
            } while (isSeatBooked);
        }
        
        // Calculating total price for tickets
        totalPrice += numberOfTickets * ticketPrice;
        
        // Displaying total price
        System.out.println("\nPrice for one ticket: Rs. " + ticketPrice);
        System.out.println("Total Price for " + numberOfTickets + " tickets: Rs. " + (numberOfTickets * ticketPrice));
        System.out.println("Total Combo Price: Rs. " + (totalPrice - (numberOfTickets * ticketPrice)));
        System.out.println("Total Price (including combo): Rs. " + totalPrice);
        
        // Confirming booking
        System.out.print("Confirm booking? (yes/no): ");
        String confirmation = scanner.next();
        if (confirmation.equalsIgnoreCase("yes")) {
            // Displaying tickets
            System.out.println("\nTickets booked successfully!");
            System.out.println("Movie: Movie " + movieChoice);
            System.out.println("Seat Numbers:");
            for (String seat : seats) {
                System.out.println(seat);
            }
            System.out.println("Auditorium No: " + cinemaChoice);
            System.out.println("Total Price (including combo): Rs. " + totalPrice);
        } else {
            System.out.println("Booking cancelled!");
        }
        
        scanner.close();
    }
    
    // Method to check if a seat is already booked
    private static boolean isSeatAlreadyBooked(String[] seats, String seat) {
        for (String bookedSeat : seats) {
            if (seat.equalsIgnoreCase(bookedSeat)) {
                return true;
            }
        }
        return false;
    }
}