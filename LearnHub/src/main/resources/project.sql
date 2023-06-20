CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
    -- Дополнительные поля пользователя
);

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
    -- Дополнительные поля категорий
);

CREATE TABLE sections (
                          id SERIAL PRIMARY KEY,
                          category_id INT NOT NULL,
                          name VARCHAR(255) NOT NULL,
    -- Дополнительные поля разделов
                          FOREIGN KEY (category_id) REFERENCES categories (id)
);

-- Создайте таблицы для остальных моделей данных по аналогии

CREATE TABLE recommendations (
                                 id SERIAL PRIMARY KEY,
                                 section_id INT NOT NULL,
                                 name VARCHAR(255) NOT NULL,
    -- Дополнительные поля рекомендаций
                                 FOREIGN KEY (section_id) REFERENCES sections (id)
);

CREATE TABLE exercises (
                           id SERIAL PRIMARY KEY,
                           section_id INT NOT NULL,
                           name VARCHAR(255) NOT NULL,
    -- Дополнительные поля упражнений
                           FOREIGN KEY (section_id) REFERENCES sections (id)
);

CREATE TABLE user_progress (
                               id SERIAL PRIMARY KEY,
                               user_id INT NOT NULL,
                               recommendation_id INT NOT NULL,
    -- Дополнительные поля прогресса пользователя
                               FOREIGN KEY (user_id) REFERENCES users (id),
                               FOREIGN KEY (recommendation_id) REFERENCES recommendations (id)
);

-- Добавьте индексы и ограничения по необходимости
