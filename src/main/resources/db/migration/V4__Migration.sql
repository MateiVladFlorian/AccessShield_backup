-- Tabel pentru promoțiile disponibile
CREATE TABLE promotions (
    promotion_id SERIAL PRIMARY KEY,
    promo_code VARCHAR(50) UNIQUE NOT NULL,
    account_id INTEGER NOT NULL,
    description TEXT,
    discount_percentage DECIMAL(5, 2), -- Discount-ul în procente
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    max_uses INTEGER CHECK (max_uses > 0), -- Limitează numărul de utilizări
    uses_count INTEGER DEFAULT 0 CHECK (uses_count <= max_uses),
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);
-- Tabel pentru istoricul rezervărilor
CREATE TABLE reservations_history (
    history_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    reservation_id INTEGER NOT NULL,
    action VARCHAR(50) CHECK (action IN ('creat', 'modificat', 'anulat')),
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (account_id) REFERENCES account(Id),
    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id) ON DELETE CASCADE
);

-- Tabel pentru metodele de plată

CREATE TABLE payment_methods (
    method_id SERIAL PRIMARY KEY,
    payment_id INTEGER NOT NULL,
    method_name VARCHAR(100) NOT NULL, -- ex: 'card de credit', 'PayPal'
    description TEXT,
    FOREIGN KEY (payment_id) REFERENCES payments(payment_id)
);
CREATE TABLE room_access_cards (
    card_id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL,  -- ID-ul camerei la care cardul oferă acces
    account_id INTEGER NOT NULL,  -- ID-ul utilizatorului care a primit cardul
    card_code VARCHAR(255) UNIQUE NOT NULL,  -- Codul cardului de acces
    issue_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data emiterii cardului
    expiration_date TIMESTAMP,  -- Data expirării cardului (dacă este cazul)
    is_active BOOLEAN DEFAULT TRUE,  -- Indică dacă cardul este activ

    FOREIGN KEY (room_id) REFERENCES rooms(room_id),  -- Legătura cu tabelul camerelor
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE -- Legătura cu tabelul utilizatorilor
);
