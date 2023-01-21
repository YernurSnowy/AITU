#import the library for working with databases 
import sqlite3 

#establishing a connection to the database
with sqlite3.connect("telephone.db") as db:
    #create a cursor for working with tables
    cursor = db.cursor()

    #create a person table
    cursor.execute("""CREATE TABLE IF NOT EXISTS person(
        personID INTEGER PRIMARY KAY,

    )""")

    #create a location table
    cursor.execute("""CREATE TABLE IF NOT EXISTS location(
        locationID INTEGER PRIMARY KEY,
        city TEXT,
        adress TEXT
    )""")
    
    #create a main table
    cursor.execute("""CREATE TABLE IF NOT EXISTS directory(
        phoneID INTEGER PRIMARY KEY,
        number INTEGER,
        name TEXT,
        city TEXT,
        model TEXT
        )""")

#crate a function to register a number
def registration():
    number = int(input("Number: "))
    name = input("Name: ")
    city = input("City: ")
    model = input("Model: ")

    try:
        
        #connect with database
        db = sqlite3.connect("telephone.db")
        cursor = db.cursor()

        #checking for the existence of a number
        cursor.execute("SELECT number FROM directory WHERE number = ?", [number])
        if cursor.fetchone() is None:

            #if there is no entry with the entered number, then we log this request
            values = [number, name, city, model]
            cursor.execute("INSERT INTO directory(number, name, city, model) VALUES(?, ?, ?, ?)", values)
            print("Number successfully added to the list!!!")

            #save changes
            db.commit()

        #else we start the process again
        else:
            print("This number is already registered")
            registration()

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
        cursor.execute("SELECT id FROM directory")
        if cursor.fetchone() is None:
            print("Table is empty")

        else:
            #show a table
            for data in cursor.execute("SELECT * FROM directory"):
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
        cursor.execute("SELECT id FROM directory WHERE id = ?", [record])
        if cursor.fetchone() is None:
            print("The id you entered does not exist")

        else:
            #update a record
            newnumber = int(input("New number: "))
            newname = input("New name: ")
            newcity = input("New city: ")
            newmodel = input("New model: ")
            cursor.execute("""UPDATE directory SET 
            number = ?,
            name = ?,
            adress = ?,
            model = ?
            WHERE id = ?""",
            [newnumber, newname, newcity, newmodel, record]
            ) 
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
        cursor.execute("SELECT id FROM directory WHERE id = ?", [record])
        if cursor.fetchone() is None:
            print("The id you entered does not exist")

        else:
            #delete a record
            cursor.execute("DELETE FROM directory WHERE id = ?",[record])
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

#create a main function
def main():

    #user greeting
    print("Hello, it's a Telephone directory database")

    while True:
        
        #choose a command
        command = input("\nWhat do you want to do?\n1) Register new number\n2) See what entries are\n3) Update a table\n4) Delete a record\n5) Stop working\n\n")

        if command == "1) Register new number":
            registration()

        elif command == "2) See what entries are":
            read()

        elif command == "3) Update a table":
            update()

        elif command == "4) Delete a record":
            delete()

        elif command == "5) Stop working":
            print("See you later)")
            break

#call the function "main"
main()