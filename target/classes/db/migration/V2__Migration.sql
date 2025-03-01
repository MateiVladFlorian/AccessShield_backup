CREATE TABLE payments (
    payment_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,  -- ID-ul utilizatorului care a efectuat plata
    reservation_id INTEGER NOT NULL,  -- ID-ul rezervării asociate
    audit_id INTEGER NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,  -- Suma plătită
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data plății
    payment_status VARCHAR(50) CHECK (payment_status IN ('paid', 'pending', 'failed')) NOT NULL,  -- Statusul plății

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,  -- Legătura către tabelul conturilor
    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id) ON DELETE CASCADE, -- Legătura către tabelul rezervărilor
    FOREIGN KEY (audit_id) REFERENCES transaction_audit_logs(audit_id)
);
CREATE TABLE room_services (
    service_id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL,  -- ID-ul camerei care a beneficiat de serviciu
    service_type VARCHAR(50) NOT NULL,  -- Tipul serviciului (ex: curățenie, room service)
    service_description TEXT,  -- Descrierea detaliată a serviciului
    service_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data și ora serviciului
    FOREIGN KEY (room_id) REFERENCES rooms(room_id) -- Legătura către tabelul camerelor
);

CREATE TABLE maintenance_logs (
    maintenance_id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL,  -- ID-ul camerei care a necesitat întreținere
    maintenance_type VARCHAR(50) NOT NULL,  -- Tipul întreținerii (ex: reparație, revizie)
    description TEXT,  -- Descrierea întreținerii
    maintenance_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data întreținerii
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)  -- Legătura către tabelul camerelor
);
CREATE TABLE users_sessions (
    session_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    device_id VARCHAR(255) NOT NULL, -- Identificator unic pentru dispozitiv (opțional)
    last_activity TIMESTAMP NOT NULL, -- Ultima activitate a utilizatorului
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Momentul creării sesiunii
    is_active BOOLEAN DEFAULT TRUE, -- Indică dacă sesiunea este activă
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);
CREATE TABLE notification_events (
    event_id SERIAL PRIMARY KEY,
    event_type VARCHAR(50) NOT NULL,
    event_description TEXT,
    priority VARCHAR(20) CHECK (priority IN ('scăzută', 'medie', 'ridicată')) NOT NULL,
    default_notification_message TEXT NOT NULL
);
-- Tabel pentru notificările trimise utilizatorilor
CREATE TABLE notifications (
    notification_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    event_id INTEGER NOT NULL,
    message TEXT NOT NULL,
    notification_type VARCHAR(50), -- ex: 'rezervare', 'alertă mentenanță'
    status VARCHAR(20) CHECK (status IN ('trimis', 'citit')),
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES notification_events(event_id)
);
-- Tabel pentru recenziile lăsate de utilizatori
CREATE TABLE reviews (
    review_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    rating INTEGER CHECK (rating >= 1 AND rating <= 5), -- Rating de la 1 la 5
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);

CREATE TABLE access_room (
    access_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,  -- ID-ul utilizatorului care a încercat să acceseze camera
    room_id INTEGER NOT NULL,  -- ID-ul camerei sau locației accesate
    access_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timpul în care utilizatorul a încercat să acceseze camera
    exit_time TIMESTAMP,  -- Timpul când utilizatorul a părăsit camera (poate fi NULL dacă nu a părăsit încă)
    access_granted BOOLEAN NOT NULL,  -- Indică dacă accesul a fost permis sau nu
    access_reason VARCHAR(255),  -- Motivul accesului (de exemplu, rezervare, vizită etc.)
    status VARCHAR(50) CHECK (status IN ('active', 'inactive')),  -- Statusul accesului (de exemplu, "active" sau "inactive")

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,  -- Legătura către tabelul conturilor
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)  -- Legătura către tabelul camerelor
);
