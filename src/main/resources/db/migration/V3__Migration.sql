CREATE TABLE access_logs (
    log_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    access_id INTEGER NOT NULL,
    access_time TIMESTAMP NOT NULL,
    exit_time TIMESTAMP,
    access_granted BOOLEAN NOT NULL,
    status VARCHAR(50),
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);

CREATE TABLE audit_logs (
    log_id SERIAL PRIMARY KEY,  -- SERIAL este folosit pentru autoincrementare în PostgreSQL
    account_id INTEGER NOT NULL,  -- ID-ul utilizatorului care a efectuat acțiunea
    reservation_id INTEGER NOT NULL,
    action TEXT NOT NULL,  -- Descrierea acțiunii efectuate
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data și ora acțiunii
    ip_address VARCHAR(50) NOT NULL,  -- Adresa IP a utilizatorului
    user_agent TEXT,  -- Detalii despre browser și dispozitivul utilizatorului

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);

CREATE TABLE rooms_amenities (
    room_id INTEGER NOT NULL,
    amenity_id SERIAL PRIMARY KEY,
    amenity_name VARCHAR(100) NOT NULL, -- ex: 'Wi-Fi', 'Piscină', 'Parcare'
    description TEXT,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

-- Tabel pentru log-urile evenimentelor aplicației
CREATE TABLE event_logs (
    event_id SERIAL PRIMARY KEY,
    event_type VARCHAR(100), -- Tipul evenimentului, ex: 'eroare', 'modificare status'
    event_details TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Tabel pentru log-urile de securitate
CREATE TABLE security_logs (
    log_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    event_type VARCHAR(100) NOT NULL, -- ex: 'încercare acces nereușită'
    event_details TEXT,
    event_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);
