student_grades = {}
grade_prompt = "Enter the name and the grade the student earned: "
del_prompt = "Enter a student name to delete"
menu_prompt = ("1. Add student grade\n"
             "2. Delete student grade\n"
             "3. Print student grade\n"
             "4. Exit the app")

while True:
    command = input(menu_prompt).lower().strip()
    if command == "1":
        name, grade = input(grade_prompt).split()
        student_grades[name] = grade