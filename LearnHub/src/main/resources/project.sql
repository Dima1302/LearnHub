-- Создание таблицы users
CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    roles TEXT[] -- Добавленный столбец для хранения ролей пользователей
    );

-- Создание таблицы messages
CREATE TABLE IF NOT EXISTS messages (
                                        id SERIAL PRIMARY KEY,
                                        content TEXT NOT NULL,
                                        sender_id INT NOT NULL,
                                        receiver_id INT NOT NULL,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (sender_id) REFERENCES users (id),
    FOREIGN KEY (receiver_id) REFERENCES users (id)
    );

-- Создание таблицы categories
CREATE TABLE IF NOT EXISTS categories (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(50) NOT NULL
    );

-- Создание таблицы recommendations
CREATE TABLE IF NOT EXISTS recommendations (
                                               id SERIAL PRIMARY KEY,
                                               title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id)
    );

-- Создание таблицы badges
CREATE TABLE IF NOT EXISTS badges (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(100) NOT NULL
    );

-- Создание таблицы achievements
CREATE TABLE IF NOT EXISTS achievements (
                                            id SERIAL PRIMARY KEY,
                                            name VARCHAR(100) NOT NULL
    );

-- Создание таблицы progress
CREATE TABLE IF NOT EXISTS progress (
                                        id SERIAL PRIMARY KEY,
                                        user_id INT NOT NULL,
                                        category_id INT NOT NULL,
                                        recommendation_id INT NOT NULL,
                                        FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (recommendation_id) REFERENCES recommendations (id)
    );
