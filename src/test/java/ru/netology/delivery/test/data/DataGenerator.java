package ru.netology.delivery.test.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate possibleDate = LocalDate.now().plusDays(shift);
        String date = possibleDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        var cities = new String[] { "Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск",
                "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный",
                "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск",
                "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж", "Иваново", "Иркутск",
                "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Магадан", "Красногорск", "Мурманск",
                "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань",
                "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск",
                "Ярославль", "Москва", "Санкт-Петербург", "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};
        return cities [new Random().nextInt(cities.length)];
    }
    public static String generateCityNoVal() {
        var citiesNoVal = new String[] { "Череповец", "Улан-Удэ", "Вашингтон", "123.0", " ", "!@#"};
        return citiesNoVal [new Random().nextInt(citiesNoVal.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }
    public static String generateNameWithEBrief(String locale) {
        var nameWishEBrief = new String[] {"Кизляр Ерёма", "Ёжиков Семён", "Егорова Фёкла", "Берёзов Алексей",
                "Фёдорова Василиса", "Кандратов Стёпа"};
        return nameWishEBrief [new Random().nextInt(nameWishEBrief.length)];
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateCityNoVal(), generateName(locale), generateNameWithEBrief(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String citiesNoVal;
        String name;
        String nameWishEBrief;
        String phone;
    }
}
