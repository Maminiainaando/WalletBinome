CREATE OR REPLACE FUNCTION calculer_solde(
    compte_id INT,
    date_debut TIMESTAMP,
    date_fin TIMESTAMP
)
RETURNS DECIMAL AS
$$
DECLARE
    solde DECIMAL;
BEGIN
    SELECT COALESCE(SUM(montant), 0) INTO solde
    FROM transactions
    WHERE compte_id = calculer_solde.compte_id
        AND date_transaction BETWEEN calculer_solde.date_debut AND calculer_solde.date_fin;
    RETURN solde;
END;
$$
LANGUAGE plpgsql;

SELECT calculer_solde(1, '2023-01-01', '2023-12-31') AS solde_resultat;

