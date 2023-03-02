package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Meal save(Meal meal, int userId) {
        User ref = entityManager.getReference(User.class, userId);
        meal.setUser(ref);
        if (meal.isNew()) {
            entityManager.persist(meal);
            return meal;
        } else {
        return entityManager.merge(meal);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        try {
            User ref = entityManager.getReference(User.class, userId);
            Meal meal = entityManager.getReference(Meal.class, id);
            meal.setUser(ref);
            entityManager.remove(meal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Meal get(int id, int userId) {
        Meal meal = entityManager.getReference(Meal.class, id);
        User user = entityManager.getReference(User.class, userId);
        meal.setUser(user);
        return meal;
    }

    @Override
    public List<Meal> getAll(int userId) {
        List<Meal> result = new ArrayList<>();
        User user = entityManager.getReference(User.class, userId);
        //result = entityManager.createNamedQuery("Meal.getAll", Meal.class).getResultList();
        return null;
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return null;
    }
}