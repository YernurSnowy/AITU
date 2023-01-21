#import the library for working with databases 
import sqlite3 

#establishing a connection to the database
with sqlite3.connect("telephone.db") as db:
    #create a cursor for working with tables
    cursor = db.cursor()

    #create a person table
    cursor.execute("""CREATE TABLE IF NOT EXISTS persons(
        PersonID INTEGER PRIMARY KEY,
        PersonName TEXT,
        PersonAge INTEGER
    )""")

    #create a location table
    cursor.execute("""CREATE TABLE IF NOT EXISTS locations(
        LocationID INTEGER PRIMARY KEY,
        City TEXT,
        Adress TEXT
    )""")
    
    #create a main table
    cursor.execute("""CREATE TABLE IF NOT EXISTS directory(
        PhoneID INTEGER PRIMARY KEY,
        Number INTEGER,
        LocationID INTEGER NOT NULL,
        PersonID INTEGER NOT NULL,
        FOREIGN KEY(LocationID) REFERENCES locations(LocationID),
        FOREIGN KEY(PersonID) REFERENCES persons(PersonID)
        )""")




#crate a function to register a number
def registration_number():

    read()
    number = int(input("Number: "))

    try:
        
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of a number
        cursor.execute("SELECT Number FROM directory WHERE Number = ?", [number])
        if cursor.fetchone() is None:

            id = int(input("ID: "))

            #if there is no entry with the entered number, then we log this request
            cursor.execute("INSERT INTO directory(Number, PersonID, LocationID) VALUES(?, ?, ?)", [number, id, id])

            #save changes
            db.commit()

            registration_persons()
            registration_locations()

            print("Number successfully added to the list!!!")

        #else we start the process again
        else:
            print("This number is already registered")
            registration_number()

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()




#crate a function to register a person
def registration_persons():
    name = input("Enter name: ")
    age = int(input("Enter age: "))

    try:

        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #entering data into a table
        cursor.execute("INSERT INTO persons(PersonName, PersonAge) VALUES(?, ?)", [name, age])

        #save changes
        db.commit()

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()




#create a function to register a location
def registration_locations():
    city = input("Enter city: ")
    adress = input("Enter adress: ")

    try: 

        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #entering data into a table
        cursor.execute("INSERT INTO locations(City, Adress) VALUES(?, ?)", [city, adress])
        
        #save changes
        db.commit()

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()




#creat a functon to read a table
def read():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of records
        cursor.execute("SELECT PhoneID FROM directory")
        if cursor.fetchone() is None:
            print("Table is empty")

        else:

            print("ID |Number | Name | Age | City| Adress")

            #show a table
            for data in cursor.execute("""
            SELECT directory.PhoneID, directory.Number, persons.PersonName, persons.PersonAge, locations.City, locations.Adress
            FROM ((directory 
            LEFT JOIN persons ON directory.PersonID = persons.PersonID)
            LEFT JOIN locations ON directory.LocationID = locations.LocationID)"""):
                print(data)

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()




#creat a function to edit a record
def update():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()
        
        #call a function "read" to show a table
        read()

        #ask what record user want to edit
        print("What record do you want to edit?")
        record = int(input("Choose an id of a record: "))

        #checking for the existence of an id
        cursor.execute("SELECT PhoneID FROM directory WHERE PhoneID = ?", [record])
        if cursor.fetchone() is None:
            print("The id you entered does not exist")

        else:
            #enter new reocrds
            newnumber = int(input("New number: "))
            newname = input("New name: ")
            newage = input("New age: ")
            newcity = input("New city: ")
            newadress = input("New adress: ")

            #change records in "directory" table
            cursor.execute("""UPDATE directory SET 
            Number = ?
            WHERE PhoneID = ?""", [newnumber, record]
            )

            #change records in "persons" table
            cursor.execute("""UPDATE persons SET
            PersonName = ?,
            PersonAge = ?
            WHERE PersonID = ?""", [newname, newage, record]
            )

            #change records in "locations" table
            cursor.execute("""UPDATE locations SET
            City = ?,
            Adress = ?
            WHERE LocationID = ?""", [newcity, newadress, record]
            ) 

            #Write about update
            print("Record successfully updated!")

            #save changes
            db.commit()

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()



