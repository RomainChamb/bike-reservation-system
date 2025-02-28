CREATE TABLE Bike (
                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                      name VARCHAR(255) NOT NULL,
                      type VARCHAR(255),
                      status VARCHAR(255),
                      size VARCHAR(50),
                      next_availability_date TIMESTAMP,
                      city VARCHAR(255)
);
