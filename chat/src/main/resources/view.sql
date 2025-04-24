CREATE VIEW IF NOT EXISTS user_message_view AS (
    SELECT u.id AS user_id, m.id AS message_id, m.content, m.timestamp
    FROM users u
    JOIN messages m ON u.id = m.sender_id
)