#creat a function to delete a record
def delete():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()
        
        #call a function "read" to show a table
        read()

        #ask what record user want to delete
        print("What record do you want to delete?")
        record = int(input("Choose an id of a record: "))
        
        #checking for the existence of a number
        cursor.execute("SELECT PhoneID FROM directory WHERE PhoneID = ?", [record])
        if cursor.fetchone() is None:
            print("The id you entered does not exist")

        else:
            #delete a record from "directory" table
            cursor.execute("DELETE FROM directory WHERE PhoneID = ?",[record])

            #delete a record from "persons" table
            cursor.execute("DELETE FROM persons WHERE PersonID = ?",[record])

            #delete a record from "location" table
            cursor.execute("DELETE FROM locations WHERE LocationID = ?",[record])
            print("Post deleted successfully!!!")

            #save changes
            db.commit()

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()



#create a function 
def sorting():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of records
        cursor.execute("SELECT PhoneID FROM directory")
        if cursor.fetchone() is None:
            print("Table is empty")

        else:

            command = int(input("1)In ascending order\n2)In descending order\n"))
            
            if command == 1:
                #show a table in ascending order
                print("ID |Number | Name | Age | City| Adress")
                for data in cursor.execute("""
                SELECT directory.PhoneID, directory.Number, persons.PersonName, persons.PersonAge, locations.City, locations.Adress
                FROM ((directory 
                LEFT JOIN persons ON directory.PersonID = persons.PersonID)
                LEFT JOIN locations ON directory.LocationID = locations.LocationID)
                ORDER BY directory.Number
                """):
                    print(data)

            elif command == 2:
                #show a table in descending order
                print("ID |Number | Name | Age | City| Adress")
                for data in cursor.execute("""
                SELECT directory.PhoneID, directory.Number, persons.PersonName, persons.PersonAge, locations.City, locations.Adress
                FROM ((directory 
                LEFT JOIN persons ON directory.PersonID = persons.PersonID)
                LEFT JOIN locations ON directory.LocationID = locations.LocationID)
                ORDER BY directory.Number DESC
                """):
                    print(data)

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()



#creat a functon to filter a table
def filtering():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of records
        cursor.execute("SELECT PhoneID FROM directory")
        if cursor.fetchone() is None:
            print("Table is empty")

        else:

            city = input("Choose city: ")

            print("ID |Number | Name | Age | City| Adress")

            #show reocrds with entered city
            for data in cursor.execute("""
            SELECT directory.PhoneID, directory.Number, persons.PersonName, persons.PersonAge, locations.City, locations.Adress
            FROM ((directory 
            LEFT JOIN persons ON directory.PersonID = persons.PersonID)
            LEFT JOIN locations ON directory.LocationID = locations.LocationID)
            WHERE locations.City = ?""", [city]
            ):
                print(data)

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()



#creat a functon to search a phone number
def search():
    try:
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of records
        cursor.execute("SELECT PhoneID FROM directory")
        if cursor.fetchone() is None:
            print("Table is empty")

        else:

            number = int(input("Number: "))

            print("ID |Number | Name | Age | City| Adress")

            #show record with entered phone number
            for data in cursor.execute("""
            SELECT directory.PhoneID, directory.Number, persons.PersonName, persons.PersonAge, locations.City, locations.Adress
            FROM ((directory 
            LEFT JOIN persons ON directory.PersonID = persons.PersonID)
            LEFT JOIN locations ON directory.LocationID = locations.LocationID)
            WHERE directory.Number = ?""", [number]):
                print(data)

    #if there are an error, we report it      
    except sqlite3.Error as e:
        print("Error", e)

    #close the connection to the database and the cursor
    finally:
        cursor.close()
        db.close()



#create a main function
def main():

    #user greeting
    print("Hello, it's a Telephone directory database")

    while True:
        
        #choose a command
        command = int(input("""
What do you want to do?
1) Register new number
2) See what entries are
3) Update a table
4) Delete a record
5) Sort a table
6) Filtering by city
7) Search a phone number
8) Stop working\n
"""))

        if command == 1:
            registration_number()

        elif command == 2:
            read()
        
        elif command == 3:
            update()
        
        elif command == 4:
            delete()
        
        elif command == 5:
            sorting()

        elif command == 6:
            filtering()

        elif command == 7:
            search()

        elif command == 8:
            print("See you later)")
            break


#call the function "main"
main()