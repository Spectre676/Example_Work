class Seat:
    def __init__(self):
        self.first_name = " "
        self.last_name = " "
        self.paid = 0.0

    def reserve(self, f_name, l_name, amt_paid):
        self.first_name = f_name
        self.last_name = l_name
        self.paid = amt_paid

    def make_empty(self):
        self.first_name = " "
        self.last_name = " "
        self.paid = 0.0

    def is_empty(self):
        return self.first_name == " "

    def print_seat(self):
        print(f'{self.first_name} {self.last_name}, Paid: {self.paid:.2f}')
    
    def make_seats_empty(seats):
        for s in seats:
            s.make_empty()

    def print_seats(seats):
        for i in range(len(seats)):
            print(f"{i}: ", end = "")
            seats[i].print_seats()    



num_seats = 5
available_seats = []

for i in range(num_seats):
    available_seats.append(Seat())

command = input("Enter command: ((p)rint seats, (r)eserve seats or (q)uit the app):\n")

while command != "q":
    if command == "p":
        print_seats(available_seats)
    elif command == "r":
        seat_num = int(input("Enter the seat number you want to reserve:\n"))
        if not available_seats[seat_num].is_empty:
            print("The seat you requested is not available.")
        else:
            fname = input("Enter your first name:\n")
            lname = input("Enter your last name:\n")
            paid = float(input("Enter the amount of deposit:\n"))
            available_seats[seat_num].reserve(fname, lname, paid)
    else:
        print("Invalid command entered.")

command = input("Enter command (p)rint seats, (r)eserve seats or (q)uit the app:\n")

