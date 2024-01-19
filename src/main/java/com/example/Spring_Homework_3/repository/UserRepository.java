package com.example.Spring_Homework_3.repository;

import com.example.Spring_Homework_3.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class UserRepository {
    // * Задание. Добавить базу данных H2. Добавить обработку регистрации пользователем Mapper через параметры (в браузере)
    // Создание базы данных. В папке resources в файле schema.sql указан первый SQL запрос для создания таблицы userTable
    private final JdbcTemplate jdbc;
//    private List<User> users = new ArrayList<>();

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Получение списка юзеров из базы данных
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    // Добавление юзера в базу данных
    public void add(User user) {
        String sql = "INSERT INTO userTable VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }


}