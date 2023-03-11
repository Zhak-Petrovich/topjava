package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Transactional
    Boolean deleteByIdAndUserId(int id, int userId);
    Meal getMealByIdAndUserId(int id, int userId);
    List<Meal> getAll(int userId);
    List<Meal> getMealByDateBetweenAndUserId(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
