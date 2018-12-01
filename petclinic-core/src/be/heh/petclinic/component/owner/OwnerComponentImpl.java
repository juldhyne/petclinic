package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import javax.sql.DataSource;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao jdbcOwnerDaoImpl;

    public OwnerComponentImpl(JdbcOwnerDao jdbcOwnerDao, DataSource dataSource) {
        this.jdbcOwnerDaoImpl = jdbcOwnerDao;
        this.jdbcOwnerDaoImpl.setDatasource(dataSource);
    }

    @Override
    public Owner[] getOwners() {
        return jdbcOwnerDaoImpl.findAll();
    }

    @Override
    public Owner getOwners(int id) {
        return jdbcOwnerDaoImpl.findById(id);
    }

    @Override
    public Owner[] getOwners(String lastname) {
        return jdbcOwnerDaoImpl.findByLastname(lastname);
    }

    @Override
    public void insertOwner(Owner owner) {
        jdbcOwnerDaoImpl.insertOwner(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        jdbcOwnerDaoImpl.updateOwner(owner);
    }

}
