CREATE DATABASE invoice_db;

CREATE TABLE Client (
id BIGINT  PRIMARY KEY
,    nom VARCHAR(255)
,    prenom VARCHAR(255)
,    adresse VARCHAR(255)
,    email VARCHAR(255)
,    telephone VARCHAR(255)
);

CREATE TABLE Produit (
id BIGINT  PRIMARY KEY
,    designation VARCHAR(255)
,    prixUnitaire DECIMAL(19, 2)
,    Description VARCHAR(255)
);

CREATE TABLE EnteteFact (
     id BIGINT  PRIMARY KEY
,    numeroFacture BIGINT
,    dateFacture DATE
,    modePaiement VARCHAR(255)
,    statut VARCHAR(255)
,    client_id BIGINT,
FOREIGN KEY (client_id) REFERENCES Client(id)
);

CREATE TABLE DetFacture (
      id BIGINT  PRIMARY KEY
,     quantite BIGINT
,     prixUnitaire DECIMAL(19, 2)
,     montantTotalParProduit DECIMAL(19, 2)
,     produit_id BIGINT
,     facture_id BIGINT,
FOREIGN KEY (produit_id) REFERENCES Produit(id),
FOREIGN KEY (facture_id) REFERENCES EnteteFact(id)
);



INSERT INTO Client (id, nom, prenom, adresse, email, telephone) VALUES
                    (1, 'John', 'Doe', '123 Main St', 'john.doe@example.com', '123-456-7890'),
                    (2, 'Jane', 'Doe', '456 Maple Ave', 'jane.doe@example.com', '987-654-3210');

INSERT INTO Produit (id, designation, prixUnitaire, Description) VALUES
                    (1, 'Product 1', 10.00, 'This is product 1'),
                    (2, 'Product 2', 20.00, 'This is product 2');

INSERT INTO EnteteFact (id, numeroFacture, dateFacture, modePaiement, statut, client_id) VALUES
                       (1, 1001, '2022-01-01', 'Cash', 'Paid', 1),
                       (2, 1002, '2022-01-02', 'Credit', 'Unpaid', 2);

INSERT INTO DetFacture (id, quantite, prixUnitaire, montantTotalParProduit, produit_id, facture_id) VALUES
                        (1, 2, 10.00, 20.00, 1, 1),
                        (2, 3, 20.00, 60.00, 2, 2);
