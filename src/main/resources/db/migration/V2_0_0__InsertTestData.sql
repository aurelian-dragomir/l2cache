insert into car_dealer(id, name) values
    (1, 'targoviste'),
    (2, 'bucuresti'),
    (3 , 'brasov');

insert into brand(id, name, car_dealer_id) values
    (1, 'dacia', 1),
    (2, 'renault', 1),
    (3,'alfa romeo',1),
    (4,'bmw',2),
    (5,'audi',2);

insert into car(id, model, brand_id) values
    (1, 'duster', 1),
    (2, 'megane', 2),
    (3, 'giulieta', 3),
    (4, 'm4', 3),
    (5, 's7', 4);
