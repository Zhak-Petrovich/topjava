package ru.javawebinar.topjava;

import org.assertj.core.api.Assertions;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;

public class MealTestData {
   public static final Meal BREAKFAST = new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
   public static final Meal LUNCH = new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
   public static final Meal DINNER = new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);


   public static Meal getNew() {
       return new Meal(null, LocalDateTime.now(), "new", 1000);
   }
   public static Meal updated() {
       Meal meal = new Meal(BREAKFAST);
       meal.setDateTime(LocalDateTime.now());
       meal.setDescription("updated");
       meal.setCalories(1500);
       return meal;
   }
   public static void assertMatch(Meal actual, Meal expected) {
       Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
   }

}
