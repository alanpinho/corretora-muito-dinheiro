INSERT INTO tb_customer(name) VALUES ('João da Silva');
INSERT INTO tb_customer(name) VALUES ('Ana Vitória');
INSERT INTO tb_customer(name) VALUES ('Fernanda Pereira');

INSERT INTO tb_operation(currency_In,currency_Out,operation_Date,original_Price, converted_Price, service_Bill, customer_id) VALUES ('BRL','USD','2021-03-26', 1000.00, 189.70, 0.1, 2);
INSERT INTO tb_operation(currency_In,currency_Out,operation_Date,original_Price, converted_Price, service_Bill, customer_id) VALUES ('JPY','USD', '2020-03-01', 250000.00, 2371.92, 0.1, 1);

INSERT INTO tb_currency(name, code, price_Quote) VALUES ('Dolar Americano','USD', 5.27);
INSERT INTO tb_currency(name, code, price_Quote) VALUES ('Real Brasileiro','BRL', 1.00);
INSERT INTO tb_currency(name, code, price_Quote) VALUES ('Yen Japones','JPY', 0.05);
INSERT INTO tb_currency(name, code, price_Quote) VALUES ('Zloty Polones','PLN', 1.40);
INSERT INTO tb_currency(name, code, price_Quote) VALUES ('Euro','EUR', 6.40);