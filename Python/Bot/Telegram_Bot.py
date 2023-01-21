import telebot
from telebot import types

bot = telebot.TeleBot("5924732374:AAEyyb-rElEH8dAzOeR4WeOsCMsyUhUyHyE", parse_mode=('html'))

Arai = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]
Anton = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]
Alikhan = ["10:00 - 10:50", "11:00 - 11:50", "12:00 - 12:50", "13:00 - 13:50", "14:00 - 14:50", "15:00 - 15:50", "16:00 - 16:50", "17:00 - 17:50"]
barber = 0


@bot.message_handler(commands=['start'])
def start(message):
    markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=1)
    Arai = types.KeyboardButton("/Arai")
    Anton = types.KeyboardButton("/Anton")
    Alikhan = types.KeyboardButton("/Alikhan")
    markup.add(Arai, Anton, Alikhan)
    bot.send_message(message.chat.id, "Hello, dear client. I'm a barbershop bot.\nChoose your barber:\n 1) <b>Arai</b>\n 2) <b>Anton</b>\n 3) <b>Alikhan</b>",reply_markup=markup)

@bot.message_handler(commands=['Arai'])
def get_answer_1(message_1):
    global barber
    barber = 1
    if(barber == 1):
        bot.send_message(message_1.chat.id, "He has this schedule: ")
        for i in range(8):
            bot.send_message(message_1.chat.id, str(i+1) + ") " + Arai[i])
        bot.send_message(message_1.chat.id, "Choose time that suits you")
        @bot.message_handler(content_types=['text'])
        def check_Arai(message_2):
            time = int(message_2.text)
            if Arai[time-1] == "busy":
                bot.send_message(message_2.chat.id, "Choose another barber or time")
            else:
                bot.send_message(message_2.chat.id, "You made an appointment with Arai at " + Arai[time-1])
                Arai[time-1]="busy"
                global barber
                barber = 0
                

@bot.message_handler(commands=['Anton'])
def get_answer_2(message_3):
    global barber
    barber = 2
    if(barber == 2):
        bot.send_message(message_3.chat.id, "He has this schedule: ")
        for i in range(8):
            bot.send_message(message_3.chat.id, str(i+1) + ") " + Anton[i])
        bot.send_message(message_3.chat.id, "Choose time that suits you")
        @bot.message_handler(content_types=['text'])
        def check_Anton(message_4):
            time = int(message_4.text)
            if Anton[time-1] == "busy":
                bot.send_message(message_4.chat.id, "Choose another barber or time")
            else:
                bot.send_message(message_4.chat.id, "You made an appointment with Anton at " + Anton[time-1])
                Anton[time-1]="busy"
                global barber
                barber = 0
                
    

@bot.message_handler(commands=['Alikhan'])
def get_answer_3(message_5):
    global barber
    barber = 3
    bot.send_message(message_5.chat.id, "He has this schedule: ")
    for i in range(8):
        bot.send_message(message_5.chat.id, str(i+1) + ") " + Alikhan[i])
    bot.send_message(message_5.chat.id, "Choose time that suits you")
    if(barber == 3):
        @bot.message_handler(content_types=['text'])
        def check_Alikhan(message_6):
            time = int(message_6.text)
            if Alikhan[time-1] == "busy":
                bot.send_message(message_6.chat.id, "Choose another barber or time")
            else:
                bot.send_message(message_6.chat.id, "You made an appointment with Alikhan at " + Alikhan[time-1])
                Alikhan[time-1]="busy"
                global barber
                barber = 0
    


        
        
bot.polling(non_stop=True)


