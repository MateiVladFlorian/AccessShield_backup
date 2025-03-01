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

CREATE TABLE feedback (
    feedback_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL UNIQUE,
    room_id INTEGER NOT NULL,
    staff_id INTEGER NOT NULL,
    reservation_id INTEGER NOT NULL,
    feedback_text TEXT NOT NULL,
    rating INTEGER CHECK (rating >= 1 AND rating <= 5),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);
CREATE OR REPLACE FUNCTION validate_feedback()
RETURNS TRIGGER AS $$
BEGIN
    -- Verifică dacă rating-ul este între 1 și 5
    IF NEW.rating < 1 OR NEW.rating > 5 THEN
        RAISE EXCEPTION 'Rating-ul trebuie să fie între 1 și 5';
    END IF;

    -- Verifică dacă feedback_text nu este gol
    IF NEW.feedback_text IS NULL OR TRIM(NEW.feedback_text) = '' THEN
        RAISE EXCEPTION 'Feedback-ul nu poate fi gol';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
-- Crează Trigger pentru Inserare și Actualizare
CREATE TRIGGER feedback_insert_update
BEFORE INSERT OR UPDATE ON feedback
FOR EACH ROW
EXECUTE FUNCTION validate_feedback();
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
