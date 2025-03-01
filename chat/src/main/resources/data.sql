-- Insert test users
INSERT INTO users (username) VALUES ('Alice');
INSERT INTO users (username) VALUES ('Bob');

-- Insert test chat groups
INSERT INTO chat_groups (name) VALUES ('Study Group');

-- Insert test messages
INSERT INTO messages (sender_id, group_id, content, timestamp)
VALUES (1, 1, 'Hello everyone!', CURRENT_TIMESTAMP);
