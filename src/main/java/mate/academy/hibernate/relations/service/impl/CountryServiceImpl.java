package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.service.CountryService;

import java.util.Optional;

public class CountryServiceImpl implements CountryService {
   private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country add(Country country) {
        return countryDao.add(country);
    }

    @Override
    public Country get(Long id) {
        Optional<Country> optionalCountry = countryDao.get(id);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        } else {
            throw new RuntimeException("Country with id " + id + " not found");
        }
    }
}
