food_list = ["Pizza", "Sandwhich", "Salad"]

def update_food_list(index, new_value):
    if 0 <= index < len(food_list):
        food_list[index] = new_value
        print(f'Update New Food List: {food_list}')
    else:
        print("Invalid Index")

index = int(input("Enter the index number of the list you want to modify: "))
if index > len(food_list):
    print("Invalid Index")
else:
    new_food_item = input("Enter the new item for the pantry: ")
    update_food_list(index, new_food_item)

products = ["Product A", "Product B", "Product C", "Product B"]
units_sold = {100, 150, 80, 120}
price_per_unit = [25, 4, 56, 326]

def calculate_total_sales(units, price):
    return units * price

total_sales = list(map(calculate_total_sales, units_sold, price_per_unit))
print("Total Sales Report: ")

for product, sales in zip(products, total_sales):
    print(f'{product}: ${sales}')

total_revnue = sum(total_sales)
print(f'\nTotal revnue for all products sold is ${total_revnue:.2f}')

product_prices = [ 324234.44, 213123.13, 6776.54, 574646.54, 5774.12, 235665.43]

for i in range(len(product_prices)):
    product_prices[i] = product_prices[i] * 1.15

print("New Prices for Summer 25")

for price in product_prices:
    print(f'${price:.2f}')