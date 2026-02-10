class Book:
    def __init__(self, title, author, year_published=2021):
        self.title = title
        self.author = author
        self.year_published = year_published

    def display_info(self):
        print(f'{self.title} by {self.author}, published {self.year_published}')

book1 = Book("ABC FOR KIDS", "Emma", "2025")

book1.display_info()

class Fort_Event:
    def __init__(self, performer, venue, location):
        self.performer = performer
        self.venue = venue
        self.location = location

    def display_info(self):
        print(f'{self.performer} will be performing at {self.venue}, in the {self.location}')

music_fort_8pm_Sat = Fort_Event("Depeche Mode", "The Sub", "Boise State University")

music_fort_8pm_Sat.display_info()