print("Hello, I'm a barbershop bot.")
reg = input("Write 'Start' if you want to continue: ")

while reg != "Start":
    if reg != "Start":
        reg = input("Sorry, I don't understand you. Write 'Start' ")
    elif reg == "Start":
        print("Great. Let's start.")
        break

Arai = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]
Anton = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]
Alikhan = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]

command = -1
while(command != 0):
    print("There are 3 barbers:\n 1)Arai\n 2)Anton\n 3)Alikhan")
    barber = int(input("Choose your barber: "))
    if barber == 1:
        print("He has this schedule: ")
        for i in range(8):
            print((i+1),") ", Arai[i])
        time = int(input("Choose time that suits you: "))
        if Arai[time-1] == "busy":
            print("Choose another time or barber")
        else:
            print("You made an appointment with Arai at " + Arai[time-1])
            Arai[time-1] = "busy"

    if barber == 2:
        print("He has this schedule: ")
        for i in range(8):
            print((i+1),") ", Anton[i])
        time = int(input("Choose time that suits you: "))
        if Anton[time-1] == "busy":
            print("Choose another time or barber")
        else:
            print("You made an appointment with Arai at " + Anton[time-1])
            Anton[time-1] = "busy"

    if barber == 3:
        print("He has this schedule: ")
        for i in range(8):
            print((i+1),") ", Alikhan[i])
        time = int(input("Choose time that suits you: "))
        if Alikhan[time-1] == "busy":
            print("Choose another time or barber")
        else:
            print("You made an appointment with Arai at " + Alikhan[time-1])
            Alikhan[time-1] = "busy"
        
