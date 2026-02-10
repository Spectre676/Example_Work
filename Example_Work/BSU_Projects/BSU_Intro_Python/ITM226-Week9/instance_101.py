class Payment: # The Parent Class
    def pay(self, amount):
        raise NotImplementedError("Ensuring that each payment type is unique and coded by the child classes")
    
class CreditCard(Payment): #CreditCard is a child class that inheriting from that parent class Payment
    def __init__(self, card_number):
        self.card_number = card_number

    def pay(self, amount):
        print(f'Paid ${amount} using Credit card no: {self.card_number}')

class PayPal(Payment): #PayPal is a child class that inheriting from that parent class Payment
    def __init__(self, email):
        self.email = email

    def pay(self, amount):
        print(f'Paid ${amount} using Credit card no: {self.email}')

def process_payment(payment_method, amount):
    payment_method.pay(amount)

credit_card_payment1 = CreditCard("234126") # credit card payment 1 is an obj created out of the CreditCard class
paypal_payment1 = PayPal("johnwick@gmail.edu") # paypal payment 1 is an obj created out of the PayPal class

process_payment(credit_card_payment1, 100)
process_payment(paypal_payment1, 50)