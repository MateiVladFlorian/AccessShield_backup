CREATE TABLE account (
    Id SERIAL PRIMARY KEY,
    UserName VARCHAR(80) UNIQUE NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) UNIQUE NOT NULL,
    CNP VARCHAR(13) UNIQUE NOT NULL CHECK (CNP ~ '^[0-9]{13}$'),
    Location VARCHAR(100),
    Status VARCHAR(8) CHECK (Status IN ('activ', 'inactiv')),
    DateTimeConnected TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_roles (
    user_role_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,  -- ID-ul utilizatorului
    role VARCHAR(50) CHECK (role IN ('admin', 'quest')) NOT NULL,  -- Rolul utilizatorului
    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE -- Legătura către tabelul conturilor
);

CREATE TABLE user_identifier (
    user_identifier_id SERIAL PRIMARY KEY,
    account_id INTEGER REFERENCES account(Id) ON DELETE CASCADE,
    user_code TEXT NOT NULL UNIQUE
);

CREATE TABLE user_profile (
    id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    image_profile TEXT NOT NULL,
    name VARCHAR(255) NOT NULL,
    country TEXT NOT NULL,
    number_phone TEXT NOT NULL,
    description TEXT,
    FOREIGN KEY (account_id) REFERENCES account(Id)
);

CREATE TABLE building (
    id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    count_rooms INTEGER NOT NULL CHECK (count_rooms > 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    access_key VARCHAR(50) NOT NULL UNIQUE,
    address_location VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(Id)
);

CREATE TABLE rooms (
    room_id SERIAL PRIMARY KEY,  -- ID-ul unic al camerei
    build_id INTEGER NOT NULL,  -- ID-ul locației de cazare la care aparține camera
    room_number VARCHAR(50) NOT NULL,  -- Numărul sau identificatorul camerei
    room_type VARCHAR(50),  -- Tipul camerei (ex: "single", "double", "suite")
    capacity INTEGER,  -- Capacitatea camerei (ex: 2 persoane)
    status VARCHAR(20) CHECK (status IN ('available', 'occupied', 'under_maintenance')),  -- Statusul camerei
    FOREIGN KEY (build_id) REFERENCES building(Id)
);
CREATE TABLE billing_info (
    billing_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    billing_address TEXT NOT NULL,
    card_type VARCHAR(50) NOT NULL, -- ex: 'Visa', 'Mastercard'
    card_number VARCHAR(70) NOT NULL, -- Numărul cardului, criptat
    expiry_date DATE NOT NULL,

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE
);
CREATE TABLE transaction_audit_logs (
    audit_id SERIAL PRIMARY KEY,
    action_type VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    details TEXT,
    performed_by INTEGER NOT NULL,
    billing_id INTEGER NOT NULL,

    FOREIGN KEY (performed_by) REFERENCES account(Id) ON DELETE SET NULL,
    FOREIGN KEY (billing_id) REFERENCES billing_info(billing_id) ON DELETE CASCADE
);
CREATE TABLE payment_gateways (
    gateway_id SERIAL PRIMARY KEY,
    gateway_name VARCHAR(100) NOT NULL,
    api_url TEXT NOT NULL,
    status VARCHAR(20) CHECK (status IN ('activ', 'inactiv')) NOT NULL,
    supported_currencies TEXT NOT NULL,
    transaction_fee NUMERIC(10, 2) NOT NULL,
    integration_date DATE NOT NULL
);
CREATE TABLE transactions (
    transaction_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    audit_id INTEGER NOT NULL,
    gateway_id INTEGER NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50), -- ex: 'card de credit', 'PayPal'
    status VARCHAR(20) CHECK (status IN ('finalizat', 'în așteptare', 'anulat')),

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,
    FOREIGN KEY (audit_id) REFERENCES transaction_audit_logs(audit_id),
    FOREIGN KEY (gateway_id) REFERENCES payment_gateways(gateway_id)
);
CREATE TABLE reservations (
    reservation_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    billing_id INTEGER NOT NULL,
    check_in TIMESTAMP NOT NULL,
    check_out TIMESTAMP NOT NULL,
    status VARCHAR(50) CHECK (status IN ('pending', 'confirmed', 'cancelled')) NOT NULL,

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (billing_id) REFERENCES billing_info(billing_id)
);

CREATE TABLE booking (
    booking_id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    check_in TIMESTAMP NOT NULL,
    check_out TIMESTAMP NOT NULL,
    status VARCHAR(50) CHECK (status IN ('pending', 'confirmed', 'cancelled')) NOT NULL,

    FOREIGN KEY (account_id) REFERENCES account(Id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
