package service;

import dao.CarDao;
import entity.Car;

public class CarService {
    public void save(Car car) {
        CarDao carDao = new CarDao();
        carDao.save(car);
    }
}
